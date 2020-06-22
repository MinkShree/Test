package com.main;

import java.util.HashMap;
import java.util.List;
/*
*   This Class maintains the GSTSlabs of current category mapping.
*
*
*/
public class Slabs {
    private List<Float> slabs;
    private HashMap<String, Float> categorySlabMap;

//CONSTRUCTOR
    public Slabs(List<Float> slabs, HashMap<String, Float> categorySlabMap) {
        this.slabs = slabs;
        this.categorySlabMap = categorySlabMap;
    }
//GET CATEGORY WISE SLABS
    public float getGSTSlab(String category) {
        return categorySlabMap.get(category);
    }
/*
********ADD NEW SLAB*****************
    public void addSlab(float slab){
        slabs.add(slab);
    }
*/
//GET PRESENT SLABS
    public List<Float> getSlabs(){
        return slabs;
    }

}
