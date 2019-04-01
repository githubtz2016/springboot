package com.ztesoft.rail.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name="CheckAiuapTokenSoap", targetNamespace="http://service.base.app.core.a4.asiainfo.com")
public interface CommonTokenService {
    @WebMethod(operationName="CheckAiuapTokenSoap")
    @WebResult(name="CheckAiuapTokenSoapReturn")
    String checkAiuapTokenSoap(
            @WebParam(name = "RequestInfo", targetNamespace = "http://service.base.app.core.a4.asiainfo.com") String requestInfo);

}
