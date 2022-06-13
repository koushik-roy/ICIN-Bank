package com.icinbank.controller;

import java.security.Principal;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icinbank.domain.Request;
import com.icinbank.domain.User;
import com.icinbank.service.RequestService;
import com.icinbank.service.UserService;

@Controller
@RequestMapping("/requestChequeBook")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String createRequest(Model model) {
        Request request = new Request();
        model.addAttribute("request", request);

        return "requestChequeBook";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createRequestPost(@ModelAttribute("requestChequeBook") Request requestChequeBook, Model model, Principal principal) throws ParseException {

        User user = userService.findByUsername(principal.getName());
        requestChequeBook.setUser(user);

        requestService.createRequest(requestChequeBook);

        return "redirect:/ICINBank";
    }


}
