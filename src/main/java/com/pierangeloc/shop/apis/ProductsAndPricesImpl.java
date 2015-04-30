package com.pierangeloc.shop.apis;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pierangeloc.shop.apis.entities.DistributionCenter;
import com.pierangeloc.shop.apis.entities.Price;
import com.pierangeloc.shop.apis.entities.Product;
import com.pierangeloc.shop.apis.entities.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductsAndPricesImpl implements ProductsAndPrices {

    private List<Price> prices;
    private List<Product> products;
    private Map<String, DistributionCenter> distributionCenters;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsAndPricesImpl.class);


    public ProductsAndPricesImpl() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            distributionCenters = mapper.readValue(new ClassPathResource("/data/availability.json").getInputStream(),
                    new TypeReference<Map<String, DistributionCenter>>(){});

            //we must use this TypeReference to avoid type erasure
            Map<String, List<Price>> pricesMap = mapper.readValue(new ClassPathResource("/data/prices.json").getInputStream(),
                    new TypeReference<Map<String, List<Price>>>(){});
            prices = pricesMap.get("prices");
            Map<String, List<Product>> productsMap = mapper.readValue(new ClassPathResource("/data/products.json").getInputStream(),
                    new TypeReference<Map<String, List<Product>>>(){});
            products = productsMap.get("products");
        } catch (IOException e) {
            LOGGER.info("error during json parsing", e);
            prices = new LinkedList<>();
            products = new LinkedList<>();
            distributionCenters  = new HashMap<>();

        }
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Price getPriceFor(Product product) {
        for(Price price : prices) {
            if(price.getSku().equals(product.getSku())) {
                return price;
            }
        }

        return null;
    }

    @Override
    public List<Stock> getAvailableProducts(String distributionCenter) {
        if(distributionCenters.containsKey(distributionCenter)) {
            return distributionCenters.get(distributionCenter).getAvailability();
        }
        else return new LinkedList<>();
    }

    @Override
    public  Stock getAvailableItemsFor(String sku, String distributionCenter) {
        List<Stock> availableProducts = getAvailableProducts(distributionCenter);
        for(int i = 0; i < availableProducts.size(); i++) {
            Stock stock = availableProducts.get(i);
            if(stock.getSku().equals(sku))
                return stock;
        }

        return new Stock();
    }
}
