package com.chendys.webbackend.pojo.vo;


import com.chendys.webbackend.pojo.Accessories;
import com.chendys.webbackend.pojo.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserVo extends User implements Serializable {

    private List<Accessories> accessories;
}
