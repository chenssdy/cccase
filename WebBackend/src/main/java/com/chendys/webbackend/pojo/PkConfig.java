package com.chendys.webbackend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tb_pk_config
 */
@TableName(value ="tb_pk_config")
@Data
public class PkConfig implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 单人模式最小盲盒数
     */
    private Integer singlePlayerMinCase;

    /**
     * 单人模式最大盲盒数
     */
    private Integer singlePlayerMaxCase;

    /**
     * 双人模式最小盲盒数
     */
    private Integer doublePlayerMinCase;

    /**
     * 双人模式最大盲盒数
     */
    private Integer doublePlayerMaxCase;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PkConfig other = (PkConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSinglePlayerMinCase() == null ? other.getSinglePlayerMinCase() == null : this.getSinglePlayerMinCase().equals(other.getSinglePlayerMinCase()))
            && (this.getSinglePlayerMaxCase() == null ? other.getSinglePlayerMaxCase() == null : this.getSinglePlayerMaxCase().equals(other.getSinglePlayerMaxCase()))
            && (this.getDoublePlayerMinCase() == null ? other.getDoublePlayerMinCase() == null : this.getDoublePlayerMinCase().equals(other.getDoublePlayerMinCase()))
            && (this.getDoublePlayerMaxCase() == null ? other.getDoublePlayerMaxCase() == null : this.getDoublePlayerMaxCase().equals(other.getDoublePlayerMaxCase()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSinglePlayerMinCase() == null) ? 0 : getSinglePlayerMinCase().hashCode());
        result = prime * result + ((getSinglePlayerMaxCase() == null) ? 0 : getSinglePlayerMaxCase().hashCode());
        result = prime * result + ((getDoublePlayerMinCase() == null) ? 0 : getDoublePlayerMinCase().hashCode());
        result = prime * result + ((getDoublePlayerMaxCase() == null) ? 0 : getDoublePlayerMaxCase().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", singlePlayerMinCase=").append(singlePlayerMinCase);
        sb.append(", singlePlayerMaxCase=").append(singlePlayerMaxCase);
        sb.append(", doublePlayerMinCase=").append(doublePlayerMinCase);
        sb.append(", doublePlayerMaxCase=").append(doublePlayerMaxCase);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}