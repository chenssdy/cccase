package com.cccase.casebackend.pojo.vo;

import com.cccase.casebackend.pojo.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode
public class UserVo implements Serializable {

    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户电话号码
     */
    private String phone;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户余额
     */

    private BigDecimal balance;

    /**
     * 用户积分
     */
    private Long integral;

    /**
     * 用户等级
     */
    private Integer lv;

    /**
     * 充值金额
     */
    private BigDecimal rechargeAmount;

    /**
     * 状态(1.正常,2.非法行为冻结)
     */
    private Integer status;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    private List<UserBackpackVo> userBackpackVos;

    private String token;


    public UserVo(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.phone = user.getPhone();
        this.account = user.getAccount();
        this.password = user.getPassword();
        this.balance = user.getBalance();
        this.integral = user.getIntegral();
        this.lv = user.getLv();
        this.rechargeAmount = user.getRechargeAmount();
        this.status = user.getStatus();
        this.updateTime = user.getUpdateTime();
        this.createTime = user.getCreateTime();
    }
}
