package io.wispforest.jello.data;

import io.wispforest.jello.client.data.JelloBlockStateProvider;
import io.wispforest.jello.data.providers.JelloBlockLootTable;
import io.wispforest.jello.data.providers.JelloLangProvider;
import io.wispforest.jello.data.providers.JelloRecipeProvider;
import io.wispforest.jello.data.providers.JelloTagsProvider;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.loader.api.FabricLoader;

public class JelloDataEntrypoint implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(new JelloTagsProvider.BlockTagProvider(fabricDataGenerator));
        fabricDataGenerator.addProvider(new JelloTagsProvider.ItemTagProvider(fabricDataGenerator));

        fabricDataGenerator.addProvider(new JelloRecipeProvider(fabricDataGenerator));

        fabricDataGenerator.addProvider(new JelloLangProvider(fabricDataGenerator));

        fabricDataGenerator.addProvider(new JelloBlockLootTable(fabricDataGenerator));

        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            fabricDataGenerator.addProvider(new JelloBlockStateProvider(fabricDataGenerator));
        }
    }
}
