package com.example.examplemod.util.math;


import net.minecraft.util.math.AxisAlignedBB;

/**
 * Created by pijie on 2017/8/5.
 * Custom bounding box, should resemble the default minecraft.util.math bouding box
 * with hoping to achieve different shapes
 */


public class CustomBB {
    public Vector2d A;
    public Vector2d B;
    public Vector2d C;
    public Vector2d D;
    public double minY;
    public double maxY;

    public double minX;
    public double maxX;
    public double minZ;
    public double maxZ;


    public CustomBB(Vector2d A,Vector2d B, Vector2d C, Vector2d D, double minY, double maxY){
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.minY = minY;
        this.maxY = maxY;

        minX = Utilities.minOfFour(A.x, B.x, C.x, D.x);
        maxX = Utilities.maxOfFour(A.x, B.x, C.x, D.x);
        minZ = Utilities.minOfFour(A.y, B.y, C.y, D.y);
        maxZ = Utilities.maxOfFour(A.y, B.y, C.y, D.y);
    }

    public boolean intersectWith(AxisAlignedBB aabb){

        Vector2d AIn = new Vector2d(aabb.minX, aabb.maxZ);
        Vector2d BIn = new Vector2d(aabb.maxX, aabb.maxZ);
        Vector2d CIn = new Vector2d(aabb.maxX, aabb.minZ);
        Vector2d DIn = new Vector2d(aabb.minX, aabb.minZ);



        CustomBB cbbOther = new CustomBB(AIn, BIn, CIn, DIn,aabb.minY, aabb.maxY);
        return intersectWith(cbbOther);
    }

    public boolean intersectWith(CustomBB cbbOther){
        Vector2d AB = B.minus(A);//B - A
        Vector2d AD = D.minus(A);//D - A

        Vector2d AB1 = cbbOther.B.minus(cbbOther.A);
        Vector2d AD2 = cbbOther.D.minus(cbbOther.A);


        if(sideAxisIntersect(this,cbbOther,AB)){
            if(sideAxisIntersect(this,cbbOther,AD)){
                if(sideAxisIntersect(this,cbbOther,AB1)){
                    if(sideAxisIntersect(this,cbbOther,AD2)){
                        return true;
                    }
                }
            }
        }



//        double a1 = cbbOther.A.scalaWithOn(AB);
//        double b1 = cbbOther.B.scalaWithOn(AB);
//        double c1 = cbbOther.C.scalaWithOn(AB);
//        double d1 = cbbOther.D.scalaWithOn(AB);
//
//        double a2 = this.A.scalaWithOn(AB);
//        double b2 = this.B.scalaWithOn(AB);
//        double c2 = this.C.scalaWithOn(AB);
//        double d2 = this.D.scalaWithOn(AB);
//
////        double min1 = Math.min(Math.min(a1,b1) , Math.min(c1,d1));
//        double min1 = Utilities.minOfFour(a1,b1,c1,d1);
//        double max1 = Utilities.maxOfFour(a1,b1,c1,d1);
//
//        double min2 = Utilities.minOfFour(a2,b2,c2,d2);
//        double max2 = Utilities.maxOfFour(a2,b2,c2,d2);
//
//        if(max1 >= min2 && min1 <= max2){
//
//        }
//
//        if(max1 < min2 || min1 > max2){
//            return false;
//        }


        return false;
    }

    public boolean sideAxisIntersect(CustomBB cbb1, CustomBB cbb2, Vector2d v2d){
        double a1 = cbb2.A.scalaWithOn(v2d);
        double b1 = cbb2.B.scalaWithOn(v2d);
        double c1 = cbb2.C.scalaWithOn(v2d);
        double d1 = cbb2.D.scalaWithOn(v2d);

        double a2 = cbb1.A.scalaWithOn(v2d);
        double b2 = cbb1.B.scalaWithOn(v2d);
        double c2 = cbb1.C.scalaWithOn(v2d);
        double d2 = cbb1.D.scalaWithOn(v2d);

//        double min1 = Math.min(Math.min(a1,b1) , Math.min(c1,d1));
        double min1 = Utilities.minOfFour(a1,b1,c1,d1);
        double max1 = Utilities.maxOfFour(a1,b1,c1,d1);

        double min2 = Utilities.minOfFour(a2,b2,c2,d2);
        double max2 = Utilities.maxOfFour(a2,b2,c2,d2);

        if(max1 < min2 || min1 > max2){
            return false;
        }

        return true;
    }


}
