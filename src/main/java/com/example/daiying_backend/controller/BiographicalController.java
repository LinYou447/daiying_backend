package com.example.daiying_backend.controller;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.pojo.Biographical;
import com.example.daiying_backend.service.api.BiographicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/biographical")
public class BiographicalController {

    @Autowired
    BiographicalService biographicalService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Biographical biographical){
        return biographicalService.createBiographical(biographical);
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody Biographical biographical){
        return biographicalService.updateBiographical(biographical);
    }

    @DeleteMapping("/delete")
    public CommonResult delete(@RequestParam Integer id){
        return biographicalService.deleteById(id);
    }

    @GetMapping("/getByUserId")
    public CommonResult getByUserId(@RequestParam Integer userId){
        return biographicalService.getByUserId(userId);
    }

    @GetMapping("/getByPhone")
    public CommonResult getByPhone(@RequestParam String phone){
        return biographicalService.getByPhone(phone);
    }

    @GetMapping("/getById")
    public CommonResult getById(@RequestParam Integer id){
        return biographicalService.getById(id);
    }

    @GetMapping("/getAllBiographical")
    public CommonResult getAllBiographical(){
        return biographicalService.getAllBiographical();
    }
}
