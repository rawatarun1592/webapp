package com.kakinos.webapp;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@EnableAutoConfiguration
public class HelloWorld {
@RequestMapping("/hello")
@ResponseBody
public String sayHello() {
return "Hello World Developer!!!";
}
}