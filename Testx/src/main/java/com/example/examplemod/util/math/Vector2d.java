package com.example.examplemod.util.math;

/**
 * Created by pijie on 2017/8/6.
 */
public class Vector2d {
    public double x;
    public double y;
    public Vector2d(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double returnNormSqrd(){
        double result = x*x + y*y;
        return result;
    }

    public Vector2d addWith(Vector2d other){

        Vector2d resultVector = new Vector2d(x+other.x,y+other.y);

        return resultVector;
    }

    public Vector2d minus(Vector2d other){

        Vector2d resultVector = new Vector2d(x-other.x,y-other.y);

        return resultVector;
    }

    public double dotProductWith(Vector2d other){
        double result = this.x * other.x + this.y * other.y;
        return result;
    }

    public double scalaWithOn(Vector2d other){
        double result = dotProductWith(other);
        result = result / (other.returnNormSqrd());
        return result;
    }

    public Vector2d getPpdvWithNorm(double norm){
        double yl=  Math.sqrt(norm * norm * this.x * this.x / (this.y * this.y + this.x * this.x));
        double xl = Math.sqrt(norm * norm - (norm * norm * this.x * this.x / (this.x * this.x + this.y * this.y) ));
        double x2 = -xl;
        double y2 = -yl;

        /**
         * originally planned code
         */
//        Vector2d result = new Vector2d(xl, yl);
//        Vector2d result1= new Vector2d(-xl,-yl);
//
//        if(this.x>=0 && this.y>=0){
//
//        }
//        else if(this.x>0 && this.y<0){
//
//        }
//        else if(this.x<0){
//
//        }
//        else{
//
//        }

        if (this.x>=0){
            if(y>=0){
                return new Vector2d(x2,yl);
            }
            else{
                return new Vector2d(xl,yl);
            }
        }
        else{
            if(y>=0){
                return new Vector2d(x2,y2);
            }
            else{
                return new Vector2d(xl,y2);
            }
        }

//        if(this.x*this.y<0){
//            return result1;
//        }
//        return result;
    }

    public Vector2d getNegativ(){
        Vector2d result = new Vector2d(- this.x, -this.y);
        return result;
    }

    public Vector2d scaleWith(double multiplier){
        Vector2d result = new Vector2d(this.x * multiplier, this.y * multiplier);
        return result;
    }
}
