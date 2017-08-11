package com.example.examplemod.item;

import com.example.examplemod.util.math.CustomBB;
import com.example.examplemod.util.math.Vector2d;
import com.example.examplemod.worldManager.WorldManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.Sys;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

/**
 * Created by pijie on 2017/8/3.
 */
public class ItemFireWand extends ItemBase{

    private Random rand;
    private boolean flag;

    public double ptclMotionX;
    public double ptclMotionY;
    public double ptclMotionZ;


    /**
     * The following keeps the coordinates of the unit vector aligned with player's heading
     */

    public static double playerHeadingX;
    public static double playerHeadingY;
    public static double playerHeadingZ;

    public ItemFireWand(){
        super("fire_wand");
        rand = new Random();

    }

    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected){
        if(flag == true){

            double d0 = entityIn.posX;
            double d1 = entityIn.posY+1;
            double d2 = entityIn.posZ;


//        setHeadingFromThrower(playerIn,playerIn.rotationPitch, playerIn.rotationYaw, 0.0F,0.5F,1.0F);
//
//        double v0 = ptclMotionX;
//        double v1 = ptclMotionY;
//        double v2 = ptclMotionZ;

            if(worldIn.isRemote) {

                for(int i=0;i<20;i++){

                    setHeadingFromThrower(entityIn,entityIn.rotationPitch, entityIn.rotationYaw, 0.0F,0.5F,12.0F);

                    double v0 = ptclMotionX;
                    double v1 = ptclMotionY;
                    double v2 = ptclMotionZ;

//                    System.out.print("v0 is:");
//                    System.out.println(v0);
//                    System.out.println(v1);
//                    System.out.println(v2);

//                    System.out.println("SquareRoot is" + Math.sqrt(v0+v1+v2));

//                    System.out.println("SSS::"+v0+","+v1+","+v2);

                    spawnParticle(d0, d1, d2, v0, v1, v2, worldIn, (EntityPlayer)entityIn);

                    /*
                    Following is the original good line, disabled for testing
                     */

//                    spawnParticle(d0+v0*3.5, d1+v1*3.5, d2+v2*3.5, v0, v1, v2, worldIn, (EntityPlayer)entityIn);
                }

            }


            /**
             * The following code handles the fire damage logic (apply fire damage)
             */

            AxisAlignedBB fireArea = new AxisAlignedBB(entityIn.posX-2+ptclMotionX*3, entityIn.posY+1+ptclMotionY*3, entityIn.posZ-2+ptclMotionZ*3,entityIn.posX+2+ptclMotionX*3,entityIn.posY+3+ptclMotionY*3,entityIn.posZ+2+ptclMotionZ*3);



            Vector2d headingVector = new Vector2d(playerHeadingX, playerHeadingZ);

            /**
             * scaleWith sets the length
             * getPpdWithNorm sets the breadth
             */

            headingVector = headingVector.scaleWith(5);

            Vector2d change = headingVector.getPpdvWithNorm(0.6);
            Vector2d result1 = headingVector.addWith(change);
            Vector2d result2 = headingVector.addWith(change.getNegativ());


            Vector2d v2d1 = new Vector2d(d0 + result1.x,d2 + result1.y);
            Vector2d v2d2 = new Vector2d(d0 + result2.x,d2 + result2.y);
            Vector2d v2d3 = new Vector2d(d0+change.x,d2 + change.y);
            Vector2d v2d4 = new Vector2d(d0+change.getNegativ().x,d2 + change.getNegativ().y);


            CustomBB fireArea2 = new CustomBB(v2d1,v2d2,v2d4,v2d3,d1,d1+3);



            if(!worldIn.isRemote){
//                List<EntityLivingBase> list = worldIn.<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class, fireArea);
                List<EntityLivingBase> list = WorldManager.<EntityLivingBase>getEntitiesWithinAABB(worldIn, EntityLivingBase.class, fireArea2, EntitySelectors.NOT_SPECTATING);

                if (!list.isEmpty()) {
                    for (EntityLivingBase entitylivingbase : list) {
                        entitylivingbase.attackEntityFrom(DamageSource.magic, (float)1);
                        entitylivingbase.setFire(4);
                    }
                }
            }
        }
    }

    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft){
        this.flag = false;
    }

    public ActionResult<ItemStack> onItemRightClick(@Nullable ItemStack itemStackIn, World worldIn,@Nullable EntityPlayer playerIn,@Nullable EnumHand hand){
        this.flag = true;
        playerIn.setActiveHand(hand);

//        ItemStack itemstack = playerIn.getHeldItem(hand);

//        if (itemstack != null && !playerIn.isHandActive()) {
//            int duration = net.minecraftforge.event.ForgeEventFactory.onItemUseStart(playerIn, itemstack, itemstack.getMaxItemUseDuration());
//            System.out.println("DURATION is: " + duration);
//        }



        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }



    public ActionResult<ItemStack> onItemRightClick1(@Nullable ItemStack itemStackIn, World worldIn,@Nullable EntityPlayer playerIn,@Nullable EnumHand hand){

        if (!playerIn.capabilities.isCreativeMode)
        {
            --itemStackIn.stackSize;
        }


        double d0 = playerIn.posX;
        double d1 = playerIn.posY+1;
        double d2 = playerIn.posZ;


//        setHeadingFromThrower(playerIn,playerIn.rotationPitch, playerIn.rotationYaw, 0.0F,0.5F,1.0F);
//
//        double v0 = ptclMotionX;
//        double v1 = ptclMotionY;
//        double v2 = ptclMotionZ;

        if(worldIn.isRemote) {

            for(int i=0;i<20;i++){

                setHeadingFromThrower(playerIn,playerIn.rotationPitch, playerIn.rotationYaw, 0.0F,0.5F,1.0F);

                double v0 = ptclMotionX;
                double v1 = ptclMotionY;
                double v2 = ptclMotionZ;

                System.out.println("SSS::"+v0+","+v1+","+v2);

                spawnParticle(d0+v0*1000, d1+v1*1000, d2+v2*1000, v0, v1, v2, worldIn, playerIn);
            }

        }
//        for (int k = 0; k < 20; ++k)
//        {
////            worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
////            worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
//
//            worldIn.spawnParticle(EnumParticleTypes.ITEM_CRACK, playerIn.posX, playerIn.posY, playerIn.posZ, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, new int[] {Item.getIdFromItem(Items.DIAMOND)});
//        }

        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }

