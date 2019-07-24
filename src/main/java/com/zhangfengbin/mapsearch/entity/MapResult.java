package com.zhangfengbin.mapsearch.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MapResult implements Serializable {

    private String status;

    private String count;

    private String info;

    private String infocode;

    private List<Poi> pois = new ArrayList<Poi>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public List<Poi> getPois() {
        return pois;
    }

    public void setPois(List<Poi> pois) {
        this.pois = pois;
    }

    @Override
    public String toString() {
        return "MapResult{" +
                "status='" + status + '\'' +
                ", count='" + count + '\'' +
                ", info='" + info + '\'' +
                ", infocode='" + infocode + '\'' +
                ", pois=" + pois +
                '}';
    }
}
