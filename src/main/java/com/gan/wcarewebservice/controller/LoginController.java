package com.gan.wcarewebservice.controller;

import com.gan.wcarewebservice.common.NumberUtil;
import com.gan.wcarewebservice.model.LoginInfo;
import com.gan.wcarewebservice.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginService service;

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String doLogout(ModelMap model, HttpServletRequest request){
        request.getSession().removeAttribute("loginInfo");
        request.getSession().removeAttribute("userDisplayText");
        request.getSession().removeAttribute("userDisplayId");
        request.getSession().removeAttribute("goalId");
        request.getSession().removeAttribute("customerId");
        request.getSession().removeAttribute("customerName");
        request.getSession().removeAttribute("customerDisplayText");
        request.getSession().removeAttribute("wealthManagerId");
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showLogin(ModelMap model, HttpServletRequest request, @RequestParam String loginId, @RequestParam String password){

        System.out.println("Login ...loginId: " + loginId);

        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setLoginId(loginId);
        loginInfo.setPassword(password);

        loginInfo = service.processLogin(loginInfo);

        String userRole = loginInfo.getUserRole();

        String userDisplayText = null;
        String nextPage = null;

        if ("BM".equalsIgnoreCase(userRole)) {
            nextPage = "BmCustomerList";
            userDisplayText = "Bussiness Manager : " + loginInfo.getUserDisplayName();
        } else if ("WM".equalsIgnoreCase(userRole))  {
            nextPage = "WmCustomerList";
            userDisplayText = "Welath Manager : " + loginInfo.getUserDisplayName();
            model.put("wealthManagerId", NumberUtil.stringToInt(loginInfo.getUserDisplayId()));
        } else {
            request.getSession().setAttribute("customerId", NumberUtil.stringToInt(loginInfo.getUserDisplayId()));
            nextPage = "CusFinancialPlanList";
            userDisplayText = "Customer : " + loginInfo.getUserDisplayName();
        }

        request.getSession().setAttribute("loginInfo", loginInfo);
        request.getSession().setAttribute("userDisplayText", userDisplayText);
        request.getSession().setAttribute("userDisplayId", loginInfo.getUserDisplayId());

        System.out.println("Login ...nextPage: " + nextPage);

        return "redirect:" + nextPage;
    }

}