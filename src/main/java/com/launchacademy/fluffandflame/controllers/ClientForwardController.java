package com.launchacademy.fluffandflame.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
@RequestMapping(value = {"/", "/creatures/*"})
public class ClientForwardController {

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/test")
  public String redirectRootTEST() {
    return "redirect:/creatures";
  }

//
//  @GetMapping("/")
//  public String redirectRoot() {
//    return "index";
//  }

//  @GetMapping("/")
//  public String redirectRoot() {
//    return "redirect:/creatures";
//  }
//
//  @GetMapping
//  public String redirectRoot() {
//    return "redirect:/creatures";
//  }

  @GetMapping(value = "/**/{path:[^\\.]*}")
  public String forward() {
    return "forward:/";
  }
}