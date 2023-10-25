package com.chendys.webbackend.pojo.dto;

import com.chendys.webbackend.pojo.Condition;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class RollRoomDto implements Serializable {


    private String name;

    private long openingHours;

    private long endTime;

    private String coverImg;

    List<Integer> conditionsId;

}
