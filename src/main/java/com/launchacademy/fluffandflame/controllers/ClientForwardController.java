package com.launchacademy.fluffandflame.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientForwardController {

  @GetMapping(value = {"/", "/creatures"})
  public String index() {
    return "index";
  }

  @GetMapping(value = "/**/{path:[^\\.]*}")
  public String forward() {
    return "forward:/";
  }
}