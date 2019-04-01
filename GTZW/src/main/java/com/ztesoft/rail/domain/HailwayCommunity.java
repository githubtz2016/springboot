package com.ztesoft.rail.domain;

import java.io.Serializable;

public class HailwayCommunity implements Serializable {

    private int ci;
    private Integer lineId;
    private int cityId;
    private int stationId;
    private String stationName;
    private int communityId;
    private String communityName;
    private int tac;
    private int ruid;
    private Double ruLong;
    private Double ruLat;
    private String isState;
    private int stateId;
    private int orderNum;

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public int getTac() {
        return tac;
    }

    public void setTac(int tac) {
        this.tac = tac;
    }

    public int getRuid() {
        return ruid;
    }

    public void setRuid(int ruid) {
        this.ruid = ruid;
    }

    public Double getRuLong() {
        return ruLong;
    }

    public void setRuLong(Double ruLong) {
        this.ruLong = ruLong;
    }

    public Double getRuLat() {
        return ruLat;
    }

    public void setRuLat(Double ruLat) {
        this.ruLat = ruLat;
    }

    public String getIsState() {
        return isState;
    }

    public void setIsState(String isState) {
        this.isState = isState;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }
}
