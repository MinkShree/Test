package com.main;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Float> slabs = new ArrayList<>();
        slabs.add(0f);
        slabs.add(5f);
        slabs.add(18f);
        slabs.add(28f);

        HashMap<String, Float> categorySlabMap = new HashMap<>();
        categorySlabMap.put("food-grains",0f);
        categorySlabMap.put("furniture",5f);
        categorySlabMap.put("electronics",18f);
        categorySlabMap.put("cosmetics",28f);

        Slabs slab = new Slabs(slabs,categorySlabMap);
        Product product = new Product(new HashMap<>());
        HashMap<String, List<String>> categoryProductMap = product.getCategoryProductMap();
        categoryProductMap.put("food-grains", Arrays.asList("rice","wheat","dal"));
        categoryProductMap.put("furniture",Arrays.asList("table","sofa","chair"));
        categoryProductMap.put("electronics",Arrays.asList("mobile","tv","tablet"));
        categoryProductMap.put("cosmetics",Arrays.asList("cream","perfume","lotion"));
        product.setCategoryProductMap(categoryProductMap);

        GSTCalculator gstCalculator = new GSTCalculator(product.getCategoryProductMap(), slab);

        Scanner scanner = new Scanner(System.in);
        try{
            while(true){
                System.out.println("Give inputs: ");
                String inputs = scanner.nextLine();
                String[] input = inputs.split(" ");
                Integer unit = Integer.parseInt(input[0]);
                String item = input[1];
                Float price = Float.parseFloat(input[2]);
                if(unit instanceof Integer && item instanceof String && price instanceof Float){
                    float perUnitGst = gstCalculator.calculateGSTPerUnit(item, price);
                    float totalPrice = gstCalculator.getTotalPrice(unit, price, perUnitGst);
                    System.out.println("GST applicable per unit: " + perUnitGst);
                    System.out.println("Final Price: " + totalPrice);                }
                System.out.println("Continue(Y/N): ");
                String condition = scanner.nextLine();
                if("Y".equalsIgnoreCase(condition.replace("\n","")))
                    continue;
                else
                    break;
            }
        }
        catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
            System.out.println("Enter Unit Price and Quantity correctly!");
        }

        catch (Exception e){
            System.out.println(e);
        }

    }
}
