package com.gan.wcarewebservice.service;

import com.gan.wcarewebservice.common.LogUtil;
import com.gan.wcarewebservice.model.GoalInfo;
import com.gan.wcarewebservice.model.WcGoal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;


@Configuration
@Service
public class GoalService {

    @Value("${prop.api.server.url.finance}")
    private String url_finance;

    @Autowired
    RestUtilService restUtilService;

    public List<GoalInfo> findInfoListByCustomerId(int customerId) {
        LogUtil.log("GoalService  findInfoListByCustomerId Started ");

        String url = url_finance + "/finance/api/goal/findInfoListByCustomerId";

        LogUtil.log("GoalService  findInfoListByCustomerId Started : url " + url);

        List<GoalInfo> result = (List<GoalInfo>) restUtilService.callGetForObjectList(url, customerId, GoalInfo.class);

        LogUtil.log("GoalService  findInfoListByCustomerId Completed : " + result);

        return result;
    }

    public GoalInfo findInfo(int goalId) {
        LogUtil.log("GoalService  findInfo Started ");

        String url = url_finance + "/finance/api/goal/findInfo";

        LogUtil.log("GoalService  findInfo Started : url " + url);

        GoalInfo result = (GoalInfo) restUtilService.callGetForObject (url, goalId, GoalInfo.class);

        LogUtil.log("GoalService  findInfo Completed : " + result);

        return result;
    }

    public GoalInfo delete(int goalId) {
        LogUtil.log("GoalService  delete Started ");

        String url = url_finance + "/finance/api/goal/delete/" + goalId;

        LogUtil.log("GoalService  delete Started : url " + url);

        GoalInfo result = (GoalInfo) restUtilService.callGetForObject (url, goalId, GoalInfo.class);

        LogUtil.log("GoalService  delete Completed : " + result);

        return result;
    }




    public GoalInfo create(WcGoal wcGoal) {
        LogUtil.log("GoalService  create Started ");

        String url = url_finance + "/finance/api/goal";

        LogUtil.log("GoalService  create Started : url " + url);

        GoalInfo result = (GoalInfo) restUtilService.callPost (url, wcGoal, GoalInfo.class);

        LogUtil.log("GoalService  create Completed : " + result);

        return result;
    }



}
