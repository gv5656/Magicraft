package com.example.examplemod.proxy;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.Livings.EntityWoc;
import com.example.examplemod.entity.projectile.EntityMyegg;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * Created by pijie on 2017/7/30.
 */
public class CommonProxy {

    int counter = 0;

    public void registerItemRenderer(Item item, int meta, String id){

    }

    public void registerEntityRenderer(){

    }

    public void registerEntities(){
        comProxEntityRegister(EntityMyegg.class,"egg");
        comProxEntityRegister(EntityWoc.class,"woc");
    }

    public void comProxEntityRegister(Class entityClass, String name){
        EntityRegistry.registerModEntity(entityClass, name, counter++, ExampleMod.instance, 16 * 4, 3, true);

    }



}
