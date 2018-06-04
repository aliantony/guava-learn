package com.antony.learn.java;

import java.util.Arrays;
public enum Meal {
    APPETIZER(Food.Appetizer.class), MAINCOURSE(Food.MainCourse.class), DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;

    private Meal(Class<? extends Food> kind) {
        // 通过class对象获取枚举实例
        values = kind.getEnumConstants();
    }

    public interface Food {
        enum Appetizer implements Food {
            SALAD, SOUP, SPRING_ROLLS;
        }

        enum MainCourse implements Food {
            LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO;
        }

        enum Dessert implements Food {
            TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL;
        }

        enum Coffee implements Food {
            BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA;
        }
    }
    
    public static void main(String[] args) {
        //Meal meal = new Meal(Coffee.class); 只有编译器才能调用枚举类型的构造函数 
        System.out.println(Arrays.toString(Meal.APPETIZER.values));
    }
}