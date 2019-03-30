package com.example.demo.controller;

import com.example.demo.bo.configs;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.exception.UserException;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.ConfigurationSpi;
import javax.validation.Valid;
import java.util.List;

@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/boot")
public class BootController {

    // 找不到bean用@Component注解，把userdao注入到spring中
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private configs config;

    @GetMapping(value = "getUser")
    public User getUser() {
        User user = new User();
        user.setUserName("test");
        return user;
    }

    @RequestMapping(value = "getAllUser")
    @ResponseBody
    public List<User> getUsers() {
//        List<User> userList = userDao.selectUser();
        List<User> userList = userService.selectUser();
        System.out.print(userList);
        return userList;
    }

    @RequestMapping(value = "getOne")
    public User getOne(Long id) {
        return userDao.getOne((id));
    }

    @RequestMapping(value = "getView")
    public String getView(ModelMap m) {
        m.put("name", "1111122223334444555");
        return "show";
    }

    @Value("${test}")
    private String ss;

    @Value("${longTest}")
    private String sr;

    // 下面会报错 因为没有@ResponseBody，会返回模板
    /*
    @RestController注解，相当于@Controller+@ResponseBody两个注解的结合，返回json数据不需要在方法前面加@ResponseBody注解了，但使用@RestController这个注解，就不能返回jsp,html页面，视图解析器无法解析jsp,html页面
    如果需要返回数据到jsp或者html页面，则使用@Controller注解。这里推荐使用@Controller注解，因为需要直接返回数据的时候可以增加@ResponseBody注解
     */
    @RequestMapping(value = "getValues")
    @ResponseBody
    public String getValues() {
        return ss + "---" + sr;
    }

    @RequestMapping(value = "getValues2")
    @ResponseBody
    public String getValues2() {
        return config.getValue2() + config.getValue1();
    }

    @RequestMapping(value = "getValues3/{id}")
    @ResponseBody
    public String getValues3(@PathVariable String id) {
        return id;
    }

    @GetMapping(value = "getValues4")
    @ResponseBody
    public String getValues4(@RequestParam(value = "id", required = false, defaultValue = "0") String id) {
        return id;
    }

    @GetMapping(value = "/getValues5")
    @ResponseBody
    public String getValues5(@RequestParam(value = "id", required = false, defaultValue = "0") String id) {
        User s = new User("赵云", 33, "成都");
        userService.insertUser(s);
        return "ok";
    }

    @PostMapping(value = "/user")
    @ResponseBody
    public String postUser(@Valid User u, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // 获取错误信息
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        System.out.print(u);
        return null;
    }

    @RequestMapping(value = "/getValues6/{id}")
    @ResponseBody
    public String getValues6(@PathVariable Integer id) throws Exception {
        userService.judgeId(id);
        return "666666";
    }

    @RequestMapping(value = "/getValues7")
    @ResponseBody
    public String getValues7() throws Exception {
        return "666666";
    }


}