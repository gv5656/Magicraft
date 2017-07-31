package com.example.examplemod.rendering;

import com.example.examplemod.Reference;
import com.example.examplemod.entity.projectile.EntityMyegg;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@SideOnly(Side.CLIENT)
public class RenderEntityMyegg<T extends Entity> extends Render<T>
{
//    protected final Item item;
//    private final RenderItem itemRenderer;
    private static final ResourceLocation CUSTOM_EGG_TEXTURE = new ResourceLocation("textures/items/egg.png");

//    public RenderEntityMyegg(RenderManager renderManagerIn, RenderItem itemRendererIn){
//        super(renderManagerIn);
//        this.itemRenderer = itemRendererIn;
//    }

    public RenderEntityMyegg(RenderManager renderManagerIn){
        super(renderManagerIn);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return CUSTOM_EGG_TEXTURE;
    }

//    @Override
//    protected ResourceLocation getEntityTexture(EntityMyegg entity) {
//        return CUSTOM_EGG_TEXTURE;
//    }

//    @Override
//    @Nonnull
//    @ParametersAreNonnullByDefault
//    protected ResourceLocation getEntityTexture(Entity entity) {
//        return CUSTOM_EGG_TEXTURE;
//    }

    //private static final ResourceLocation COW_TEXTURES = new ResourceLocation("textures/entity/cow/cow.png");

    //This is with 3 parameters: rendermanagerin and item and renderitem

//    public RenderEntityMyegg(RenderManager renderManagerIn, Item itemIn, RenderItem itemRendererIn)
//    {
//
//        super(renderManagerIn);
//        this.item = itemIn;
//        this.itemRenderer = itemRendererIn;
//
//
//        //bindTexture(CUSTOM_EGG_TEXTURE);
//    }

    //This is with 2 parameters: rendermanagerin and renderitem

//    public RenderEntityMyegg(RenderManager renderManagerIn, RenderItem itemRendererIn){
//        super(renderManagerIn);
//        this.itemRenderer = itemRendererIn;
//    }

    //This is with 1 parameter: renderManagerIn



//    public void doRender(EntityMyegg entity, double x, double y, double z, float entityYaw, float partialTicks)
//    {
//        bindEntityTexture(entity);
//
//        GlStateManager.pushMatrix();
//        GlStateManager.translate((float)x, (float)y, (float)z);
//        GlStateManager.enableRescaleNormal();
//        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
//        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
//        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
////        this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
//
//        if (this.renderOutlines)
//        {
//            GlStateManager.enableColorMaterial();
//            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
//        }
//
////        this.itemRenderer.renderItem(this.getStackToRender(entity), ItemCameraTransforms.TransformType.GROUND);
////        this.itemRenderer.renderItem(entity.getIt, ItemCameraTransforms.TransformType.GROUND);
//
//        if (this.renderOutlines)
//        {
//            GlStateManager.disableOutlineMode();
//            GlStateManager.disableColorMaterial();
//        }
//
//        GlStateManager.disableRescaleNormal();
//        GlStateManager.popMatrix();
//        super.doRender(entity, x, y, z, entityYaw, partialTicks);
//    }

//    public ItemStack getStackToRender(EntityMyegg entityIn)
//    {
//        return new ItemStack(this.item);
//    }


}

//import net.minecraft.client.renderer.RenderItem;
//import net.minecraft.client.renderer.entity.RenderManager;
//import net.minecraft.client.renderer.entity.RenderSnowball;
//import net.minecraft.item.Item;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//@SideOnly(Side.CLIENT)
//public class RenderEntityMyegg extends RenderSnowball{
//
//
//    public RenderEntityMyegg(RenderManager renderManagerIn, Item itemIn, RenderItem itemRendererIn) {
//        super(renderManagerIn, itemIn, itemRendererIn);
//    }
//}
