package net.robin.doritos.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.robin.doritos.ThundyzDoritos;
import net.robin.doritos.block.ModBlocks;
import net.robin.doritos.item.ModItems;

public class ModItemGroups {
    public static final ItemGroup DORITOS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ThundyzDoritos.MOD_ID, "dorito"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.thundyzdoritos"))
                    .icon(() -> new ItemStack(ModItems.DORITOS)).entries((displayContext, entries) -> {
                        entries.add(ModItems.DORITOS);
                        entries.add(ModItems.FLAMING_HOT_DORITOS);
                        entries.add(ModItems.SWEET_CHILI_DORITOS);
                        entries.add(ModItems.LAYS);
                        entries.add(ModItems.EMPTY_CAN);
                        entries.add(ModItems.RED_BULL);
                        entries.add(ModItems.MOUNTAIN_DEW);
                        entries.add(ModItems.CHEESE);
                        entries.add(ModBlocks.BLOCK_OF_CHEESE);
                        entries.add(ModBlocks.SQUARE_DORITO);
                        entries.add(ModBlocks.DORITO_DUST_BLOCK);
                        entries.add(ModItems.CORN_SEEDS);
                        entries.add(ModItems.CORN);
                        entries.add(ModItems.CORN_ON_THE_COB);
                        entries.add(ModItems.CHILI_SEEDS);
                        entries.add(ModItems.CHILI);
                        entries.add(ModItems.DORITO_HELMET);
                        entries.add(ModItems.DORITO_KING_HELMET);
                        entries.add(ModItems.CHANEL_BAG_MUSIC_DISC);
                        entries.add(ModBlocks.THUNDY_PLUSH);



                    }).build());
    public static void registerItemGroups() {
        ThundyzDoritos.LOGGER.info("Registering Item Groups for " + ThundyzDoritos.MOD_ID);
    }
}
