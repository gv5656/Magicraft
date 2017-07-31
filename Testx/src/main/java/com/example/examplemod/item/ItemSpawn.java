package com.example.examplemod.item;

import com.example.examplemod.entity.Livings.EntityWoc;
import com.example.examplemod.entity.projectile.EntityMyegg;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * Created by pijie on 2017/7/31.
 */
public class ItemSpawn extends ItemBase{

    public ItemSpawn(){
        super("spawn");
    }

    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand){
        if (!playerIn.capabilities.isCreativeMode)
        {
            --itemStackIn.stackSize;
        }

        if (!worldIn.isRemote)
        {

            EntityWoc entityWoc = new EntityWoc(worldIn);
            worldIn.spawnEntityInWorld(entityWoc);
            System.out.println("WOC spawned!");
        }

        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
}
