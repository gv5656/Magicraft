package com.example.examplemod.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * Created by pijie on 2017/7/30.
 */


public class EntityMyegg extends MyEntityThrowable
{

    protected String name = "my_egg";

    public EntityMyegg(World worldIn)
    {
        super(worldIn);
    }

    public EntityMyegg(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public EntityMyegg(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public static void registerFixesEgg(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "ThrownEgg");
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result)
    {
        if (result.entityHit != null)
        {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 3.0F);
        }

//        if (!this.worldObj.isRemote && this.rand.nextInt(8) == 0)
//        {
//            int i = 1;
//
//            if (this.rand.nextInt(32) == 0)
//            {
//                i = 4;
//            }
//
//            for (int j = 0; j < i; ++j)
//            {
//                EntityChicken entitychicken = new EntityChicken(this.worldObj);
//                entitychicken.setGrowingAge(-24000);
//                entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
//                this.worldObj.spawnEntityInWorld(entitychicken);
//            }
//        }

//        double d0 = 0.08D;

        double d0 = this.posX;
        double d1 = this.posY;
        double d2 = this.posZ;


        for (int k = 0; k < 8; ++k)
        {
            this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);

            this.worldObj.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
            this.worldObj.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, new int[] {Item.getIdFromItem(Items.DIAMOND)});
        }



        if (!this.worldObj.isRemote && (result.typeOfHit == RayTraceResult.Type.BLOCK))
        {
            this.setDead();
        }
    }
}
