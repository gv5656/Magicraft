package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import scala.tools.nsc.MainClass;

/**
 * Created by pijie on 2017/7/30.
 */
public class ItemBase extends Item implements ItemModelProvider{
    protected String name;

    public ItemBase(String name){
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);

        setCreativeTab(ExampleMod.creativeTab); //So all items extending itemBase go into own creativetab
    }


    @Override
    public void registerItemModel(Item item) {
        ExampleMod.proxy.registerItemRenderer(item, 0, name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab){
        super.setCreativeTab(tab);
        return this;
    }
}
