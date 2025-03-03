package ladysnake.blast.common.init;

import ladysnake.blast.common.entity.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;

import static ladysnake.blast.common.Blast.MODID;

public class BlastEntities {

    public static EntityType<BombEntity> BOMB;
    public static EntityType<BombEntity> GOLDEN_BOMB;
    public static EntityType<BombEntity> DIAMOND_BOMB;
    public static EntityType<BombEntity> NAVAL_MINE;
    public static EntityType<BombEntity> TRIGGER_BOMB;
    public static EntityType<BombEntity> GOLDEN_TRIGGER_BOMB;
    public static EntityType<BombEntity> DIAMOND_TRIGGER_BOMB;

    public static EntityType<GunpowderBlockEntity> GUNPOWDER_BLOCK;
    public static EntityType<StripminerEntity> STRIPMINER;
    public static EntityType<ColdDiggerEntity> COLD_DIGGER;

    public static void init() {
        // throwable explosives
        BOMB = register("bomb", createBombEntityType(BombEntity::new));
        GOLDEN_BOMB = register("golden_bomb", createBombEntityType(GoldenBombEntity::new));
        DIAMOND_BOMB = register("diamond_bomb", createBombEntityType(DiamondBombEntity::new));
        NAVAL_MINE = register("naval_mine", createBombEntityType(NavalMineEntity::new));
        TRIGGER_BOMB = register("trigger_bomb", createBombEntityType(TriggerBombEntity::new));
        GOLDEN_TRIGGER_BOMB = register("golden_trigger_bomb", createBombEntityType(GoldenTriggerBombEntity::new));
        DIAMOND_TRIGGER_BOMB = register("diamond_trigger_bomb", createBombEntityType(DiamondTriggerBombEntity::new));

        // explosive blocks
        GUNPOWDER_BLOCK = register("gunpowder_block", FabricEntityTypeBuilder.<GunpowderBlockEntity>create(SpawnGroup.MISC, GunpowderBlockEntity::new).dimensions(EntityDimensions.changing(1f, 1f)).trackRangeBlocks(64).trackedUpdateRate(1).forceTrackedVelocityUpdates(true).build());
        STRIPMINER = register("stripminer", FabricEntityTypeBuilder.create(SpawnGroup.MISC, StripminerEntity::new).dimensions(EntityDimensions.changing(1f, 1f)).trackRangeBlocks(64).trackedUpdateRate(1).forceTrackedVelocityUpdates(true).build());
        COLD_DIGGER = register("cold_digger", FabricEntityTypeBuilder.create(SpawnGroup.MISC, ColdDiggerEntity::new).dimensions(EntityDimensions.changing(1f, 1f)).trackRangeBlocks(64).trackedUpdateRate(1).forceTrackedVelocityUpdates(true).build());
    }

    private static <T extends BombEntity> EntityType<T> register(String s, EntityType<T> bombEntityType) {
        return Registry.register(Registry.ENTITY_TYPE, MODID + ":" + s, bombEntityType);
    }

    private static <T extends BombEntity> EntityType<T> createBombEntityType(EntityType.EntityFactory<T> factory) {
        return FabricEntityTypeBuilder.create(SpawnGroup.MISC, factory).dimensions(EntityDimensions.changing(0.25f, 0.25f)).trackRangeBlocks(64).trackedUpdateRate(1).forceTrackedVelocityUpdates(true).build();
    }
}