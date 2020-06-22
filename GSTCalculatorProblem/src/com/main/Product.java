package com.main;

import java.util.HashMap;
import java.util.List;

/*
 *   This Class stores product info
 *
 *
 */
public class Product {
   private HashMap<String, List<String>> categoryProductMap;

    public Product(HashMap<String, List<String>> categoryProductMap) {
        this.categoryProductMap = categoryProductMap;
    }

    public HashMap<String, List<String>> getCategoryProductMap() {
        return categoryProductMap;
    }

    public void setCategoryProductMap(HashMap<String, List<String>> categoryProductMap) {
        this.categoryProductMap = categoryProductMap;
    }
}
