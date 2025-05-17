package com.example.daiying_backend.controller;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.pojo.Position;
import com.example.daiying_backend.pojo.Search;
import com.example.daiying_backend.service.api.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/position")
public class PositionController {

    @Autowired
    PositionService positionService;

    @PostMapping("/getAllPosition")
    public CommonResult getAllPosition(@RequestBody Search search){
        return positionService.getAllPosition(search);
    }

    @PostMapping("/createPosition")
    public CommonResult createPosition(@RequestBody Position position){
        return positionService.createPosition(position);
    }

    @PostMapping("/updatePosition")
    public CommonResult updatePosition(@RequestBody Position position){
        return positionService.updatePosition(position);
    }

    @DeleteMapping("/deletePosition")
    public CommonResult updatePosition(@RequestParam Integer id){
        return positionService.deleteById(id);
    }

    @GetMapping("/getById")
    public CommonResult getById(@RequestParam Integer id){
        return positionService.getById(id);
    }
}
