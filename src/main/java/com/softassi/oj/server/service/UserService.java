package com.softassi.oj.server.service;

import com.softassi.oj.server.dto.LoginUserDto;
import com.softassi.oj.server.dto.PageDto;
import com.softassi.oj.server.dto.UserDto;
import com.softassi.oj.server.object.User;
import com.softassi.oj.server.repository.UserRepository;
import com.softassi.oj.server.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName : UserService
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-22 22:37
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User save() {
        User user = new User("cy");
        userRepository.save(user);
        return user;
    }
    public UserDto save(UserDto userDto) {
        User copy = CopyUtil.copy(userDto, User.class);
        User save = userRepository.save(copy);
        return CopyUtil.copy(save, UserDto.class);
    }

    public UserDto savePassword(UserDto userDto) {
        Optional<User> userOptional = userRepository.findById(userDto.getId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPassword(userDto.getPassword());
            userRepository.save(user);
            return CopyUtil.copy(user, UserDto.class);
        }
        else {
            // todo
        }
        return null;
    }

    public List<User> all() {
        return userRepository.findAll();
    }

    public UserDto get(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(user -> CopyUtil.copy(user, UserDto.class)).orElse(null);
    }

    public List<UserDto> list(PageDto pageDto) {
        PageRequest of = PageRequest.of(pageDto.getPage(), pageDto.getSize());
        Page<User> userPage = userRepository.findAll(of);
        List<User> content = userPage.getContent();
        return CopyUtil.copyList(content, UserDto.class);
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public void update(UserDto userDto) {
        User copy = CopyUtil.copy(userDto, User.class);
        userRepository.save(copy);
    }

    public UserDto reset(UserDto userDto) {
        String userId = userDto.getId();
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPassword(userDto.getPassword());
            userRepository.save(user);
            return CopyUtil.copy(user, UserDto.class);
        }
        else {
            // todo
            throw new RuntimeException("错误");
        }
    }

    /**
     * 登陆
     * @param userDto
     */
    public LoginUserDto login(UserDto userDto) {
        User user = userRepository.findUserByName(userDto.getName());
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        else {
            if (user.getPassword().equals(userDto.getPassword())) {
                return CopyUtil.copy(user, LoginUserDto.class);
            }
            else {
                throw new RuntimeException("用户名或密码错误");
            }
        }
    }
}
