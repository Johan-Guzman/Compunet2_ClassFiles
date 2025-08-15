package org.example.services;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShopService {

    private ArrayList<String> shopList = new ArrayList<>();

    public void addShop(String shop) {
        shopList.add(shop);
    }

    public ArrayList<String> getShopList() {
        return shopList;
    }



}
