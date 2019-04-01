package com.ztesoft.rail.config;

import javax.xml.ws.Endpoint;

import com.ztesoft.rail.webService.CommonTokenService;
import com.ztesoft.rail.webService.impl.CommonTokenServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ztesoft.rail.webService.FourAccountWeb;
import com.ztesoft.rail.webService.impl.FourAccountWebImpl;

@Configuration
public class CxfConfig {

        @Bean(name = Bus.DEFAULT_BUS_ID)
        public SpringBus springBus() {
            return new SpringBus();
        }

        @Bean
        public FourAccountWeb fourAccountWeb() {
            return new FourAccountWebImpl();
        }

        @Bean
        public Endpoint endpoint() {
            EndpointImpl endpoint = new EndpointImpl(springBus(), fourAccountWeb());
            endpoint.publish("/UpdateAppAcctSoap");
            return endpoint;
        }

//        @Bean
//        public CommonTokenService commonTokenService() {
//            return new CommonTokenServiceImpl();
//        }
//
//        @Bean
//        public Endpoint endpoint() {
//            EndpointImpl endpoint = new EndpointImpl(springBus(), commonTokenService());
//            endpoint.publish("/CheckAiuapTokenSoap");
//            return endpoint;
//        }
}
