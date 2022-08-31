package io.wispforest.dye_entries.compat.condensedCreative;

import io.wispforest.common.util.ColorUtil;
import io.wispforest.condensed_creative.registry.CondensedCreativeInitializer;
import io.wispforest.condensed_creative.registry.CondensedEntryRegistry;
import io.wispforest.dye_entries.DyeEntriesInit;
import io.wispforest.dye_entries.variants.block.DyeableBlockVariant;
import io.wispforest.dye_entries.variants.item.DyeableItemVariant;
import io.wispforest.dye_registry.DyeColorant;
import io.wispforest.dye_registry.DyeColorantRegistry;
import io.wispforest.dye_registry.ducks.DyeBlockStorage;
import io.wispforest.dye_registry.ducks.DyeItemStorage;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JelloCCEntrypoint implements CondensedCreativeInitializer {

    @Override
    public void onInitializeCondensedEntries(boolean refreshed) {
        DyeableBlockVariant.getAllBlockVariants().stream().filter(dyeableBlockVariant -> !dyeableBlockVariant.alwaysReadOnly() && dyeableBlockVariant.createBlockItem()).forEach(dyeableBlockVariant -> {
            CondensedEntryRegistry.fromBlockTag(dyeableBlockVariant.variantIdentifier, dyeableBlockVariant.getDefaultBlock(), dyeableBlockVariant.getPrimaryBlockTag())
                .setTitleString(Text.translatable(dyeableBlockVariant.variantIdentifier.getPath() + "_condensed"))
                .setEntrySorting(allStacks -> {
                    Predicate<ItemStack> getNonVanillaBlocks = stack -> {
                        DyeColorant dyeColorant = ((DyeBlockStorage) ((BlockItem) stack.getItem()).getBlock()).getDyeColorant();
                        
                        return !DyeColorantRegistry.Constants.VANILLA_DYES.contains(dyeColorant);
                    };
                    
                    List<ItemStack> nonVanillaStacks = allStacks.stream().filter(getNonVanillaBlocks).collect(Collectors.toList());
                    allStacks.removeIf(getNonVanillaBlocks);

                    nonVanillaStacks.sort(Comparator.comparingDouble(stack -> {
                        float[] hsl = ColorUtil.rgbToHsl(((DyeBlockStorage) ((BlockItem) stack.getItem()).getBlock()).getDyeColorant().getBaseColor());

                        return hsl[2];
                    }));

                    nonVanillaStacks.sort(Comparator.comparingDouble(stack -> {
                        float[] hsl = ColorUtil.rgbToHsl(((DyeBlockStorage) ((BlockItem) stack.getItem()).getBlock()).getDyeColorant().getBaseColor());

                        return hsl[1];
                    }));

                    nonVanillaStacks.sort(Comparator.comparingDouble(stack -> {
                        float[] hsl = ColorUtil.rgbToHsl(((DyeBlockStorage) ((BlockItem) stack.getItem()).getBlock()).getDyeColorant().getBaseColor());

                        return hsl[0];
                    }));
                    
                    allStacks.addAll(nonVanillaStacks);

                    Block defaultBlock = dyeableBlockVariant.getDefaultBlock();

                    if(defaultBlock instanceof DyeBlockStorage dyeBlockStorage && dyeBlockStorage.getDyeColorant() != DyeColorantRegistry.WHITE){
                        allStacks.add(0, defaultBlock.asItem().getDefaultStack());
                    }
                })
                .addItemGroup(DyeEntriesInit.MAIN_ITEM_GROUP, 1);

        });

        DyeableItemVariant.getAllItemVariants().stream().filter(dyeableBlockVariant -> !dyeableBlockVariant.alwaysReadOnly()).forEach(dyeableBlockVariant -> {
            CondensedEntryRegistry.fromItemTag(dyeableBlockVariant.variantIdentifier, dyeableBlockVariant.getDefaultItem(), dyeableBlockVariant.getPrimaryItemTag())
                    .setTitleString(Text.translatable(dyeableBlockVariant.variantIdentifier.getPath() + "_condensed"))
                    .setEntrySorting(allStacks -> {
                        Predicate<ItemStack> getNonVanillaItem = stack -> {
                            DyeColorant dyeColorant = ((DyeItemStorage) stack.getItem()).getDyeColorant();

                            return !DyeColorantRegistry.Constants.VANILLA_DYES.contains(dyeColorant);
                        };

                        List<ItemStack> nonVanillaStacks = allStacks.stream().filter(getNonVanillaItem).collect(Collectors.toList());
                        allStacks.removeIf(getNonVanillaItem);

                        nonVanillaStacks.sort(Comparator.comparingDouble(stack -> {
                            float[] hsl = ColorUtil.rgbToHsl(((DyeItemStorage) stack.getItem()).getDyeColorant().getBaseColor());

                            return hsl[2];
                        }));

                        nonVanillaStacks.sort(Comparator.comparingDouble(stack -> {
                            float[] hsl = ColorUtil.rgbToHsl(((DyeItemStorage) stack.getItem()).getDyeColorant().getBaseColor());

                            return hsl[1];
                        }));

                        nonVanillaStacks.sort(Comparator.comparingDouble(stack -> {
                            float[] hsl = ColorUtil.rgbToHsl(((DyeItemStorage) stack.getItem()).getDyeColorant().getBaseColor());

                            return hsl[0];
                        }));

                        allStacks.addAll(nonVanillaStacks);

                        Item defaultItem = dyeableBlockVariant.getDefaultItem();

                        if(defaultItem instanceof DyeItemStorage dyeItemStorage && dyeItemStorage.getDyeColorant() != DyeColorantRegistry.WHITE){
                            allStacks.add(0, defaultItem.getDefaultStack());
                        }
                    })
                    .addItemGroup(DyeEntriesInit.MAIN_ITEM_GROUP, 0);

        });

        //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//        List<Item> slimeSlabs = DyeColorantRegistry.Constants.VANILLA_DYES.stream().map(JelloBlockVariants.SLIME_SLAB::getColoredBlockItem).collect(Collectors.toList());
//
//        slimeSlabs.add(0, JelloBlocks.SLIME_SLAB.asItem());
//
//        CondensedEntryRegistry.fromItems(JelloConstants.id("vanilla_slime_slabs"), JelloBlocks.SLIME_SLAB, slimeSlabs)
//                .setTitleString(Text.translatable("vanilla_slime_slabs_condensed"))
//                .setExtraInfoText(Text.translatable("tooltip.vanilla_slime_slabs_condensed").formatted(Formatting.GRAY))
//                .addItemGroup(ItemGroup.REDSTONE);
//
//        //--------------------
//
//        List<Item> slimeBlocks = DyeColorantRegistry.Constants.VANILLA_DYES.stream().map(JelloBlockVariants.SLIME_BLOCK::getColoredBlockItem).collect(Collectors.toList());
//
//        slimeBlocks.add(0, Blocks.SLIME_BLOCK.asItem());
//
//        CondensedEntryRegistry.fromItems(JelloConstants.id("vanilla_slime_blocks"), Blocks.SLIME_BLOCK, slimeBlocks)
//                .setTitleString(Text.translatable("vanilla_slime_blocks_condensed"))
//                .setExtraInfoText(Text.translatable("tooltip.vanilla_slime_blocks_condensed").formatted(Formatting.GRAY))
//                .addItemGroup(ItemGroup.REDSTONE);

    }
}
