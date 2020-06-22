package com.test;
import com.main.GSTCalculator;
import com.main.Slabs;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GSTCalculatorTest {

    @Test
    public void calculateGSTPerUnit(){
        HashMap<String, List<String>> categoryProductMap = getcategoryProductMap();
        List<Float> slabs = getSLabs();
        HashMap<String, Float> categorySlabMap = getCategorySlabMap();

        Slabs slab = new Slabs(slabs,categorySlabMap);
        GSTCalculator gstCalculator = new GSTCalculator(categoryProductMap,slab);

        assertEquals(0f, gstCalculator.calculateGSTPerUnit("Rice",100f),0.0);

    }

    @Test
    public void getTotalPrice(){
        HashMap<String, List<String>> categoryProductMap = getcategoryProductMap();
        List<Float> slabs = getSLabs();
        HashMap<String, Float> categorySlabMap = getCategorySlabMap();

        Slabs slab = new Slabs(slabs,categorySlabMap);
        GSTCalculator gstCalculator = new GSTCalculator(categoryProductMap,slab);

        assertEquals(100f,gstCalculator.getTotalPrice(1,100f,0),0.0);
    }

    @Test
    public void getCategory(){
        HashMap<String, List<String>> categoryProductMap = getcategoryProductMap();
        List<Float> slabs = getSLabs();
        HashMap<String, Float> categorySlabMap = getCategorySlabMap();

        Slabs slab = new Slabs(slabs,categorySlabMap);
        GSTCalculator gstCalculator = new GSTCalculator(categoryProductMap,slab);

        assertEquals("food-grains",gstCalculator.getCategory("Rice"));
    }

    public  HashMap<String, List<String>> getcategoryProductMap(){
        HashMap<String, List<String>> categoryProductMap = new HashMap<>();
        //Product mock = Mockito.mock(Product.class);
        categoryProductMap.put("food-grains", Arrays.asList("Rice","Wheat","Dal"));
        categoryProductMap.put("furniture",Arrays.asList("Table","Sofa","Chair"));
        categoryProductMap.put("electronics",Arrays.asList("Mobile","TV","Tablet"));
        categoryProductMap.put("cosmetics",Arrays.asList("Cream","Perfume","Lotion"));
        //when(mock.getCategoryProductMap()).thenReturn(categoryProductMap);
        return categoryProductMap;
    }

    public List<Float> getSLabs(){
        List<Float> slabs = new ArrayList<Float>();
        slabs.add(0f);
        slabs.add(5f);
        slabs.add(18f);
        slabs.add(28f);
        return slabs;
    }

    public  HashMap<String, Float> getCategorySlabMap(){
        HashMap<String, Float> categorySlabMap = new HashMap<>();
        categorySlabMap.put("food-grains",0f);
        categorySlabMap.put("furniture",5f);
        categorySlabMap.put("electronics",18f);
        categorySlabMap.put("cosmetics",28f);
        return categorySlabMap;
    }

}
