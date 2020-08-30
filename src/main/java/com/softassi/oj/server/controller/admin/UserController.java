package com.softassi.oj.server.controller.admin;

import com.softassi.oj.server.dto.PageDto;
import com.softassi.oj.server.dto.ResultBody;
import com.softassi.oj.server.dto.UserDto;
import com.softassi.oj.server.object.User;
import com.softassi.oj.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName : UserController
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-22 22:38
 */
@RestController(value = "adminUserController")
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

    @RequestMapping("/all")
    public ResultBody all() {
        List<User> users = userService.all();
        return ResultBody.success(users);
    }
    @RequestMapping("/list")
    public ResultBody list(@RequestBody PageDto pageDto) {
        List<UserDto> list = userService.list(pageDto);
        return ResultBody.success(list);
    }

    @RequestMapping("/get")
    public ResultBody get() {
        log.info("");
        return ResultBody.success();
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

        // userService.savePassword(userDto);
        return ResultBody.success(userDto);
    }

    @PostMapping("/login")
    public ResultBody login(@RequestBody UserDto userDto, HttpServletRequest request) {
        log.info("用户登录开始");
        userDto.setPassword(DigestUtils.md5DigestAsHex(userDto.getPassword().getBytes()));

        // 根据验证码token去获取缓存中的验证码，和用户输入的验证码是否一致
        // String imageCode = (String) redisTemplate.opsForValue().get(userDto.getImageCodeToken());
        // log.info("从redis中获取到的验证码：{}", imageCode);
        // if (StringUtils.isEmpty(imageCode)) {
        //     // responseDto.setSuccess(false);
        //     // responseDto.setMessage("验证码已过期");
        //     // log.info("用户登录失败，验证码已过期");
        //     // return responseDto;
        // }
        // if (!imageCode.toLowerCase().equals(userDto.getImageCode().toLowerCase())) {
        //     responseDto.setSuccess(false);
        //     responseDto.setMessage("验证码不对");
        //     LOG.info("用户登录失败，验证码不对");
        //     return responseDto;
        // }
        // else {
        //     // 验证通过后，移除验证码
        //     // request.getSession().removeAttribute(userDto.getImageCodeToken());
        //     redisTemplate.delete(userDto.getImageCodeToken());
        // }
        //
        // LoginUserDto loginUserDto = userService.login(userDto);
        // String token = UuidUtil.getShortUuid();
        // loginUserDto.setToken(token);
        // // request.getSession().setAttribute(Constants.LOGIN_USER, loginUserDto);
        // redisTemplate.opsForValue().set(token, JSON.toJSONString(loginUserDto), 3600, TimeUnit.SECONDS);
        // responseDto.setContent(loginUserDto);
        return ResultBody.success();
    }

    /**
     * 退出登录
     */
    @GetMapping("/logout/{token}")
    public ResultBody logout(@PathVariable String token) {
        redisTemplate.delete(token);
        log.info("从redis中删除token:{}", token);
        return ResultBody.success();
    }
}
