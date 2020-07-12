package com.gan.wcarewebservice.controller.wealthmanager;

import java.util.List;

import com.gan.wcarewebservice.model.GoalInfo;
import com.gan.wcarewebservice.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WmPortfolioListController {

    @Autowired
    private GoalService goalService;

    @RequestMapping(value="/WmPortfolioList", method = RequestMethod.GET)
    public String load(ModelMap model , HttpServletRequest request) {

        int customerId = (int) request.getSession().getAttribute("customerId");

        List<GoalInfo> list = (List<GoalInfo>) goalService.findInfoListByCustomerId(customerId);
        model.addAttribute("mainData", list);
        return "/wm/wm_portfolio_list";
    }

}

