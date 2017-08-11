package com.example.examplemod.util.math;

/**
 * Created by pijie on 2017/8/6.
 */
public class Utilities {
    public static double minOfFour(double a, double b, double c, double d){
        return Math.min(Math.min(a,b),Math.min(c,d));

    }

    public static double maxOfFour(double a, double b, double c, double d){
        return Math.max(Math.max(a,b),Math.max(c,d));

    }
}
