package com.ztesoft.rail.log;

import javax.xml.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;


@XmlAccessorType(XmlAccessType.FIELD)
public class FourAccountLogMsg {


    public FourAccountLogMsg() {
        resourceKind = "1";
        identityName="4ABOSSLog";
        resourceCode = "";
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        idrCreationTime=sd.format(new Date());
    }

    /**
     * 管理实体名称，用于采集业务处理。
     */
    @XmlElement(name = "IDENTITY_NAME")
    private String identityName;

    /**
     * 资源类别，对于应用来说值为“1”
     */
    @XmlElement(name = "RESOURCE_KIND")
    private String resourceKind;

    /**
     * 资源编码，每种应用系统对应一种资源编码
     */
    @XmlElement(name = "RESOURCE_CODE")
    private String resourceCode;

    /**
     * 消息日志创建时间，格式为YYYY-MM-DD HH:mm:ss
     */
    @XmlElement(name = "IDR_CREATION_TIME")
    private String idrCreationTime;

    /**
     * 应用从帐号，用户登录应用系统使用的帐号
     */
    @XmlElement(name = "SUB_ACCOUNT_NAME")
    private String subAccountName;

    /**
     * 操作时间，格式为YYYY-MM-DD HH:mm:ss
     */
    @XmlElement(name = "OPERATE_TIME")
    private String operateTime;

    /**
     * 操作类型编码:
     * 应用侧定义的操作类型ID,如1-BOSS-10677（固定格式，1-应用编码-xxxxx
     * 不清楚请联系审计侧）
     */
    @XmlElement(name = "OP_TYPE_ID")
    private String opTypeId;

    /**
     * 操作类型名称:
     * 所进行的具体操作名称,如：异地补换卡回滚
     */
    @XmlElement(name = "OP_TYPE_NAME")
    private String opTypeName;

    /**
     * 操作级别ID:
     * 该操作的级别：5-严重、4-警告、3-敏感、2-重要、1-一般
     */
    @XmlElement(name = "OP_LEVEL_ID")
    private String opLevelId;

    /**
     * 操作内容:
     * 传递操作的具体内容
     * 限定格式: name=value 如果有多个以,分隔
     * 例如：更新自定义资源目录实体：实体ID=100041,实体类型=2,主账号ID=10000001,资源别名=AutoTestingHost,备注=gexinghua
     * 用户关注的字段采用特殊格式存储，如果手机号是特殊字段 ，那么操作内容按照以下方式定义：
     * 新增主账号:姓名=zym,年龄=18,#[#mobile=134262266303,id=11011119761213152#]#（操作内容不可为空，不可含有“”号，换行符等特殊符号）
     */
    @XmlElement(name = "OPERATE_CONTENT")
    private String operateContent;


    /**
     * 操作结果:
     * 0-成功 1-失败
     */
    @XmlElement(name = "OPERATE_RESULT")
    private String operateResult;

    /**
     * 模块ID:
     * 应用操作的菜单编号，对应于权限系统ID（应用侧模块ID，应用侧定义）
     */
    @XmlElement(name = "MODULE_ID")
    private String moduleId;

    /**
     * 模块名称:
     * 应用操作的菜单名称
     */
    @XmlElement(name = "MODULE_NAME")
    private String moduleName;

    /**
     * 客户端通信IP地址:
     * 标准ip格式数据（源地址/客户端地址，不可为空）
     */
    @XmlElement(name = "CLIENT_ADDRESS")
    private String clientAddress;

    /**
     * 服务端IP地址:
     * 标准ip格式数据（目的地址，不可为空）
     */
    @XmlElement(name = "SERVER_ADDRESS")
    private String serverAddress;

    public String getIdentityName() {
        return identityName;
    }

    public void setIdentityName(String identityName) {
        this.identityName = identityName;
    }

    public String getResourceKind() {
        return resourceKind;
    }

    public void setResourceKind(String resourceKind) {
        this.resourceKind = resourceKind;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getIdrCreationTime() {
        return idrCreationTime;
    }

    public void setIdrCreationTime(String idrCreationTime) {
        this.idrCreationTime = idrCreationTime;
    }

    public String getSubAccountName() {
        return subAccountName;
    }

    public void setSubAccountName(String subAccountName) {
        this.subAccountName = subAccountName;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getOpTypeId() {
        return opTypeId;
    }

    public void setOpTypeId(String opTypeId) {
        this.opTypeId = opTypeId;
    }

    public String getOpTypeName() {
        return opTypeName;
    }

    public void setOpTypeName(String opTypeName) {
        this.opTypeName = opTypeName;
    }

    public String getOpLevelId() {
        return opLevelId;
    }

    public void setOpLevelId(String opLevelId) {
        this.opLevelId = opLevelId;
    }

    public String getOperateContent() {
        return operateContent;
    }

    public void setOperateContent(String operateContent) {
        this.operateContent = operateContent;
    }

    public String getOperateResult() {
        return operateResult;
    }

    public void setOperateResult(String operateResult) {
        this.operateResult = operateResult;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }
}
