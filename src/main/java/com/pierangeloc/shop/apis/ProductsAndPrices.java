package com.pierangeloc.shop.apis;

import com.pierangeloc.shop.apis.entities.Price;
import com.pierangeloc.shop.apis.entities.Product;
import com.pierangeloc.shop.apis.entities.Stock;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by pierangeloc on 26-4-15.
 */
@WebService
public interface ProductsAndPrices {

    public List<Product> getProducts();

    public Price getPriceFor(Product product);

    List<Stock> getAvailableProducts(String distributionCenter);

    Stock getAvailableItemsFor(String sku, String distributionCenter);



}
