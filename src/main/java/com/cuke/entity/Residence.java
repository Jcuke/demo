/*
 * Residence.java
 * Copyright(C) 2015-2015 jarparts
 * All rights reserved.
 * -----------------------------------------------
 * 2017-05-19 Created
 */
package com.cuke.entity;

import com.cuke.dao.bean.XModel;

import java.math.BigDecimal;

/**
 * 
 * @author 
 * @version 1.0 2017-05-19
 */
public class Residence extends XModel{

    private Integer id;
    private String title;
    private String district;
    private String districtid;
    private String city;
    private String cityid;
    private String xiaoqu;
    private String xiaoquid;
    private BigDecimal jiage;
    private BigDecimal danjia;
    private Float area;
    private String fyurl;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getDistrictid() {
        return districtid;
    }
    public void setDistrictid(String districtid) {
        this.districtid = districtid;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCityid() {
        return cityid;
    }
    public void setCityid(String cityid) {
        this.cityid = cityid;
    }
    public String getXiaoqu() {
        return xiaoqu;
    }
    public void setXiaoqu(String xiaoqu) {
        this.xiaoqu = xiaoqu;
    }
    public String getXiaoquid() {
        return xiaoquid;
    }
    public void setXiaoquid(String xiaoquid) {
        this.xiaoquid = xiaoquid;
    }
    public BigDecimal getJiage() {
        return jiage;
    }
    public void setJiage(BigDecimal jiage) {
        this.jiage = jiage;
    }
    public BigDecimal getDanjia() {
        return danjia;
    }
    public void setDanjia(BigDecimal danjia) {
        this.danjia = danjia;
    }
    public Float getArea() {
        return area;
    }
    public void setArea(Float area) {
        this.area = area;
    }

    public String getFyurl() {
        return fyurl;
    }

    public void setFyurl(String fyurl) {
        this.fyurl = fyurl;
    }

    @Override
    public String toString() {
        return "Residence{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", district='" + district + '\'' +
                ", districtid='" + districtid + '\'' +
                ", city='" + city + '\'' +
                ", cityid='" + cityid + '\'' +
                ", xiaoqu='" + xiaoqu + '\'' +
                ", xiaoquid='" + xiaoquid + '\'' +
                ", jiage=" + jiage +
                ", danjia=" + danjia +
                ", area=" + area +
                ", fyurl='" + fyurl + '\'' +
                '}';
    }
}