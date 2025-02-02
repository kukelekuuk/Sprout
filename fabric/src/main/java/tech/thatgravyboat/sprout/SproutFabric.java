package tech.thatgravyboat.sprout;

import tech.thatgravyboat.sprout.common.config.fabric.ConfigLoaderImpl;
import tech.thatgravyboat.sprout.common.entities.BounceBugEntity;
import tech.thatgravyboat.sprout.common.entities.ElephantEntity;
import tech.thatgravyboat.sprout.common.registry.SproutConfiguredFeatures;
import tech.thatgravyboat.sprout.common.registry.SproutEntities;
import tech.thatgravyboat.sprout.common.registry.SproutItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

import java.io.IOException;

public class SproutFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Sprout.init();

        try {
            ConfigLoaderImpl.initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }

        SproutEntities.addSpawns();
        SproutConfiguredFeatures.registerFeatures();
        FabricDefaultAttributeRegistry.register(SproutEntities.ELEPHANT_ENTITY_TYPE.get(), ElephantEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(SproutEntities.BOUNCE_BUG_ENTITY.get(), BounceBugEntity.createMobAttributes());
        SproutItems.onComplete();
    }
}
