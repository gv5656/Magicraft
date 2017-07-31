package com.example.examplemod.rendering;

import com.example.examplemod.entity.projectile.EntityMyegg;
import com.example.examplemod.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by pijie on 2017/7/31.
 */
public class ProjectileRenderers {
    @SuppressWarnings("unchecked")
    @SideOnly(Side.CLIENT)
    public static void init() {
//        RenderingRegistry.registerEntityRenderingHandler(DisposableTurretProjectile.class, new ItemProjectileRenderer(Minecraft.getMinecraft().getRenderManager(), Minecraft.getMinecraft().getRenderItem()));
//        RenderingRegistry.registerEntityRenderingHandler(RocketProjectile.class, new RocketRenderer());
//        RenderingRegistry.registerEntityRenderingHandler(BulletProjectile.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), new ItemStack(ModItems.usableMetaItem, 1, 0).getItem(), Minecraft.getMinecraft().getRenderItem()));
//        RenderingRegistry.registerEntityRenderingHandler(GrenadeProjectile.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), new ItemStack(ModItems.ammoMetaItem, 1, 3).getItem(), Minecraft.getMinecraft().getRenderItem()));
//        RenderingRegistry.registerEntityRenderingHandler(BlazingClayProjectile.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), new ItemStack(ModItems.ammoMetaItem, 1, 0).getItem(), Minecraft.getMinecraft().getRenderItem()));
//        RenderingRegistry.registerEntityRenderingHandler(LaserProjectile.class, new LaserRenderer());

        RenderingRegistry.registerEntityRenderingHandler(EntityMyegg.class, new ItemProjectileRenderer(Minecraft.getMinecraft().getRenderManager(), Minecraft.getMinecraft().getRenderItem()));
    }
}