//    @SideOnly(Side.CLIENT)
    public static void spawnParticle(double d00, double d11, double d22,double v00, double v11, double v22, World worldIn, EntityPlayer playerIn){
//        for (int k = 0; k < 20; ++k)
//        {

//        Vector2d v2d1 = new Vector2d(d00-2,d22 - 2);
//        Vector2d v2d2 = new Vector2d(d00-2,d22 + 2);
//        Vector2d v2d3 = new Vector2d(d00+2,d22 - 2);
//        Vector2d v2d4 = new Vector2d(d00+2,d22 + 2);

        Vector2d headingVector = new Vector2d(playerHeadingX, playerHeadingZ);

        headingVector = headingVector.scaleWith(13);

        Vector2d change = headingVector.getPpdvWithNorm(1);
        Vector2d result1 = headingVector.addWith(change);
        Vector2d result2 = headingVector.addWith(change.getNegativ());


        Vector2d v2d1 = new Vector2d(d00 + result1.x,d22 + result1.y);
        Vector2d v2d2 = new Vector2d(d00 + result2.x,d22 + result2.y);
        Vector2d v2d3 = new Vector2d(d00+change.x,d22 + change.y);
        Vector2d v2d4 = new Vector2d(d00+change.getNegativ().x,d22 + change.getNegativ().y);


        CustomBB cbb = new CustomBB(v2d1,v2d2,v2d4,v2d3,d11,d11+3);

//        worldIn.spawnParticle(EnumParticleTypes.HEART,d00+headingVector.x,cbb.minY+1, d22+ headingVector.y,0,0,0,new int[0]);


        /**
         * The following code is used to test the Custom bounding box
         */
//        worldIn.spawnParticle(EnumParticleTypes.HEART,cbb.A.x,cbb.minY+1, cbb.A.y,0,0,0,new int[0]);
//        worldIn.spawnParticle(EnumParticleTypes.HEART,cbb.B.x,cbb.minY+1, cbb.B.y,0,0,0,new int[0]);
//        worldIn.spawnParticle(EnumParticleTypes.HEART,cbb.C.x,cbb.minY+1, cbb.C.y,0,0,0,new int[0]);
//        worldIn.spawnParticle(EnumParticleTypes.HEART,cbb.D.x,cbb.minY+1, cbb.D.y,0,0,0,new int[0]);
//
//        worldIn.spawnParticle(EnumParticleTypes.HEART,cbb.A.x,cbb.minY+3, cbb.A.y,0,0,0,new int[0]);
//        worldIn.spawnParticle(EnumParticleTypes.HEART,cbb.B.x,cbb.minY+3, cbb.B.y,0,0,0,new int[0]);
//        worldIn.spawnParticle(EnumParticleTypes.HEART,cbb.C.x,cbb.minY+3, cbb.C.y,0,0,0,new int[0]);
//        worldIn.spawnParticle(EnumParticleTypes.HEART,cbb.D.x,cbb.minY+3, cbb.D.y,0,0,0,new int[0]);



            worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d00, d11, d22, v00, v11, v22, new int[0]);
            worldIn.spawnParticle(EnumParticleTypes.FLAME, d00, d11, d22, v00, v11, v22, new int[0]);


