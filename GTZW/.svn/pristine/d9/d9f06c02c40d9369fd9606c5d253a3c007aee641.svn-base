package com.ztesoft.rail.xmlEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(
        name = "USERMODIFYREQ"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class UserModifyreq {
    @XmlElement(
            name = "HEAD"
    )
    private UserHead userHead;
    @XmlElement(
            name = "BODY"
    )
    private ModifyBody modifyBody;

    public UserHead getUserHead() {
        return userHead;
    }

    public void setUserHead(UserHead userHead) {
        this.userHead = userHead;
    }

    public ModifyBody getModifyBody() {
        return modifyBody;
    }

    public void setModifyBody(ModifyBody modifyBody) {
        this.modifyBody = modifyBody;
    }
}

