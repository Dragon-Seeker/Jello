package com.dragon.jello.Util;

import com.dragon.jello.mixin.mixins.LivingEntityMixin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;

import java.util.*;

public class DataConstants {

    public static final TrackedData<Integer> DYE_COLOR = DataTracker.registerData(LivingEntity.class, TrackedDataHandlerRegistry.INTEGER);
    public static final TrackedData<Byte> RAINBOW_MODE = DataTracker.registerData(LivingEntity.class, TrackedDataHandlerRegistry.BYTE);
    public static final TrackedData<Integer> CONSTANT_COLOR = DataTracker.registerData(LivingEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public static final int DEFAULT_NULL_COLOR_VALUE = 16777216;

    private static final List<String> NBT_CONSTANTS = new ArrayList<>(Arrays.asList("EntityColor", "RainbowMode", "ConstantColor"));

    public static String getDyeColorNbtKey(){
        return NBT_CONSTANTS.get(0);
    }

    public static String getRainbowNbtKey(){
        return NBT_CONSTANTS.get(1);
    }

    public static String getConstantColorNbtKey(){
        return NBT_CONSTANTS.get(2);
    }

}
