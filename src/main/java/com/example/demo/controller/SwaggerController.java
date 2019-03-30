package com.example.demo.controller;


import com.example.demo.bo.Condition;
import com.example.demo.bo.configs;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.exception.UserException;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping(value = "/boots")
@Api(value = "testController | 测试控制器")
public class SwaggerController {

    // 找不到bean用@Component注解，把userdao注入到spring中
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private configs config;

    @GetMapping(value = "/getUser/{id}")
    @ResponseBody
    @ApiOperation(value = "直接获取一个自定义user对象",notes = "这是notes")
    @ApiImplicitParam(paramType = "path", name = "id",value = "用户ID",required = true,dataType = "String")
    public User getUser(@PathVariable("id") String id) {
        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setUserName("test");
        return user;
    }

    @GetMapping(value = "/getUsers")
    @ResponseBody
    @ApiOperation(value = "直接获取一个自定义user对象",notes = "这是notes")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="header", name = "token", value = "token", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "id", value = "用户id", required = false, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "name", value = "用户姓名", required = true, dataType = "String"),
    })
    public User getUsers(@RequestParam(value = "id",required = false,defaultValue = "22") String id,
                         @RequestParam(value = "name", required = true) String name) {
        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setUserName(name);
        return user;
    }

    @PostMapping(value = "/getValues7")
    @ResponseBody
    @ApiOperation(value = "这是一个post",notes = "post_notes")
    public Condition getValues7(@RequestBody Condition condition) throws Exception {
        return condition;
    }


}