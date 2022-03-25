package io.wispforest.jello.api;

import io.wispforest.jello.api.dye.DyeColorant;
import io.wispforest.jello.api.dye.block.ColoredGlassBlock;
import io.wispforest.jello.api.dye.block.ColoredGlassPaneBlock;
import io.wispforest.jello.api.dye.client.BlockModelRedirect;
import io.wispforest.jello.api.dye.item.DyeItem;
import io.wispforest.jello.api.dye.client.DyeModelResourceRedirect;
import io.wispforest.jello.api.dye.registry.DyeColorantRegistry;
import io.wispforest.jello.api.dye.registry.DyedVariants;
import io.wispforest.jello.main.common.Jello;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.block.*;
import net.minecraft.block.entity.BedBlockEntity;
import net.minecraft.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryKey;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

public class JelloClientAPI implements ClientModInitializer {

    public static final Identifier BED_BLANKET_ONLY = new Identifier(Jello.MODID, "block/bed/blanket_only");
    public static final Identifier BED_PILLOW_ONLY = new Identifier(Jello.MODID, "block/bed/pillow_only");

    @Override
    public void onInitializeClient() {
        ColorProviderRegistry.BLOCK.register((BlockColorProvider) Blocks.WATER_CAULDRON, Blocks.WATER_CAULDRON);
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.WATER_CAULDRON, RenderLayer.getTranslucent());

        initJsonDyeItems();

        registerJsonBlocksForColor();

        ClientSpriteRegistryCallback.event(TexturedRenderLayers.BEDS_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(BED_BLANKET_ONLY);
            registry.register(BED_PILLOW_ONLY);
        });
    }

    //------------------------------------------------------------------------------

    private static void initJsonDyeItems(){
        ModelLoadingRegistry.INSTANCE.registerResourceProvider((manager) -> {
            return new DyeModelResourceRedirect();
        });

        ModelLoadingRegistry.INSTANCE.registerVariantProvider(resourceManager -> {
            return new BlockModelRedirect();
        });
    }



    private static void registerJsonBlocksForColor(){
        for(Map.Entry<DyeColorant, DyedVariants> dyedVariantEntry : DyedVariants.DYED_VARIANTS.entrySet()){
            if(!Objects.equals(dyedVariantEntry.getKey().getId().getNamespace(), "minecraft")) {
                for (Block block : dyedVariantEntry.getValue().dyedBlocks.values()) {
                    if (block instanceof ColoredGlassBlock || block instanceof ColoredGlassPaneBlock) {
                        ColorProviderRegistry.BLOCK.register((BlockColorProvider) block, block);
                        ColorProviderRegistry.ITEM.register((ItemColorProvider) block.asItem(), block.asItem());

                        BlockRenderLayerMapImpl.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
                        BlockRenderLayerMapImpl.INSTANCE.putItem(block.asItem(), RenderLayer.getTranslucent());
                    } else if (block instanceof ShulkerBoxBlock) {
                        BuiltinItemRendererRegistry.INSTANCE.register(block, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
                            ShulkerBoxBlockEntity shulkerBoxBlockEntity = new ShulkerBoxBlockEntity(DyeColorantRegistry.Constants.NULL_VALUE_OLD, BlockPos.ORIGIN, block.getDefaultState());

                            MinecraftClient.getInstance().getBlockEntityRenderDispatcher().get(shulkerBoxBlockEntity).render(shulkerBoxBlockEntity, 0.0F, matrices, vertexConsumers, light, overlay);
                        });
                    } else if (block instanceof BedBlock) {
                        BuiltinItemRendererRegistry.INSTANCE.register(block, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
                            BedBlockEntity renderBed = new BedBlockEntity(BlockPos.ORIGIN, block.getDefaultState());

                            MinecraftClient.getInstance().getBlockEntityRenderDispatcher().get(renderBed).render(renderBed, 0.0F, matrices, vertexConsumers, light, overlay);
                        });
                    } else {
                        ColorProviderRegistry.BLOCK.register((BlockColorProvider) block, block);

                        Item item = block.asItem();

                        if (item != Blocks.AIR.asItem()) {
                            ColorProviderRegistry.ITEM.register((ItemColorProvider) item, item);
                        }
                    }
                }

                for (Item item : dyedVariantEntry.getValue().dyedItems) {
                    ColorProviderRegistry.ITEM.register((DyeItem) item, item);

                    FabricModelPredicateProviderRegistry.register(item, new Identifier("variant"), (stack, world, entity, seed) -> DyeItem.getTextureVariant(stack));
                }
            }
        }
    }

    //------------------------------------------------------------------------------

}
