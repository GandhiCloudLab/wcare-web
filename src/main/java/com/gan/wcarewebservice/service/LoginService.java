package com.gan.wcarewebservice.service;

import com.gan.wcarewebservice.common.LogUtil;
import com.gan.wcarewebservice.model.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


@Configuration
@Service
public class LoginService {

    @Value("${prop.api.server.url.user}")
    private String url_user;

    @Autowired
    RestUtilService restUtilService;

    public LoginInfo processLogin(LoginInfo loginInfo) {
        LogUtil.log("LoginService  processLogin Started ");

        String url = url_user + "/user/public/login";

        LogUtil.log("LoginService  processLogin Started : url " + url);

        LoginInfo result = (LoginInfo) restUtilService.callPost (url, loginInfo, LoginInfo.class);

        LogUtil.log("LoginService  processLogin Completed : " + result);

        return result;
    }
}
