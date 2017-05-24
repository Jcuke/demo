/*
 * Districturl.java
 * Copyright(C) 2015-2015 jarparts
 * All rights reserved.
 * -----------------------------------------------
 * 2017-05-24 Created
 */
package com.cuke.entity;

import com.cuke.dao.bean.XModel;

/**
 * 
 * @author 
 * @version 1.0 2017-05-24
 */
public class Districturl extends XModel {

    private Integer id;
    private String cityid;
    private String districtid;
    private String url;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCityid() {
        return cityid;
    }
    public void setCityid(String cityid) {
        this.cityid = cityid;
    }
    public String getDistrictid() {
        return districtid;
    }
    public void setDistrictid(String districtid) {
        this.districtid = districtid;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}