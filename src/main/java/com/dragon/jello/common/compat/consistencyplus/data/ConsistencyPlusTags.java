package com.dragon.jello.common.compat.consistencyplus.data;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ConsistencyPlusTags {
    public static final String CONSISTENCY_PLUS_MODID = "consistency_plus";

    public static class DyeableBlocks {
        public static final List<Tag.Identified<Block>> ALL_DYEABLE_BLOCK_TAGS = new ArrayList<>();

        public static final Tag.Identified<Block> TERRACOTTA_SLABS = register(new Identifier(CONSISTENCY_PLUS_MODID, "terracotta_slabs"));
        public static final Tag.Identified<Block> TERRACOTTA_STAIRS = register(new Identifier(CONSISTENCY_PLUS_MODID, "terracotta_stairs"));
        public static final Tag.Identified<Block> TERRACOTTA_WALLS = register(new Identifier(CONSISTENCY_PLUS_MODID, "terracotta_walls"));
        public static final Tag.Identified<Block> TERRACOTTA_GATES = register(new Identifier(CONSISTENCY_PLUS_MODID, "terracotta_gates"));

        public static final Tag.Identified<Block> COBBLED_TERRACOTTA = register(new Identifier(CONSISTENCY_PLUS_MODID, "cobbled_terracotta"));
        public static final Tag.Identified<Block> COBBLED_TERRACOTTA_SLABS = register(new Identifier(CONSISTENCY_PLUS_MODID, "cobbled_terracotta_slabs"));
        public static final Tag.Identified<Block> COBBLED_TERRACOTTA_STAIRS = register(new Identifier(CONSISTENCY_PLUS_MODID, "cobbled_terracotta_stairs"));
        public static final Tag.Identified<Block> COBBLED_TERRACOTTA_WALLS = register(new Identifier(CONSISTENCY_PLUS_MODID, "cobbled_terracotta_walls"));
        public static final Tag.Identified<Block> COBBLED_TERRACOTTA_GATES = register(new Identifier(CONSISTENCY_PLUS_MODID, "cobbled_terracotta_gates"));

        public static final Tag.Identified<Block> SMOOTH_TERRACOTTA = register(new Identifier(CONSISTENCY_PLUS_MODID, "smooth_terracotta"));
        public static final Tag.Identified<Block> SMOOTH_TERRACOTTA_SLABS = register(new Identifier(CONSISTENCY_PLUS_MODID, "smooth_terracotta_slabs"));
        public static final Tag.Identified<Block> SMOOTH_TERRACOTTA_STAIRS = register(new Identifier(CONSISTENCY_PLUS_MODID, "smooth_terracotta_stairs"));
        public static final Tag.Identified<Block> SMOOTH_TERRACOTTA_WALLS = register(new Identifier(CONSISTENCY_PLUS_MODID, "smooth_terracotta_walls"));
        public static final Tag.Identified<Block> SMOOTH_TERRACOTTA_GATES = register(new Identifier(CONSISTENCY_PLUS_MODID, "smooth_terracotta_gates"));

        public static final Tag.Identified<Block> POLISHED_TERRACOTTA = register(new Identifier(CONSISTENCY_PLUS_MODID, "polished_terracotta"));
        public static final Tag.Identified<Block> POLISHED_TERRACOTTA_SLABS = register(new Identifier(CONSISTENCY_PLUS_MODID, "polished_terracotta_slabs"));
        public static final Tag.Identified<Block> POLISHED_TERRACOTTA_STAIRS = register(new Identifier(CONSISTENCY_PLUS_MODID, "polished_terracotta_stairs"));
        public static final Tag.Identified<Block> POLISHED_TERRACOTTA_WALLS = register(new Identifier(CONSISTENCY_PLUS_MODID, "polished_terracotta_walls"));
        public static final Tag.Identified<Block> POLISHED_TERRACOTTA_GATES = register(new Identifier(CONSISTENCY_PLUS_MODID, "polished_terracotta_gates"));

        public static final Tag.Identified<Block> CUT_TERRACOTTA = register(new Identifier(CONSISTENCY_PLUS_MODID, "cut_terracotta"));
        public static final Tag.Identified<Block> CUT_TERRACOTTA_SLABS = register(new Identifier(CONSISTENCY_PLUS_MODID, "cut_terracotta_slabs"));
        public static final Tag.Identified<Block> CUT_TERRACOTTA_STAIRS = register(new Identifier(CONSISTENCY_PLUS_MODID, "cut_terracotta_stairs"));
        public static final Tag.Identified<Block> CUT_TERRACOTTA_WALLS = register(new Identifier(CONSISTENCY_PLUS_MODID, "cut_terracotta_walls"));
        public static final Tag.Identified<Block> CUT_TERRACOTTA_GATES = register(new Identifier(CONSISTENCY_PLUS_MODID, "cut_terracotta_gates"));

        public static final Tag.Identified<Block> TERRACOTTA_BRICK = register(new Identifier(CONSISTENCY_PLUS_MODID, "terracotta_brick"));
        public static final Tag.Identified<Block> TERRACOTTA_BRICK_SLABS = register(new Identifier(CONSISTENCY_PLUS_MODID, "terracotta_brick_slabs"));
        public static final Tag.Identified<Block> TERRACOTTA_BRICK_STAIRS = register(new Identifier(CONSISTENCY_PLUS_MODID, "terracotta_brick_stairs"));
        public static final Tag.Identified<Block> TERRACOTTA_BRICK_WALLS = register(new Identifier(CONSISTENCY_PLUS_MODID, "terracotta_brick_walls"));
        public static final Tag.Identified<Block> TERRACOTTA_BRICK_GATES = register(new Identifier(CONSISTENCY_PLUS_MODID, "terracotta_brick_gates"));

        public static final Tag.Identified<Block> TERRACOTTA_TILES = register(new Identifier(CONSISTENCY_PLUS_MODID, "terracotta_tile"));
        public static final Tag.Identified<Block> TERRACOTTA_TILES_SLABS = register(new Identifier(CONSISTENCY_PLUS_MODID, "terracotta_tile_slabs"));
        public static final Tag.Identified<Block> TERRACOTTA_TILES_STAIRS = register(new Identifier(CONSISTENCY_PLUS_MODID, "terracotta_tile_stairs"));
        public static final Tag.Identified<Block> TERRACOTTA_TILES_WALLS = register(new Identifier(CONSISTENCY_PLUS_MODID, "terracotta_tile_walls"));
        public static final Tag.Identified<Block> TERRACOTTA_TILES_GATES = register(new Identifier(CONSISTENCY_PLUS_MODID, "terracotta_tile_gates"));

        public static final Tag.Identified<Block> TERRACOTTA_CORNER_PILLAR = register(new Identifier(CONSISTENCY_PLUS_MODID, "terracotta_corner_pillar"));
        public static final Tag.Identified<Block> TERRACOTTA_PILLAR = register(new Identifier(CONSISTENCY_PLUS_MODID, "terracotta_pillar"));
        public static final Tag.Identified<Block> CHISELED_TERRACOTTA = register(new Identifier(CONSISTENCY_PLUS_MODID, "chiseled_terracotta"));
        public static final Tag.Identified<Block> CARVED_TERRACOTTA = register(new Identifier(CONSISTENCY_PLUS_MODID, "carved_terracotta"));

        public static final Tag.Identified<Block> CONCRETE_SLABS = register(new Identifier(CONSISTENCY_PLUS_MODID, "concrete_slabs"));
        public static final Tag.Identified<Block> CONCRETE_STAIRS = register(new Identifier(CONSISTENCY_PLUS_MODID, "concrete_stairs"));
        public static final Tag.Identified<Block> CONCRETE_WALLS = register(new Identifier(CONSISTENCY_PLUS_MODID, "concrete_walls"));
        public static final Tag.Identified<Block> CONCRETE_GATES = register(new Identifier(CONSISTENCY_PLUS_MODID, "concrete_gates"));

        public static final Tag.Identified<Block> SMOOTH_CONCRETE = register(new Identifier(CONSISTENCY_PLUS_MODID, "smooth_concrete"));
        public static final Tag.Identified<Block> SMOOTH_CONCRETE_SLABS = register(new Identifier(CONSISTENCY_PLUS_MODID, "smooth_concrete_slabs"));
        public static final Tag.Identified<Block> SMOOTH_CONCRETE_STAIRS = register(new Identifier(CONSISTENCY_PLUS_MODID, "smooth_concrete_stairs"));
        public static final Tag.Identified<Block> SMOOTH_CONCRETE_WALLS = register(new Identifier(CONSISTENCY_PLUS_MODID, "smooth_concrete_walls"));
        public static final Tag.Identified<Block> SMOOTH_CONCRETE_GATES = register(new Identifier(CONSISTENCY_PLUS_MODID, "smooth_concrete_gates"));

        public static final Tag.Identified<Block> POLISHED_CONCRETE = register(new Identifier(CONSISTENCY_PLUS_MODID, "polished_concrete"));
        public static final Tag.Identified<Block> POLISHED_CONCRETE_SLABS = register(new Identifier(CONSISTENCY_PLUS_MODID, "polished_concrete_slabs"));
        public static final Tag.Identified<Block> POLISHED_CONCRETE_STAIRS = register(new Identifier(CONSISTENCY_PLUS_MODID, "polished_concrete_stairs"));
        public static final Tag.Identified<Block> POLISHED_CONCRETE_WALLS = register(new Identifier(CONSISTENCY_PLUS_MODID, "polished_concrete_walls"));
        public static final Tag.Identified<Block> POLISHED_CONCRETE_GATES = register(new Identifier(CONSISTENCY_PLUS_MODID, "polished_concrete_gates"));

        public static final Tag.Identified<Block> CUT_CONCRETE = register(new Identifier(CONSISTENCY_PLUS_MODID, "cut_concrete"));
        public static final Tag.Identified<Block> CUT_CONCRETE_SLABS = register(new Identifier(CONSISTENCY_PLUS_MODID, "cut_concrete_slabs"));
        public static final Tag.Identified<Block> CUT_CONCRETE_STAIRS = register(new Identifier(CONSISTENCY_PLUS_MODID, "cut_concrete_stairs"));
        public static final Tag.Identified<Block> CUT_CONCRETE_WALLS = register(new Identifier(CONSISTENCY_PLUS_MODID, "cut_concrete_walls"));
        public static final Tag.Identified<Block> CUT_CONCRETE_GATES = register(new Identifier(CONSISTENCY_PLUS_MODID, "cut_concrete_gates"));

        public static final Tag.Identified<Block> CONCRETE_BRICK = register(new Identifier(CONSISTENCY_PLUS_MODID, "concrete_brick"));
        public static final Tag.Identified<Block> CONCRETE_BRICK_SLABS = register(new Identifier(CONSISTENCY_PLUS_MODID, "concrete_brick_slabs"));
        public static final Tag.Identified<Block> CONCRETE_BRICK_STAIRS = register(new Identifier(CONSISTENCY_PLUS_MODID, "concrete_brick_stairs"));
        public static final Tag.Identified<Block> CONCRETE_BRICK_WALLS = register(new Identifier(CONSISTENCY_PLUS_MODID, "concrete_brick_walls"));
        public static final Tag.Identified<Block> CONCRETE_BRICK_GATES = register(new Identifier(CONSISTENCY_PLUS_MODID, "concrete_brick_gates"));

        public static final Tag.Identified<Block> CONCRETE_TILE = register(new Identifier(CONSISTENCY_PLUS_MODID, "concrete_tile"));
        public static final Tag.Identified<Block> CONCRETE_TILE_SLABS = register(new Identifier(CONSISTENCY_PLUS_MODID, "concrete_tile_slabs"));
        public static final Tag.Identified<Block> CONCRETE_TILE_STAIRS = register(new Identifier(CONSISTENCY_PLUS_MODID, "concrete_tile_stairs"));
        public static final Tag.Identified<Block> CONCRETE_TILE_WALLS = register(new Identifier(CONSISTENCY_PLUS_MODID, "concrete_tile_walls"));
        public static final Tag.Identified<Block> CONCRETE_TILE_GATES = register(new Identifier(CONSISTENCY_PLUS_MODID, "concrete_tile_gates"));

        public static final Tag.Identified<Block> CONCRETE_CORNER_PILLAR = register(new Identifier(CONSISTENCY_PLUS_MODID, "concrete_corner_pillar"));
        public static final Tag.Identified<Block> CONCRETE_PILLAR = register(new Identifier(CONSISTENCY_PLUS_MODID, "concrete_pillar"));
        public static final Tag.Identified<Block> CHISELED_CONCRETE = register(new Identifier(CONSISTENCY_PLUS_MODID, "chiseled_concrete"));
        public static final Tag.Identified<Block> CARVED_CONCRETE = register(new Identifier(CONSISTENCY_PLUS_MODID, "carved_concrete"));

        public static final Tag.Identified<Block> ICE = register(new Identifier(CONSISTENCY_PLUS_MODID, "ice"));
        public static final Tag.Identified<Block> ICE_SLABS = register(new Identifier(CONSISTENCY_PLUS_MODID, "ice_slabs"));
        public static final Tag.Identified<Block> ICE_STAIRS = register(new Identifier(CONSISTENCY_PLUS_MODID, "ice_stairs"));
        public static final Tag.Identified<Block> ICE_WALLS = register(new Identifier(CONSISTENCY_PLUS_MODID, "ice_walls"));
        public static final Tag.Identified<Block> ICE_GATES = register(new Identifier(CONSISTENCY_PLUS_MODID, "ice_gates"));

        public static final Tag.Identified<Block> GLOWSTONE = register(new Identifier(CONSISTENCY_PLUS_MODID, "glowstone"));
        public static final Tag.Identified<Block> GLOWSTONE_SLABS = register(new Identifier(CONSISTENCY_PLUS_MODID, "glowstone_slabs"));
        public static final Tag.Identified<Block> GLOWSTONE_STAIRS = register(new Identifier(CONSISTENCY_PLUS_MODID, "glowstone_stairs"));
        public static final Tag.Identified<Block> GLOWSTONE_WALLS = register(new Identifier(CONSISTENCY_PLUS_MODID, "glowstone_walls"));
        public static final Tag.Identified<Block> GLOWSTONE_GATES = register(new Identifier(CONSISTENCY_PLUS_MODID, "glowstone_gates"));

        public static final Tag.Identified<Block> TINTED_GLASS_BLOCK = register(new Identifier(CONSISTENCY_PLUS_MODID, "tinted_glass"));

        private static Tag.Identified<Block> register(Identifier id){
            Tag.Identified<Block> temp = TagFactory.BLOCK.create(id);
            ALL_DYEABLE_BLOCK_TAGS.add(temp);
            return temp;
        }

        private static void init(){}

    }

    public static void init(){
        DyeableBlocks.init();
    }
}
