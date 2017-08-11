package com.example.examplemod.worldManager;

import com.example.examplemod.util.math.CustomBB;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import javax.annotation.Nullable;
import java.util.List;

import static net.minecraft.world.World.MAX_ENTITY_RADIUS;

/**
 * Created by pijie on 2017/8/6.
 */
public class WorldManager{



    public static <T extends Entity> List<T> getEntitiesWithinAABB(World worldIn, Class <? extends T > clazz, CustomBB cbb, @Nullable Predicate<? super T > filter)
    {
        int i = MathHelper.floor_double((cbb.minX - MAX_ENTITY_RADIUS) / 16.0D);
        int j = MathHelper.ceiling_double_int((cbb.maxX + MAX_ENTITY_RADIUS) / 16.0D);
        int k = MathHelper.floor_double((cbb.minZ - MAX_ENTITY_RADIUS) / 16.0D);
        int l = MathHelper.ceiling_double_int((cbb.maxZ + MAX_ENTITY_RADIUS) / 16.0D);
        List<T> list = Lists.<T>newArrayList();

        for (int i1 = i; i1 < j; ++i1)
        {
            for (int j1 = k; j1 < l; ++j1)
            {

                if(worldIn.getChunkProvider().getLoadedChunk(i1,j1)!=null){


                    getEntitiesOfTypeWithinCB(worldIn.getChunkFromChunkCoords(i1, j1),clazz, cbb, list, filter);
                }

//                    worldIn.getChunkFromChunkCoords(i1, j1).getEntitiesOfTypeWithinAAAB(clazz, aabb, list, filter);

            }
        }

        return list;
    }

    public static <T extends Entity> void getEntitiesOfTypeWithinCB(Chunk chunkIn, Class <? extends T > entityClass, CustomBB cbb, List<T> listToFill, Predicate <? super T > filter)
        {
        int i = MathHelper.floor_double((cbb.minY - World.MAX_ENTITY_RADIUS) / 16.0D);
        int j = MathHelper.floor_double((cbb.maxY + World.MAX_ENTITY_RADIUS) / 16.0D);
        i = MathHelper.clamp_int(i, 0, chunkIn.getEntityLists().length - 1);
        j = MathHelper.clamp_int(j, 0, chunkIn.getEntityLists().length - 1);

        for (int k = i; k <= j; ++k)
        {
            for (T t : chunkIn.getEntityLists()[k].getByClass(entityClass))
            {
                if (cbb.intersectWith(t.getEntityBoundingBox()) && (filter == null || filter.apply(t)))
                {
                    listToFill.add(t);
                }



//                if (t.getEntityBoundingBox().intersectsWith(aabb) && (filter == null || filter.apply(t)))
//                {
//                    listToFill.add(t);
//                }
            }
        }
    }
}
