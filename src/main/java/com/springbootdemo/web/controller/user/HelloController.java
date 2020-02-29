package com.springbootdemo.web.controller.user;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.springbootdemo.service.UserService;
import com.springbootdemo.web.form.UserForm;

@Controller
public class HelloController {

  @Autowired
  private UserService userService;

  @GetMapping("/")
  public String user(Model model) {
    var domain = userService.getDomain();

    System.out.println(domain);

    model.addAttribute("domain", domain);

    return "user/hello/hello";
  }

  @GetMapping("/user/add")
  public String add(Model model) {
    model.addAttribute("userForm", new UserForm());

    return "user/hello/add";
  }

  @PostMapping("/user/add")
  public String create(@Validated @ModelAttribute UserForm userForm, BindingResult result,
      Model model) {
    if (result.hasErrors()) {
      var errorList = result.getAllErrors().stream().map(e -> e.getDefaultMessage())
          .collect(Collectors.toList());

      model.addAttribute("validationError", errorList);

      return "user/hello/add";
    }

    userService.create(userForm);

    return "redirect:/";
  }
}
