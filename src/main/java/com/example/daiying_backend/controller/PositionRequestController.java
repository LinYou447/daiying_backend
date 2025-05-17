package com.example.daiying_backend.controller;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.pojo.PositionRequest;
import com.example.daiying_backend.pojo.Search;
import com.example.daiying_backend.service.api.PositionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/positionRequest")
public class PositionRequestController {

    @Autowired
    PositionRequestService positionRequestService;

    @PostMapping("/getAllPositionRequest")
    public CommonResult getAllPositionRequest(@RequestBody Search search){
        return positionRequestService.getAllPositionRequest(search);
    }

    @PostMapping("/createPositionRequest")
    public CommonResult createPositionRequest(@RequestBody PositionRequest PositionRequest){
        return positionRequestService.createPositionRequest(PositionRequest);
    }

    @PostMapping("/updatePositionRequestRequest")
    public CommonResult updatePositionRequest(@RequestBody PositionRequest PositionRequest){
        return positionRequestService.updatePositionRequest(PositionRequest);
    }

    @DeleteMapping("/deletePositionRequest")
    public CommonResult updatePositionRequest(@RequestParam Integer id){
        return positionRequestService.deleteById(id);
    }

    @GetMapping("/getById")
    public CommonResult getById(@RequestParam Integer id){
        return positionRequestService.getById(id);
    }

    @GetMapping("/getByUserId")
    public CommonResult getByUserId(@RequestParam Integer userId){
        return positionRequestService.getByUserId(userId);
    }
}
