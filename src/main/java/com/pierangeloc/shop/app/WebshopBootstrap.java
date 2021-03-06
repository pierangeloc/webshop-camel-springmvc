package com.pierangeloc.shop.app;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebshopBootstrap implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        final AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(WebshopConfiguration.class);
        container.addListener(new ContextLoaderListener(webContext));

        final ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(webContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        //CXF servlet
        final ServletRegistration.Dynamic cxf = container.addServlet("CXFServlet", new CXFServlet());
//        cxf.setLoadOnStartup(1);
        cxf.addMapping("/soap/*");
        cxf.setAsyncSupported(true);
    }

}
