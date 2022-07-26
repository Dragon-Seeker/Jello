package io.wispforest.jello.misc.dye;

import io.wispforest.jello.misc.JelloConstants;
import io.wispforest.owo.registration.reflect.SimpleFieldProcessingSubject;
import net.minecraft.stat.StatFormatter;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.lang.reflect.Field;

public class JelloStats implements SimpleFieldProcessingSubject<Identifier> {

    public static final Identifier CLEAN_BLOCK = JelloConstants.id("clean_block");

    public static final Identifier DYE_BLOCK = JelloConstants.id("dye_block");
    public static final Identifier DYE_ARMOR = JelloConstants.id("dye_armor");
    //public static final Identifier DYE_BANNER = Jello.id("dye_banner");
    public static final Identifier DYE_SHULKER_BOX = JelloConstants.id("dye_shulker_box");

    @Override
    public void processField(Identifier value, String identifier, Field field) {
        Registry.register(Registry.CUSTOM_STAT, identifier, value);
        net.minecraft.stat.Stats.CUSTOM.getOrCreateStat(value, StatFormatter.DEFAULT);
    }

    @Override
    public Class<Identifier> getTargetFieldType() {
        return Identifier.class;
    }
}
