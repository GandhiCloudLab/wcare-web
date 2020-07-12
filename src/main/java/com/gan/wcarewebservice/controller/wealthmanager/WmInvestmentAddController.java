package com.gan.wcarewebservice.controller.wealthmanager;

import java.util.Date;

import com.gan.wcarewebservice.common.NumberUtil;
import com.gan.wcarewebservice.model.GoalInfo;
import com.gan.wcarewebservice.model.WcInvestment;
import com.gan.wcarewebservice.service.GoalService;
import com.gan.wcarewebservice.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WmInvestmentAddController {

    @Autowired
    GoalService goalService;

    @Autowired
    InvestmentService investmentService;

    @RequestMapping(value="/WmInvestmentAdd/investmentAdd", method = RequestMethod.GET)
    public String investmentAdd(ModelMap model, @RequestParam int goalId,  @RequestParam String investmentAmountString){

        double investmentAmount = NumberUtil.stringToDouble(investmentAmountString);

        WcInvestment wcInvestment = new WcInvestment();
        wcInvestment.setWcGoalId(goalId);
        wcInvestment.setInvestmentDate(new Date());
        wcInvestment.setInvestmentAmount(investmentAmount);

        investmentService.create(wcInvestment);

        return "WmFinancialPlanDetail";
    }

    @RequestMapping(value="/WmInvestmentAdd/loadForAdd", method = RequestMethod.GET)
    public String loadForAdd(ModelMap model, @RequestParam int goalId){
        GoalInfo goalInfo = goalService.findInfo(goalId);
        model.addAttribute("mainData", goalInfo);
        return "/wm/wm_investement_add";
    }


}

