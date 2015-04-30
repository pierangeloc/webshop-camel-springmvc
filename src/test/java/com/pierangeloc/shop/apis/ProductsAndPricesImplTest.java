package com.pierangeloc.shop.apis;

import org.testng.annotations.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ProductsAndPricesImplTest {

    @Test
    public void shouldInitializeCorrectlyFromJsonInClassPath() {
        ProductsAndPricesImpl productsAndPrices = new ProductsAndPricesImpl();

        assertThat(productsAndPrices.getProducts().size(), is(equalTo(4)));
    }

}