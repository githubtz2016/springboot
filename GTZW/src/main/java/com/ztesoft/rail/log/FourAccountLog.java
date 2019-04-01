package com.ztesoft.rail.log;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ROOT")
@XmlAccessorType(XmlAccessType.FIELD)
public class FourAccountLog {

    /** 消息的正文 */
    @XmlElement(name = "LOG4A")
    private List<FourAccountLogMsg> msgList;

    public List<FourAccountLogMsg> getMsgList() {
        return msgList;
    }

    public void setMsgList(List<FourAccountLogMsg> msgList) {
        this.msgList = msgList;
    }
}
