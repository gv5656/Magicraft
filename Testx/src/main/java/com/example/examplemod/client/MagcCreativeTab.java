package com.example.examplemod.client;

import com.example.examplemod.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * Created by pijie on 2017/7/30.
 */
public class MagcCreativeTab extends CreativeTabs{
    @Override
    public Item getTabIconItem() {
        return Items.ARROW;
    }

    public MagcCreativeTab(){
        super(Reference.MODID);
    }
}
