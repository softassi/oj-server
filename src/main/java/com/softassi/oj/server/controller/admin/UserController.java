package com.softassi.oj.server.controller.admin;

import com.softassi.oj.server.dto.LoginUserDto;
import com.softassi.oj.server.dto.PageDto;
import com.softassi.oj.server.dto.ResultBody;
import com.softassi.oj.server.dto.UserDto;
import com.softassi.oj.server.object.User;
import com.softassi.oj.server.service.UserService;
import com.softassi.oj.server.util.JsonUtils;
import com.softassi.oj.server.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName : UserController
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-22 22:38
 */
@RestController(value = "adminUserController")
@RequestMapping("/admin/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("/save")
    public ResultBody save(@RequestBody UserDto userDto) {
        UserDto save = userService.save(userDto);
        return ResultBody.success(save);
    }

    @GetMapping("/all")
    public ResultBody all() {
        List<User> users = userService.all();
        return ResultBody.success(users);
    }
    @GetMapping("/list")
    public ResultBody list(@RequestBody PageDto pageDto) {
        List<UserDto> list = userService.list(pageDto);
        return ResultBody.success(list);
    }

    @GetMapping("/get/{id}")
    public ResultBody get(@PathVariable("id") String id) {
        UserDto userDto = userService.get(id);
        return ResultBody.success(userDto);
    }

    @RequestMapping("/delete/{id}")
    public ResultBody delete(@PathVariable("id") String id) {
        userService.delete(id);
        return ResultBody.success();
    }

    /**
     * 重置密码
     */
    @PostMapping("/save-password")
    public ResultBody savePassword(@RequestBody UserDto userDto) {
        userDto.setPassword(DigestUtils.md5DigestAsHex(userDto.getPassword().getBytes()));
        // 先保存密码
        UserDto result = userService.savePassword(userDto);
        return ResultBody.success(result);
    }

    @PostMapping("/login")
    public ResultBody login(@RequestBody UserDto userDto, HttpServletRequest request) {
        log.info("用户登录开始");
        userDto.setPassword(DigestUtils.md5DigestAsHex(userDto.getPassword().getBytes()));

        // 根据验证码token去获取缓存中的验证码，和用户输入的验证码是否一致
        String imageCode = (String) redisTemplate.opsForValue().get(userDto.getImageCodeToken());
        log.info("从redis中获取到的验证码：{}", imageCode);
        if (StringUtils.isEmpty(imageCode)) {
            log.info("用户登录失败，验证码已过期");
            return ResultBody.error("验证码已过期");
        }
        if (!imageCode.toLowerCase().equals(userDto.getImageCode().toLowerCase())) {
            log.info("用户登录失败，验证码不对");
            return ResultBody.error("验证码不对");
        }
        else {
            // 验证通过后，移除验证码
            redisTemplate.delete(userDto.getImageCodeToken());
        }
        //
        LoginUserDto loginUserDto = userService.login(userDto);
        String token = UuidUtil.getShortUuid();
        loginUserDto.setToken(token);
        redisTemplate.opsForValue().set(token, JsonUtils.obj2JsonStr(loginUserDto), 3600, TimeUnit.SECONDS);
        return ResultBody.success(loginUserDto);
    }

    /**
     * 退出登录
     */
    @GetMapping("/logout/{token}")
    public ResultBody logout(@PathVariable String token) {
        log.info("从redis中删除token:{}", token);
        redisTemplate.delete(token);
        return ResultBody.success();
    }
}
