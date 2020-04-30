package com.launchacademy.fluffandflame.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//@Controller
//public class PathController {
//  @GetMapping(value = {"/", "/pets"})
//  public String index() {
//    return "index";
//  }
//  @GetMapping(value = "/**/{path:[^\\.]*}")
//  public String forward() {
//    return "forward:/";
//  }
//}

@Controller
//@RequestMapping(value = {"/", "/creatures/*"})
public class ClientForwardController {

  @GetMapping(value = {"/", "/creatures"})
  public String index() {
    return "index";
  }

  @GetMapping("/test")
  public String redirectRootTEST() {
    return "redirect:/creatures";
  }

  @GetMapping(value = "/**/{path:[^\\.]*}")
  public String forward() {
    return "forward:/";
  }
}