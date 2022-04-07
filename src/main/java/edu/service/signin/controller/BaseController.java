package edu.service.signin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public abstract class BaseController {



    @Autowired
    protected HttpServletRequest httpServletRequest;





}
