package com.example.springproject.common;

import java.util.List;


public class PagingData<T> {
    private Integer totalPage;
    private Integer currentPage;
    private List<T> data;

    public PagingData(Integer totalPage, Integer currentPage, List<T> data) {
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.data = data;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public PagingData() {
    }
}
