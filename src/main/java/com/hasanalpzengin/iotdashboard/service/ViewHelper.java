package com.hasanalpzengin.iotdashboard.service;

import java.util.HashMap;

import org.springframework.web.servlet.ModelAndView;

public class ViewHelper {
    public static ModelAndView viewWithUid(String viewName, long uid){
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject("uid", uid);
        return modelAndView;
    }

    public static ModelAndView viewWithData(String viewName, HashMap<String,String> data){
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject("data", data);
        return modelAndView;
    }
}