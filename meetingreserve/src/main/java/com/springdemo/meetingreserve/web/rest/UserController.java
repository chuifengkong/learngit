package com.springdemo.meetingreserve.web.rest;

import com.springdemo.meetingreserve.common.CommonResult;
import com.springdemo.meetingreserve.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserManager userManager;

    @RequestMapping("/getBoardroomList")
    public CommonResult getBoardroomList(){
        String boardroomName = null;
        int currentPage = 1;
//        System.out.println(ThreadUtil.get().getId());
        return CommonResult.ok(userManager.getBoardroomList(boardroomName));
    }

    @RequestMapping("/getReservation")
    public CommonResult getReservation(){
        Long boardroomId = 1L;
        int currentPage = 1;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse("2019-04-15");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return CommonResult.ok(userManager.getReservationList(boardroomId,date));
    }
}
