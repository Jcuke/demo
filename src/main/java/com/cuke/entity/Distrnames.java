/*
 * Distrnames.java
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
public class Distrnames extends XModel {

    private Integer id;
    private String cityid;
    private String city;
    private String districtid;
    private String district;

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
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getDistrictid() {
        return districtid;
    }
    public void setDistrictid(String districtid) {
        this.districtid = districtid;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
}