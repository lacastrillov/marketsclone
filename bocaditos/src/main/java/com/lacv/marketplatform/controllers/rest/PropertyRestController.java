/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.marketplatform.controllers.rest;


import com.lacv.marketplatform.mappers.PropertyMapper;
import com.lacv.marketplatform.services.PropertyService;
import com.dot.gcpbasedot.controller.RestEntityController;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author nalvarez
 */
@Controller
@RequestMapping(value="/rest/property")
public class PropertyRestController extends RestEntityController {
    
    @Autowired
    PropertyService propertyService;
    
    @Autowired
    PropertyMapper propertyMapper;
    
    
    @PostConstruct
    public void init(){
        super.addControlMapping("property", propertyService, propertyMapper);
    }
    
    
}
