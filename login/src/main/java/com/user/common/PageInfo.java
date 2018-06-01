package com.user.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * author: xiao
 * date:   2018/5/31
 * desc:    公共分页包装类
 */
@ApiModel(description = "分页数据包装类")
public class PageInfo<T> {

    @ApiModelProperty("页码")
    private Integer pageNum;

    @ApiModelProperty("页记录条数")
    private Integer pageSize;

    @ApiModelProperty("总记录条数")
    private Long count;

    @ApiModelProperty("数据")
    private T data;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public PageInfo() {
    }

    public PageInfo(T data) {
        this.data = data;
    }

    public PageInfo(Integer pageNum, Integer pageSize, Long count, T data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.count = count;
        this.data = data;
    }

    /**
     * 每页记录条数检查
     * @param pageSize：每页记录条数
     * @return
     */
    public static int checkPageSize(Integer pageSize){
        if (pageSize == null || pageSize == 0){
            return 10;
        }
        return pageSize;
    }

    /**
     * 参数页码检查
     * @param pageNum:页数
     * @return
     */
    public static int checkPageNum(Integer pageNum){
        if (pageNum == null || pageNum == 0){
            return 1;
        }
        return pageNum;
    }
}
