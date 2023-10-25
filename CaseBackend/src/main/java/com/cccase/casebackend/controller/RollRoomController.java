package com.cccase.casebackend.controller;

import com.cccase.casebackend.pojo.vo.RollRoomVo;
import com.cccase.casebackend.service.RollRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rollRoom")
public class RollRoomController {


    @Autowired
    private RollRoomService rollRoomService;


    @GetMapping("/get")
    public List<RollRoomVo> getRRs(){
        return rollRoomService.getRRs();
    }

    @PostMapping("/join/{rrId}")
    public Boolean JoinRollRoom(@PathVariable Integer rrId){
        return rollRoomService.joinRollRoom(rrId);
    }
}
