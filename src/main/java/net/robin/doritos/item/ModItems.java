package net.robin.doritos.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.robin.doritos.ThundyzDoritos;
import net.robin.doritos.block.ModBlocks;
import net.robin.doritos.sounds.ModSounds;

import static net.robin.doritos.block.ModBlocks.*;

public class ModItems {
    public static final Item DORITOS = registerItem("doritos",
            new Item(new FabricItemSettings().food(ModFoodComponents.DORITOS)));
    public static final Item SWEET_CHILI_DORITOS = registerItem("sweet_chili_doritos",
            new Item(new FabricItemSettings().food(ModFoodComponents.SWEET_CHILI_DORITOS)));
    public static final Item FLAMING_HOT_DORITOS = registerItem("flaming_hot_doritos",
            new Item(new FabricItemSettings().food(ModFoodComponents.FLAMING_HOT_DORITOS).fireproof()));
    public static final Item LAYS = registerItem("lays",
            new LaysItem(new FabricItemSettings().food(ModFoodComponents.LAYS)));
    public static final Item CHEESE = registerItem("cheese",
            new Item(new FabricItemSettings().food(ModFoodComponents.CHEESE)));
    public static final Item CORN_SEEDS = registerItem("corn_seeds",
            new AliasedBlockItem(ModBlocks.CORN_CROP, new FabricItemSettings()));
    public static final Item CHILI_SEEDS = registerItem("chili_seeds",
            new AliasedBlockItem(ModBlocks.CHILI_CROP, new FabricItemSettings()));
    public static final Item CORN = registerItem("corn",
            new Item(new FabricItemSettings().food(ModFoodComponents.CORN)));
    public static final Item CHILI = registerItem("chili",
            new Item(new FabricItemSettings().food(ModFoodComponents.CHILI)));
    public static final Item CORN_ON_THE_COB = registerItem("corn_on_the_cob",
            new Item(new FabricItemSettings().food(ModFoodComponents.CORN_ON_THE_COB)));



    public static final Item EMPTY_CAN = registerItem("empty_can",
            new Item(new FabricItemSettings()));
    public static final Item MOUNTAIN_DEW = registerItem("mountain_dew",
            new DrinkItem((new FabricItemSettings()).food(ModFoodComponents.MOUNTAIN_DEW)));
    public static final Item RED_BULL = registerItem("red_bull",
            new DrinkItem((new FabricItemSettings()).food(ModFoodComponents.RED_BULL)));



    public static final Item CHANEL_BAG_MUSIC_DISC = registerItem("chanel_bag_music_disc",
    new MusicDiscItem(7, ModSounds.CHANEL_BAG, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE),160));



    public static final Item DORITO_HELMET = registerItem("dorito_helmet",
            new ArmorItem(ModArmorMaterials.DORITOS, ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.EPIC)));




    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(EMPTY_CAN);
    }
    private static void addItemsToFoodItemGroup(FabricItemGroupEntries entries) {
        entries.add(DORITOS);
        entries.add(FLAMING_HOT_DORITOS);
        entries.add(SWEET_CHILI_DORITOS);
        entries.add(LAYS);
        entries.add(MOUNTAIN_DEW);
        entries.add(RED_BULL);
        entries.add(CORN);
        entries.add(CHILI);
        entries.add(CORN_ON_THE_COB);
        entries.add(CHEESE);
    }
    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries) {
        entries.add(CHANEL_BAG_MUSIC_DISC);
    }
    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(DORITO_HELMET);
    }
    private static void addItemsToNaturalItemGroup(FabricItemGroupEntries entries) {
        entries.add(CORN_SEEDS);
        entries.add(CHILI_SEEDS);
    }
    private static void addItemsToBuildingItemGroup(FabricItemGroupEntries entries) {
        entries.add(BLOCK_OF_CHEESE);
        entries.add(SQUARE_DORITO);
        entries.add(DORITO_DUST_BLOCK);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ThundyzDoritos.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ThundyzDoritos.LOGGER.info("Registering Mod Items for " + ThundyzDoritos.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemsToNaturalItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItems::addItemsToBuildingItemGroup);
    }
}
