package com.springdemo.meetingreserve.web.rest;

import com.springdemo.meetingreserve.common.CommonResult;
import com.springdemo.meetingreserve.manager.UserManager;
import com.springdemo.meetingreserve.web.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController  //@RestController = @Controller + @ResponseBody
@RequestMapping("/test")
public class LoginController {

    @Autowired
    private UserManager userManager;

    @RequestMapping("/loginVerify")
    public CommonResult loginVerify(@RequestParam String mobile,@RequestParam String password){
        LoginForm loginForm = new LoginForm();
        loginForm.setMobile(mobile);
        loginForm.setPassword(password);
        if(userManager.login(loginForm.getMobile(),loginForm.getPassword())){
            return CommonResult.ok(Boolean.TRUE);
        }
        return CommonResult.ok(Boolean.FALSE);
    }
}
