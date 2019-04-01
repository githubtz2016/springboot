package com.ztesoft.rail.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "UpdateAppAcctSoap")
public interface FourAccountWeb {

    @WebMethod(operationName="UpdateAppAcctSoap")
    @WebResult(name="ResponseInfo")
    String updateAppAcctSoap(@WebParam(name = "RequestInfo") String xml);

}
