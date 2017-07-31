package com.example.examplemod.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.world.World;

/**
 * Created by pijie on 2017/7/30.
 */
public abstract class MyEntityThrowable extends EntityThrowable{

    public MyEntityThrowable(World worldIn) {
        super(worldIn);
    }

    public MyEntityThrowable(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public MyEntityThrowable(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    @Override
    public void onUpdate(){
        System.out.println("I JUST Want TO PRINT!!!!!!!!!!!!!!!!!!!!!");
        super.onUpdate();
    }
}
