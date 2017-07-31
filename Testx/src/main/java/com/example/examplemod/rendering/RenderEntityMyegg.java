package com.example.examplemod.rendering;

import com.example.examplemod.Reference;
import com.example.examplemod.entity.projectile.EntityMyegg;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEntityMyegg extends Render<EntityMyegg>
{

    ResourceLocation CUSTOM_EGG_TEXTURE = new ResourceLocation(Reference.MODID + ":textures/items/myegg.png");

    @Override
    protected ResourceLocation getEntityTexture(EntityMyegg entity) {
        return CUSTOM_EGG_TEXTURE;
    }

    //private static final ResourceLocation COW_TEXTURES = new ResourceLocation("textures/entity/cow/cow.png");

    public RenderEntityMyegg(RenderManager renderManagerIn)
    {

        super(renderManagerIn);


        //bindTexture(CUSTOM_EGG_TEXTURE);
    }




}