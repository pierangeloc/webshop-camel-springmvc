package com.pierangeloc.shop.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by pierangeloc on 20-4-15.
 */
@PropertySource("classpath:/shop.properties")
@Component("distributionCenterRouteBuilder")
public class DistributionCenterRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:dc")
                .routeId("Distribution Center Switch")
            .choice()
                .when(header("country").isEqualTo("NL"))
                    .to("direct:europeDC")
                .otherwise()
                    .to("direct:americaDC")
                .end()
            .end();

        from("direct:europeDC")
            .routeId("EU distribution center")
            .setBody(constant("{products: {" +
                                    "nr: 10" +
                                "}"));

        from("direct:americaDC")
            .routeId("US distribution center")
            .setBody(constant("{products: {" +
                                    "nr: 100" +
                                "}"));
    }
}
