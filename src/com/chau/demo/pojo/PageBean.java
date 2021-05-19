package com.chau.demo.pojo;

/**
 * @author wilfred
 * 编程实现分页功能类的封装
 */
public class PageBean {

    private int page; // 描述页面中的页码信息
    private int row; // 描述页面中每一页记录数的信息
    private int start; // 描述起始记录下标的信息

    public PageBean() {
    }

    public PageBean(int page, int row) {
        this.page = page;
        this.row = row;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getStart() {
        // 这里要获取的是接下来从下标为多少的记录开始查询
        // （页数-1）* 每页的记录数 = 起始下标
        return (page - 1) * row;
    }
}
