package com.mybatistest.demo.utils;

import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {

    private int totalCount; //总记录数
    private int totalPage; //总页码
    private int rows; //每页显示条数
    private int currPage; //当前页
    private List<T> list; //数据集合


}
