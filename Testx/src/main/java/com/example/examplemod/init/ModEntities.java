package com.example.examplemod.init;

import com.example.examplemod.entity.Livings.EntityWoc;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by pijie on 2017/7/31.
 */
public class ModEntities {

//    public static void registerEntities(){
//        GameRegistry.register(new EntityWoc());
//    }

    public static void generateSpawnEgg(){
        EntityRegistry.registerEgg(EntityWoc.class, 0,0);
    }
}
