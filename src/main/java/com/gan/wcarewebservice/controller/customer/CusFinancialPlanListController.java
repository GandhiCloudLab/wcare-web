package com.gan.wcarewebservice.controller.customer;

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
public class CusFinancialPlanListController {

    @Autowired
    GoalService goalService;

    @RequestMapping(value="/CusFinancialPlanList", method = RequestMethod.GET)
    public String fpList(ModelMap model, HttpServletRequest request) {

        int customerId = (int) request.getSession().getAttribute("customerId");

        List<GoalInfo> list = (List<GoalInfo>) goalService.findInfoListByCustomerId(customerId);
        model.addAttribute("mainData", list);

        return "/cus/cus_fp_list";
    }

}