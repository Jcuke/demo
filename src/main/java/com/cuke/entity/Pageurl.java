/*
 * Pageurl.java
 * Copyright(C) 2015-2015 jarparts
 * All rights reserved.
 * -----------------------------------------------
 * 2017-05-25 Created
 */
package com.cuke.entity;

import com.cuke.dao.bean.XModel;

/**
 * 
 * @author 
 * @version 1.0 2017-05-25
 */
public class Pageurl extends XModel {

    private Integer id;
    private String pageurl;
    private Long date;
    private Integer success;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPageurl() {
        return pageurl;
    }
    public void setPageurl(String pageurl) {
        this.pageurl = pageurl;
    }
    public Long getDate() {
        return date;
    }
    public void setDate(Long date) {
        this.date = date;
    }
    public Integer getSuccess() {
        return success;
    }
    public void setSuccess(Integer success) {
        this.success = success;
    }
}