package com.chendys.webbackend.pojo.vo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@ToString
public class AdminVo {

    /**
     *
     */
    private Integer id;

    /**
     * 管理员名
     */
    private String name;

    /**
     * 管理员邮箱
     */
    private String email;

    /**
     * 管理员手机号
     */
    private String phone;

    /**
     * 管理员账号
     */
    private String account;

    /**
     * 管理员头像url
     */
    private String imgUrl;

    /**
     * token
     */
    private String token;

    public AdminVo(Integer id, String name, String email, String phone, String account, String imgUrl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.account = account;
        this.imgUrl = imgUrl;
    }
}
