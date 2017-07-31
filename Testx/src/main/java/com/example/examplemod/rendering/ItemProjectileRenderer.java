package com.example.examplemod.rendering;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Created by pijie on 2017/7/31.
 */
class ItemProjectileRenderer extends Render {

    private final RenderItem itemRenderer;
    private static final ResourceLocation CUSTOM_EGG_TEXTURE = new ResourceLocation("textures/items/diamond.png");

    public ItemProjectileRenderer(RenderManager renderManagerIn, RenderItem itemRendererIn) {
        super(renderManagerIn);
        this.itemRenderer = itemRendererIn;
    }



    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    protected ResourceLocation getEntityTexture(Entity entity) {
        return CUSTOM_EGG_TEXTURE;
    }

}