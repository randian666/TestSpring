package com.springmvc.demo.domain;

import java.util.List;

/**
 * 分页
 * Created by LiuXun on 2017/9/2.
 */
public class PageUtils<T> {
    //当前页码
    private int currentPage;
    //每页记录条数
    private int numPerPage;
    //总记录条数
    private int totalCount;
    //总页数
    private int totalPageNum;
    //数据
    private List<T> obj;
    public PageUtils(){}

    public PageUtils(int currentPage, int numPerPage, int totalCount, int totalPageNum, List<T> obj) {
        this.currentPage = currentPage;
        this.numPerPage = numPerPage;
        this.totalCount = totalCount;
        this.totalPageNum = totalPageNum;
        this.obj = obj;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public List<T> getObj() {
        return obj;
    }

    public void setObj(List<T> obj) {
        this.obj = obj;
    }
}
