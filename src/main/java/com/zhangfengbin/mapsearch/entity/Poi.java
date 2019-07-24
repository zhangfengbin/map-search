package com.zhangfengbin.mapsearch.entity;

import java.io.Serializable;

public class Poi implements Serializable {
    private String id;
    private String name;//益佳康大药房

    private String type;//医疗保健服务;医药保健销售店;药房

    private String typecode;

    private Object address;//隆港社区029号
    private Object tel;//15539092777
    private String pname;//河南省
    private String cityname;//郑州市
    private String adname;//新郑市
    private String gridcode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Object getTel() {
        return tel;
    }

    public void setTel(Object tel) {
        this.tel = tel;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    public String getGridcode() {
        return gridcode;
    }

    public void setGridcode(String gridcode) {
        this.gridcode = gridcode;
    }

    @Override
    public String toString() {
        return "{" +

                "名称：'" + name + '\'' +
                ", 类型：'" + type + '\'' +
                ", 地址：" + pname+cityname+adname+address +
                ", 电话：" + tel +
                '}';
    }
}
