package com.gan.wcarewebservice.controller.customer;


import javax.servlet.http.HttpServletRequest;

import com.gan.wcarewebservice.model.WcCustomer;
import com.gan.wcarewebservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CusProfileListController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value="/CusProfileList", method = RequestMethod.GET)
    public String fpList(ModelMap model, HttpServletRequest request) {

        int customerId = (int) request.getSession().getAttribute("customerId");

        WcCustomer wcCustomer =  customerService.find(customerId);
        model.addAttribute("mainData", wcCustomer);

        return "/cus/cus_profile_list";
    }

}

