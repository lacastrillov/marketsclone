/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.marketplatform.controllers.view;

import com.lacv.marketplatform.dtos.ProductImageDto;
import com.lacv.marketplatform.mappers.ProductImageMapper;
import com.lacv.marketplatform.services.ProductImageService;
import com.dot.gcpbasedot.controller.ExtEntityController;
import com.dot.gcpbasedot.components.MenuComponent;
import com.dot.gcpbasedot.dto.config.ReportConfig;
import com.dot.gcpbasedot.dto.config.EntityConfig;
import com.lacv.marketplatform.dtos.reports.ProductImageReportDto;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author lacastrillov
 */
@Controller
@RequestMapping(value="/vista/productImage")
public class ProductImageViewController extends ExtEntityController {
    
    @Autowired
    ProductImageService productImageService;
    
    @Autowired
    MenuComponent menuComponent;
    
    @Autowired
    ProductImageMapper productImageMapper;
    
    
    @PostConstruct
    public void init(){
        EntityConfig view= new EntityConfig("productImage", "id", productImageService, ProductImageDto.class);
        view.setSingularEntityTitle("Imagen");
        view.setPluralEntityTitle("Imagenes");
        view.setMultipartFormData(true);
        view.setDefaultOrder("order", "ASC");
        super.addControlMapping(view);
        
        ReportConfig report = new ReportConfig("productImage", "reporteImagenesProducto", productImageService, ProductImageReportDto.class);
        report.setPluralReportTitle("Reporte Imagenes de Productos");
        report.setDefaultOrderBy("order_level");
        report.setDefaultOrderDir("ASC");
        super.addReportMapping(report);
    }
    
}
