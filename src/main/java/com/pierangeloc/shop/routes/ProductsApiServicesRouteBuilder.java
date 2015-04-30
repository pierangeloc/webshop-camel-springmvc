package com.pierangeloc.shop.routes;

import com.pierangeloc.shop.apis.ProductsAndPrices;
import com.pierangeloc.shop.apis.ProductsAndPricesImpl;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("productsApiRouteBuilder")
public class ProductsApiServicesRouteBuilder extends RouteBuilder  {

    final String uri = "cxf:/products?serviceClass=" + ProductsAndPrices.class.getName();


    @Override
    public void configure() throws Exception {
        from(uri)
            .process(new Processor() {
                private final Logger LOGGER = LoggerFactory.getLogger(ProductsApiServicesRouteBuilder.class);

                @Override
                public void process(Exchange exchange) throws Exception {
                    LOGGER.info("in body: " + exchange.getIn().getBody());
                }
            });
    }
}
