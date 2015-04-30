package com.pierangeloc.shop;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
//@RequestMapping("/products")
public class CatalogController {

	@Autowired
	ProducerTemplate producerTemplate;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String productsList(ModelMap model) {
		model.addAttribute("message", "Hello world!");

		Exchange exchange = new DefaultExchange(producerTemplate.getCamelContext());

		producerTemplate.send("direct:dc", exchange);
		return exchange.getIn().getBody(String.class);
	}
}