package com.springdemo.meetingreserve.web.rest;

import com.springdemo.meetingreserve.common.CommonResult;
import com.springdemo.meetingreserve.manager.RecordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    RecordManager recordManager;

    @RequestMapping("/getRecordList")
    public CommonResult getRecordList(){
        return CommonResult.ok(recordManager.getRecordList("inPrograss"));
    }
}
