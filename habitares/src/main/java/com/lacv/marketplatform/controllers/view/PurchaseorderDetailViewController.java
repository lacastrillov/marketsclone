/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.marketplatform.controllers.view;

import com.lacv.marketplatform.dtos.PurchaseorderDetailDto;
import com.lacv.marketplatform.mappers.PurchaseorderDetailMapper;
import com.lacv.marketplatform.services.PurchaseorderDetailService;
import com.dot.gcpbasedot.controller.ExtEntityController;
import com.dot.gcpbasedot.components.MenuComponent;
import com.dot.gcpbasedot.dto.config.EntityConfig;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author lacastrillov
 */
@Controller
@RequestMapping(value="/vista/purchaseorderDetail")
public class PurchaseorderDetailViewController extends ExtEntityController {
    
    @Autowired
    PurchaseorderDetailService purchaseorderDetailService;
    
    @Autowired
    MenuComponent menuComponent;
    
    @Autowired
    PurchaseorderDetailMapper purchaseorderDetailMapper;
    
    
    @PostConstruct
    public void init(){
        EntityConfig view= new EntityConfig("purchaseorderDetail", "purchaseorderDetailName", purchaseorderDetailService, PurchaseorderDetailDto.class);
        view.setSingularEntityTitle("Detalle Orden Compra");
        view.setPluralEntityTitle("Detalle Orden Compra");
        super.addControlMapping(view);
    }
    
    
}
