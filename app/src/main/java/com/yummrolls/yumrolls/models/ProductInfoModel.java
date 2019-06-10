package com.yummrolls.yumrolls.models;

import android.graphics.drawable.Drawable;

/**
 * Created by oust on 9/6/17.
 */

public class ProductInfoModel {
    String productName,productCost,productContent;
    Drawable productImg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCost() {
        return productCost;
    }

    public void setProductCost(String productCost) {
        this.productCost = productCost;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public Drawable getProductImg() {
        return productImg;
    }

    public void setProductImg(Drawable productImg) {
        this.productImg = productImg;
    }
}
