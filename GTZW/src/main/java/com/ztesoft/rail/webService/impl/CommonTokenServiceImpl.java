package com.ztesoft.rail.webService.impl;

import com.ztesoft.rail.webService.CommonTokenService;

public class CommonTokenServiceImpl implements CommonTokenService {
    @Override
    public String checkAiuapTokenSoap(String requestInfo) {
        System.out.println("接收到4AToekn认证请求:"+requestInfo);
        return "ok";
    }
}
