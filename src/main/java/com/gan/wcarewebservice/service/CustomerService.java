package com.gan.wcarewebservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gan.wcarewebservice.common.LogUtil;
import com.gan.wcarewebservice.model.LoginInfo;
import com.gan.wcarewebservice.model.WcCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;


@Configuration
@Service
public class CustomerService {

    @Value("${prop.api.server.url.user}")
    private String url_user;

    @Autowired
    RestUtilService restUtilService;

    public WcCustomer find(int customerId) {
        LogUtil.log("CustomerService  find Started :customerId: " + customerId);

        String url = url_user + "/user/api/customer";

        LogUtil.log("CustomerService  find Started : url " + url);

        WcCustomer result = (WcCustomer) restUtilService.callGetForObject (url, customerId, WcCustomer.class);

        LogUtil.log("CustomerService  find Completed : " + result);

        return result;
    }

    public List<WcCustomer> findAll() {
        LogUtil.log("CustomerService  findAll Started ");

        String url = url_user + "/user/api/customer";

        LogUtil.log("CustomerService  findAll Started : url " + url);

        List<WcCustomer> result = (List<WcCustomer>) restUtilService.callGetForObjectList (url, WcCustomer.class);

        LogUtil.log("CustomerService  findAll Completed : " + result);

        return result;
    }
}
