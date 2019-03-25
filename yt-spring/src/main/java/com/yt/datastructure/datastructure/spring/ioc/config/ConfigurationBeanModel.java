package com.yt.datastructure.datastructure.spring.ioc.config;

/**
 * Created by yantong on 2019/2/28.
 */
public class ConfigurationBeanModel {

    private String title;
    private int price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ConfigurationBeanModel{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
