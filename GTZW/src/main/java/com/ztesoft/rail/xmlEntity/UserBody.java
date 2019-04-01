package com.ztesoft.rail.xmlEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class UserBody {
    @XmlElement(
            name = "RSP"
    )
    private String rsp;
    @XmlElement(
            name = "MAINACCTID"
    )
    private String mainacctId;
    @XmlElement(
            name = "APPACCTID"
    )
    private String appacctId;

    public UserBody() {
    }

    public String getRsp() {
        return this.rsp;
    }

    public void setRsp(String rsp) {
        this.rsp = rsp;
    }

    public String getMainacctId() {
        return this.mainacctId;
    }

    public void setMainacctId(String mainacctId) {
        this.mainacctId = mainacctId;
    }

    public String getAppacctId() {
        return this.appacctId;
    }

    public void setAppacctId(String appacctId) {
        this.appacctId = appacctId;
    }
}
