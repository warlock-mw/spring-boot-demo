package com.springbootdemo.web.controller.user;

import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    model.addAttribute("userForm", userService.initForm());

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

  @GetMapping("/user/edit/{userId}")
  public String edit(@PathVariable("userId") String userId, Model model) {
    var userForm = Optional.ofNullable(userService.makeForm(userId));

    if (!userForm.isPresent()) {
      return "redirect:/";
    }

    model.addAttribute("userForm", userForm.get());
    model.addAttribute("userId", userId);

    return "user/hello/edit";
  }

  @PostMapping("/user/edit/{userId}")
  public String updsate(@PathVariable("userId") String userId,
      @Validated @ModelAttribute UserForm userForm, BindingResult result, Model model) {
    if (result.hasErrors()) {
      var errorList = result.getAllErrors().stream().map(e -> e.getDefaultMessage())
          .collect(Collectors.toList());

      model.addAttribute("validationError", errorList);

      return "user/hello/edit";
    }

    userService.update(userForm, userId);

    return "redirect:/";
  }
}
