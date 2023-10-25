package com.chendys.webbackend.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @author chenssdy
 * @description 分页实体
 * @createDate 2022-11-20 16:47
 */
@Data
public class Page<T> {
    /**
     * 当前页码
     */
    private Integer pageNum;
    /**
     * 每页数量
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 总条数
     */
    private Long total;
    /**
     * 分页数据
     */
    private List<T> list;

    /**
     * 数据偏移量
     */
    private Integer offset;

    public Page(Integer sheet, Integer num) {
        this.pageNum = sheet;
        this.pageSize = num;
        this.offset = (sheet - 1) * num;
    }

    public Page() {

    }

    public Integer getTotalPage() {
        if(total == 0){
            return 0;
        }
        long _totalPage = total / pageSize;
        _totalPage = total - (_totalPage * pageSize) > 0 ? ++_totalPage : _totalPage;
        return Math.toIntExact(_totalPage);
    }

    public int offset() {
        return (pageNum - 1) * pageSize;
    }
}
