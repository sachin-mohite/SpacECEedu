package com.spacECE.spaceceedu.LibForSmall;

import org.jetbrains.annotations.NotNull;

public class Book {
    String product_id;
    String product_title;
    String product_price;
    String product_keywords;
    String product_image;

    public Book(String product_id, String product_title, String product_price, String product_keywords, String product_image) {
        this.product_id = product_id;
        this.product_title = product_title;
        this.product_price = product_price;
        this.product_keywords = product_keywords;
        this.product_image = product_image;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public String getProduct_price() {
        return product_price;
    }

    private void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_keywords() {
        return product_keywords;
    }

    public void setProduct_keywords(String product_keywords) {
        this.product_keywords = product_keywords;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    @NotNull
    @Override
    public String toString() {
        return "product_id= " + product_id +
                " product_title= " + product_title +
                "\nproduct_keywords= " + product_keywords +
                "\nproduct_price= " + product_price +
                "\nproduct_image= " + product_image;
    }
}