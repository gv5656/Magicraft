package com.example.examplemod.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
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

//                    System.out.println("SSS::"+v0+","+v1+","+v2);

                    spawnParticle(d0+v0*3.5, d1+v1*3.5, d2+v2*3.5, v0, v1, v2, worldIn, (EntityPlayer)entityIn);
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
