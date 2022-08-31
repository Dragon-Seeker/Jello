package io.wispforest.dye_entities.ducks;

import net.minecraft.util.Identifier;

public interface TextureManagerDuck {

    void createGrayScaledTexture(Identifier grayScaledId, Identifier defaultId);

    boolean hasGrayScaledTextureBeenMade(Identifier identifier);

}
