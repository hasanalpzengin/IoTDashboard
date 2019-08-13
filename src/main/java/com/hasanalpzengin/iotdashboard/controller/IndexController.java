/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasanalpzengin.iotdashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author hasalp
 */
@Controller
public class IndexController {
    @GetMapping({"/index", "/home", "/"})
    public String index(){
        return "index";
    }
    
}
