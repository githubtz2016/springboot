package com.ztesoft.rail.xmlEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ModifyBody {
    /**
     * 管理员从帐号
     */
    @XmlElement(name = "OPERATORID")
    private String operatorId;

    /**
     * 管理员密码
     */
    @XmlElement(name = "OPERATORPWD")
    private String operatorPwd;

    /**
     * 操作类型
     */
    @XmlElement(name = "MODIFYMODE")
    private String modifyMode;

    /**
     * 人员信息
     */
    @XmlElement(name = "USERINFO")
    private UserInfo userinfo;

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorPwd() {
        return operatorPwd;
    }

    public void setOperatorPwd(String operatorPwd) {
        this.operatorPwd = operatorPwd;
    }

    public String getModifyMode() {
        return modifyMode;
    }

    public void setModifyMode(String modifyMode) {
        this.modifyMode = modifyMode;
    }

    public UserInfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserInfo userinfo) {
        this.userinfo = userinfo;
    }
}
