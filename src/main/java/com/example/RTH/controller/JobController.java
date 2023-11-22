package com.example.RTH.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobController {
    @GetMapping("/job")
    public String jobPage() {
        return "job/job";
    }
}
