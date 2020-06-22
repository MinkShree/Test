package com.test;

import com.main.Slabs;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SlabsTest {
    GSTCalculatorTest gstCalculatorTest = new GSTCalculatorTest();

    @Test
    public void getGSTSlab(){
        HashMap<String, Float> categorySlabMap = gstCalculatorTest.getCategorySlabMap();
        List<Float> slabs = gstCalculatorTest.getSLabs();

        Slabs slab = new Slabs(slabs,categorySlabMap);
        assertEquals(0f,slab.getGSTSlab("food-grains"),0.0);

    }
}
