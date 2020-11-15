package cn.wang.rbac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class demoController {

        @GetMapping("test")
        public String test() {
            return "Hello World!";
        }
}