//            worldIn.spawnParticle(EnumParticleTypes.FLAME, d00, d11, d22-0.5D, 0.5D, 0.0D, 0.0D, new int[0]);
//            worldIn.spawnParticle(EnumParticleTypes.FLAME, d00, d11, d22+0.5D, 0.5D, 0.0D, 0.0D, new int[0]);
//            worldIn.spawnParticle(EnumParticleTypes.FLAME, d00, d11, d22, 0.5D, 0.0D, -0.25D, new int[0]);
//            worldIn.spawnParticle(EnumParticleTypes.FLAME, d00, d11, d22, 0.5D, 0.0D, 0.25D, new int[0]);

//            worldIn.spawnParticle(EnumParticleTypes.ITEM_CRACK, playerIn.posX, playerIn.posY, playerIn.posZ, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, new int[] {Item.getIdFromItem(Items.DIAMOND)});
//        }
    }

    /**
     * Sets throwable heading based on an entity that's throwing it
     */
    public void setHeadingFromThrower(Entity entityThrower, float rotationPitchIn, float rotationYawIn, float pitchOffset, float velocity, float inaccuracy)
    {
        float f = -MathHelper.sin(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);
        float f1 = -MathHelper.sin((rotationPitchIn + pitchOffset) * 0.017453292F);
        float f2 = MathHelper.cos(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);

        /**
         * used to check the directed unit vector
         */
        //System.out.println("SquareRoot is" + Math.sqrt(f*f+f1*f1+f2*f2));

        this.setThrowableHeading((double)f, (double)f1, (double)f2, velocity, inaccuracy);
        this.ptclMotionX += entityThrower.motionX;
        this.ptclMotionZ += entityThrower.motionZ;

        if (!entityThrower.onGround)
        {
            this.ptclMotionY += entityThrower.motionY;
        }
    }

    /**
     * Similar to setArrowHeading, it's point the throwable entity to a x, y, z direction.
     */
    public void setThrowableHeading(double x, double y, double z, float velocity, float inaccuracy)
    {
        float f = MathHelper.sqrt_double(x * x + y * y + z * z);
        x = x / (double)f;
        y = y / (double)f;
        z = z / (double)f;

        playerHeadingX = x;
        playerHeadingY = y;
        playerHeadingZ = z;

        /**
         * used to check the directed unit vector
         */

        //System.out.println("SquareRootF is" + f);

        x = x + this.rand.nextGaussian() * 0.007499999832361937D * (double)inaccuracy;
        y = y + this.rand.nextGaussian() * 0.007499999832361937D * (double)inaccuracy;
        z = z + this.rand.nextGaussian() * 0.007499999832361937D * (double)inaccuracy;
        x = x * (double)velocity;
        y = y * (double)velocity;
        z = z * (double)velocity;
        this.ptclMotionX = x;
        this.ptclMotionY = y;
        this.ptclMotionZ = z;
//        float f1 = MathHelper.sqrt_double(x * x + z * z);
//        this.rotationYaw = (float)(MathHelper.atan2(x, z) * (180D / Math.PI));
//        this.rotationPitch = (float)(MathHelper.atan2(y, (double)f1) * (180D / Math.PI));
//        this.prevRotationYaw = this.rotationYaw;
//        this.prevRotationPitch = this.rotationPitch;
//        this.ticksInGround = 0;
    }
}
