package com.example.examplemod.proxy;

import com.example.examplemod.entity.Livings.EntityWoc;
import com.example.examplemod.entity.projectile.EntityMyegg;
import com.example.examplemod.item.ItemEgga;
import com.example.examplemod.rendering.RenderEntityMyegg;
import com.example.examplemod.rendering.RenderEntityWoc;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

/**
 * Created by pijie on 2017/7/30.
 */
public class ClientProxy extends CommonProxy{

    @Override
    public void registerItemRenderer(Item item, int meta, String id){
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(/*Reference.MODID + ":" + id*/ item.getRegistryName(), "inventory"));

    }


    public void registerEntityRenderer(){

        System.out.println("TESTCODE");

//        RenderingRegistry.registerEntityRenderingHandler(EntityMyegg.class, new IRenderFactory<EntityMyegg>() {
//            @Override
//            public Render<? super EntityMyegg> createRenderFor(RenderManager manager) {
//                return new RenderEntityMyegg(manager, new ItemEgga(), RenderItem);
//            }
//        });

//        RenderingRegistry.registerEntityRenderingHandler(EntityMyegg.class, new IRenderFactory<EntityMyegg>() {
//            @Override
//            public Render<? super EntityMyegg> createRenderFor(RenderManager manager) {
//                return new RenderEntityMyegg(manager);
//            }
//        });

        RenderingRegistry.registerEntityRenderingHandler(EntityMyegg.class, new IRenderFactory<EntityMyegg>() {
            @Override
            public Render<? super EntityMyegg> createRenderFor(RenderManager manager) {
                return new RenderSnowball<EntityMyegg>(manager, Items.SNOWBALL,Minecraft.getMinecraft().getRenderItem());
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityWoc.class, new IRenderFactory<EntityWoc>() {
            @Override
            public Render<? super EntityWoc> createRenderFor(RenderManager manager) {
                return new RenderEntityWoc(manager);
            }
        });

//        RenderingRegistry.registerEntityRenderingHandler(EntityMyegg.class, new RenderEntityMyegg(Minecraft.getMinecraft().getRenderManager(), Items.SNOWBALL,Minecraft.getMinecraft().getRenderItem()));

//        RenderingRegistry.registerEntityRenderingHandler(EntityMyegg.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), Items.SNOWBALL,Minecraft.getMinecraft().getRenderItem()));

//        RenderingRegistry.registerEntityRenderingHandler(EntityMyegg.class, new RenderEntityMyegg(Minecraft.getMinecraft().getRenderManager(), Minecraft.getMinecraft().getRenderItem()));

//        RenderingRegistry.registerEntityRenderingHandler(EntityWoc.class, new RenderEntityWoc(Minecraft.getMinecraft().getRenderManager(), new ModelCow(), 0.5F));

    }

    @Override
    public void registerEntities(){
        super.registerEntities();
        registerEntityRenderer();
    }
}
