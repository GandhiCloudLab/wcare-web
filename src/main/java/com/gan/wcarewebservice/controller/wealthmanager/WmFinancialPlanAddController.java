package com.gan.wcarewebservice.controller.wealthmanager;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.gan.wcarewebservice.common.DateUtil;
import com.gan.wcarewebservice.common.NumberUtil;
import com.gan.wcarewebservice.model.WcGoal;
import com.gan.wcarewebservice.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class WmFinancialPlanAddController {

    @Autowired
    GoalService goalService;

    @RequestMapping(value="/WmFinancialPlanAdd/goalAdd", method = RequestMethod.GET)
    public String goalAdd(ModelMap model, HttpServletRequest request, @RequestParam String goalReference,
                          @RequestParam String goalDescription,
                          @RequestParam String targetDate,
                          @RequestParam String targetAmount,
                          @RequestParam int wealthManagerId) {

        int customerId = (int) request.getSession().getAttribute("customerId");


        WcGoal goalInfo = new WcGoal();

        goalInfo.setWcCustomerId(customerId);
        goalInfo.setWcWealthManagerId(wealthManagerId);

        goalInfo.setGoalReference(goalReference);
        goalInfo.setGoalDesc(goalDescription);
        goalInfo.setTargetDate(DateUtil.getDateDefaultToNYear(targetDate,5));
        goalInfo.setTargetAmount(NumberUtil.stringToDouble(targetAmount));

        goalService.create(goalInfo);

        return "WmFinancialPlanList";
    }

    @RequestMapping(value="/WmFinancialPlanAdd/loadForAdd", method = RequestMethod.POST)
    public String loadForAdd(ModelMap model, @RequestParam int goalId){
        return "/wm/wm_fp_add";
    }
}

