/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.marketplatform.controllers.view;

import com.lacv.marketplatform.dtos.PropertyDto;
import com.lacv.marketplatform.mappers.PropertyMapper;
import com.lacv.marketplatform.services.PropertyService;
import com.dot.gcpbasedot.controller.ExtEntityController;
import com.dot.gcpbasedot.components.MenuComponent;
import com.dot.gcpbasedot.dto.MenuItem;
import com.dot.gcpbasedot.dto.config.EntityConfig;
import com.lacv.marketplatform.services.security.SecurityService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author lacastrillov
 */
@Controller
@RequestMapping(value="/vista/property")
public class PropertyViewController extends ExtEntityController {
    
    @Autowired
    PropertyService propertyService;
    
    @Autowired
    MenuComponent menuComponent;
    
    @Autowired
    PropertyMapper propertyMapper;
    
    @Autowired
    SecurityService securityService;
    
    
    @PostConstruct
    public void init(){
        EntityConfig view= new EntityConfig("property", "key", propertyService, PropertyDto.class);
        view.setSingularEntityTitle("Propiedad");
        view.setPluralEntityTitle("Propiedades");
        view.setMultipartFormData(true);
        super.addControlMapping(view);
        
        MenuItem menuItem= new MenuItem("Configuraci&oacute;n", "property", "Gestionar Propiedades");
        menuItem.setParentPosition(2);
        menuComponent.addItemMenu(menuItem);
        super.addMenuComponent(menuComponent);
    }
    
    @Override
    public List<MenuItem> configureVisibilityMenu(List<MenuItem> menuData){
        return securityService.configureVisibilityMenu(menuData);
    }
    
}
