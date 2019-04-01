package com.ztesoft.rail.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private static final long serialVersionUID = 934073895746700367L;
    private String userId;
    private String mainAcctId;
    private String mainPwd;
    private String loginNo;
    private String userName;
    private String orgId;
    private String email;
    private String mobile;
    private String password;
    private String EFFECT_DATE;
    private String EXPIRE_DATE;
    private String APP_ACCT_DESC;
    private String APP_ACCT_STATUS;
    public User() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMainAcctId() {
        return mainAcctId;
    }

    public void setMainAcctId(String mainAcctId) {
        this.mainAcctId = mainAcctId;
    }

    public String getMainPwd() {
        return mainPwd;
    }

    public void setMainPwd(String mainPwd) {
        this.mainPwd = mainPwd;
    }

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEFFECT_DATE() {
        return EFFECT_DATE;
    }

    public void setEFFECT_DATE(String EFFECT_DATE) {
        this.EFFECT_DATE = EFFECT_DATE;
    }

    public String getEXPIRE_DATE() {
        return EXPIRE_DATE;
    }

    public void setEXPIRE_DATE(String EXPIRE_DATE) {
        this.EXPIRE_DATE = EXPIRE_DATE;
    }

    public String getAPP_ACCT_DESC() {
        return APP_ACCT_DESC;
    }

    public void setAPP_ACCT_DESC(String APP_ACCT_DESC) {
        this.APP_ACCT_DESC = APP_ACCT_DESC;
    }

    public String getAPP_ACCT_STATUS() {
        return APP_ACCT_STATUS;
    }

    public void setAPP_ACCT_STATUS(String APP_ACCT_STATUS) {
        this.APP_ACCT_STATUS = APP_ACCT_STATUS;
    }
}
