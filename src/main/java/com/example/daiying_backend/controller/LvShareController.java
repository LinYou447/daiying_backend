package com.example.daiying_backend.controller;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.pojo.LvShare;
import com.example.daiying_backend.service.api.LvShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lvShare")
public class LvShareController {

    @Autowired
    LvShareService lvShareService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody LvShare lvShare){
        return lvShareService.createShare(lvShare);
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody LvShare lvShare){
        return lvShareService.updateShare(lvShare);
    }

    @DeleteMapping("/delete")
    public CommonResult delete(@RequestParam Integer id){
        return lvShareService.deleteById(id);
    }

    @GetMapping("/getById")
    public CommonResult getById(@RequestParam Integer id){
        return lvShareService.getById(id);
    }

    @GetMapping("/getAll")
    public CommonResult getAll(){
        return lvShareService.getAllShare();
    }

}
