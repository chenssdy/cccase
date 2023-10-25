package com.chendys.webbackend.controller;


import com.chendys.webbackend.pojo.RollRoomAccessories;
import com.chendys.webbackend.pojo.dto.RollRoomDto;
import com.chendys.webbackend.pojo.vo.Page;
import com.chendys.webbackend.pojo.vo.RollRoomVo;
import com.chendys.webbackend.service.RollRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rollRooms")
public class RollRoomController {

    @Autowired
    private RollRoomService rollRoomService;


    /**
     * 获roll房列表
     * @param page 当前页码
     * @param num 每页多少条数据
     * @return
     */
    @GetMapping("/get")
    public Page<RollRoomVo> getList(@RequestParam("page") Integer page, @RequestParam("num") Integer num) {
        return rollRoomService.getRollRoomList(page, num);
    }

    /**
     * 创建roll房
     * @param roomDto
     * @return
     */
    @PostMapping("/create")
    public RollRoomVo createRollRoom(@RequestBody RollRoomDto roomDto){
        return rollRoomService.createRollRoom(roomDto);
    };

    /**
     * 添加roll房饰品
     * @param
     * @return
     */
    @PostMapping("/addRRAcc")
    public RollRoomAccessories addRollRoomAcc(@RequestParam("rid") Integer rid,@RequestParam("aid") Integer aid){
        return rollRoomService.addRollRoomAcc(rid, aid);
    };

    /**
     * 删除roll房饰品
     * @param
     * @return
     */
    @PostMapping("/delRRAcc/{id}")
    public String deleteRollRoomAcc(@PathVariable Integer id){
        return rollRoomService.deleteRollRoomAcc(id);
    };

    /**
     * 修改roll房饰品
     * @param
     * @return
     */
    @PostMapping("/updateRRAcc")
    public RollRoomAccessories updateRollRoomAcc(@RequestParam("id") Integer id,@RequestParam("aid") Integer aId){
        return rollRoomService.updateRollRoomAcc(id, aId);
    };

}
