package com.springbootdemo.web.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.springbootdemo.service.UserService;

@Controller
public class HelloController {

  @Autowired
  private UserService userService;

  @GetMapping("/user")
  public String hello(Model model) {
    var domain = userService.getDomain();

    System.out.println(domain);
    model.addAttribute("domain", domain);


    return "user/hello/hello";
  }
}
