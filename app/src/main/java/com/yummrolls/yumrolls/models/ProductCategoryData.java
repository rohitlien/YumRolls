package com.yummrolls.yumrolls.models;

import java.util.ArrayList;

/**
 * Created by oust on 9/6/17.
 */

public class ProductCategoryData {
    String id;
    ArrayList<ProductInfoModel> productInfoModels;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<ProductInfoModel> getProductInfoModels() {
        return productInfoModels;
    }

    public void setProductInfoModels(ArrayList<ProductInfoModel> productInfoModels) {
        this.productInfoModels = productInfoModels;
    }
}
