package com.example.examplemod.init;

import com.example.examplemod.item.ItemEgga;
import com.example.examplemod.item.ItemFireWand;
import com.example.examplemod.item.ItemModelProvider;
import com.example.examplemod.item.ItemSpawn;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by pijie on 2017/7/30.
 */
public class ModItems {

    public static ItemEgga egga;
    public static ItemSpawn spawn;
    public static ItemFireWand fireWand;

    public static void init(){
        egga = register(new ItemEgga());
        spawn = register(new ItemSpawn());
        fireWand = register(new ItemFireWand());

    }

    public static <T extends Item> T register(T item){
        GameRegistry.register(item);

        if(item instanceof ItemModelProvider){
            ((ItemModelProvider)item).registerItemModel(item); //This call invokes first step of registering Model to the item
        }

        return item;
    }
}
