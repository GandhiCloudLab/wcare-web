package com.gan.wcarewebservice.service;

import com.gan.wcarewebservice.common.LogUtil;
import com.gan.wcarewebservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


@Configuration
@Service
public class InvestmentService {

    @Value("${prop.api.server.url.finance}")
    private String url_finance;

    @Autowired
    RestUtilService restUtilService;

    public InvestmentInfo create(WcInvestment wcInvestment) {
        LogUtil.log("InvestmentService  create Started ");

        String url = url_finance + "/finance/api/investment";

        LogUtil.log("InvestmentService  create Started : url " + url);

        InvestmentInfo result = (InvestmentInfo) restUtilService.callPost (url, wcInvestment, InvestmentInfo.class);

        LogUtil.log("InvestmentService  create Completed : " + result);

        return result;
    }
}
