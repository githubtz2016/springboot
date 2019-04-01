package com.ztesoft.rail.xmlEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class UserHead {
    @XmlElement(
            name = "CODE"
    )
    private String code;
    @XmlElement(
            name = "SID"
    )
    private String sid;
    @XmlElement(
            name = "TIMESTAMP"
    )
    private String timestamp;
    @XmlElement(
            name = "SERVICEID"
    )
    private String serviceId;

    public UserHead() {
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSid() {
        return this.sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}

