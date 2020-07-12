package com.gan.wcarewebservice.controller.wealthmanager;

import java.util.List;

import com.gan.wcarewebservice.model.WcCustomer;
import com.gan.wcarewebservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WmCustomerListController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value="/WmCustomerList", method = RequestMethod.GET)
    public String findAll(Model model) {
        List<WcCustomer> list = customerService.findAll();
        model.addAttribute("mainData", list);
        return "wm/wm_cus_list";
    }
}

