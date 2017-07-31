package com.example.examplemod.rendering;

import com.example.examplemod.entity.Livings.EntityWoc;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by pijie on 2017/7/31.
 */
@SideOnly(Side.CLIENT)
public class RenderEntityWoc extends RenderLiving<EntityWoc>
{
    private static final ResourceLocation COW_TEXTURES = new ResourceLocation("textures/entity/cow/cow.png");

    public RenderEntityWoc(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelCow(), 0.5F);
    }

    public RenderEntityWoc(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
//    protected ResourceLocation getEntityTexture(EntityCow entity)
//    {
//        return COW_TEXTURES;
//    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWoc entity) {
        return COW_TEXTURES;
    }
}