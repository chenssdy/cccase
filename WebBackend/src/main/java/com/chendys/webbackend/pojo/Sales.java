package com.chendys.webbackend.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * 销售量实体类
 */
@Data
public class Sales implements Serializable {

    private static final long serialVersionUID = -182525251L;

    private Integer id;

    /**
     * 销售量
     */
    private long sales;

    /**
     * 统计时间
     */
    private Date countTime;

    /**
     * 时间字符串
     */
    private String dateStr;

}
