package com.main;

import java.util.*;
import java.util.stream.Collectors;
/*
 *   This Class provides methods to calculate
 *      PerUnitGST
 *      TotalPrice of commodity
 *
 */
public class GSTCalculator implements Commodity {
    private float gst;
    private String category;
    private HashMap<String, List<String>> productCategoryMap;
    private Slabs slabs;

//CONSTRUCTOR
    public GSTCalculator(HashMap<String, List<String>> productCategoryMap, Slabs slab) {
        this.productCategoryMap = productCategoryMap;
        this.slabs = slab;
    }
//CALCULATE PER UNIT GST PRICE
    public float calculateGSTPerUnit(String product, float unitPrice) {
        String category = getCategory(product);
        float slab = slabs.getGSTSlab(category);
        gst = unitPrice * slab / 100;
        return gst;
    }
//CALCULATE TOTAL PRICE INCLUDING GST
    public float getTotalPrice(float unit, float unitPrice, float gstPerUnit) {
        float totalPrice = unit * (unitPrice + gstPerUnit);
        return totalPrice;
    }

//FETCHES CATEGORY OF A GIVEN COMMODITY
    @Override
    public String getCategory(String product) {
        try {
            return productCategoryMap
                    .entrySet()
                    .stream()
                    .filter(entry -> entry.getValue().contains(product.toLowerCase()))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList())
                    .get(0);
        } catch (Exception e) {
            System.out.println(product+" not present!");
            System.exit(0);
            return null;
        }
    }

/*
*********ADD PRODUCT*******************************************
    public void addProduct(String product, String category) {
        List<String> items = productCategoryMap.get(category);

        // if list does not exist create it
        if (items == null) {
            items = new ArrayList<>();
            items.add(product);
            productCategoryMap.put(category, items);
        } else {
            // add if item is not already in list
            if (!items.contains(product)) items.add(product);
        }
    }
***********REMOVE PRODUCT***************************************
    public void removeProduct(String product, String category) {
        productCategoryMap.get(category).remove(product);
    }
*/
}

