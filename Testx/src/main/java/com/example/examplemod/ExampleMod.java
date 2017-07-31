package com.example.examplemod;

import com.example.examplemod.client.MagcCreativeTab;
import com.example.examplemod.init.ModEntities;
import com.example.examplemod.init.ModItems;
import com.example.examplemod.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class ExampleMod
{
    @Mod.Instance(Reference.MODID)
    public static ExampleMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static final MagcCreativeTab creativeTab = new MagcCreativeTab();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        System.out.println("Now preiniting...");

        ModItems.init();
        proxy.registerEntities();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
//        proxy.registerEntityRenderer();
        ModEntities.generateSpawnEgg();
        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }
}
