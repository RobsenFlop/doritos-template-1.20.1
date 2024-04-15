package net.robin.doritos.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.robin.doritos.ThundyzDoritos;
import net.robin.doritos.block.custom.ChiliCropBlock;
import net.robin.doritos.block.custom.CornCropBlock;
import net.robin.doritos.block.custom.ThundyPlush;

public class ModBlocks {
    public static final Block BLOCK_OF_CHEESE = registerBlock("block_of_cheese",
            new SlimeBlock(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK).mapColor(MapColor.PALE_YELLOW).strength(0.5f)));
    public static final Block SQUARE_DORITO = registerBlock("square_dorito",
            new Block(FabricBlockSettings.copyOf(Blocks.GRAVEL).mapColor(MapColor.TERRACOTTA_ORANGE).strength(0.25f)));
    public static final Block DORITO_DUST_BLOCK = registerBlock("dorito_dust_block",
            new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND).mapColor(MapColor.TERRACOTTA_ORANGE).strength(0.15f)));
    public static final Block THUNDY_PLUSH = registerBlock("thundy_plush",
            new ThundyPlush(FabricBlockSettings.copyOf(Blocks.BLACK_WOOL).mapColor(MapColor.WATER_BLUE).nonOpaque()));
    public static final Block CORN_CROP = Registry.register(Registries.BLOCK, new Identifier(ThundyzDoritos.MOD_ID, "corn_crop"),
            new CornCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static final Block CHILI_CROP = Registry.register(Registries.BLOCK, new Identifier(ThundyzDoritos.MOD_ID, "chili_crop"),
            new ChiliCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    private static String name;

    private static Block registerBlock (String name, Block block) {
        ModBlocks.name = name;
        registerBlockItem(name, block);
        return  Registry.register(Registries.BLOCK, new Identifier(ThundyzDoritos.MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(ThundyzDoritos.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        ThundyzDoritos.LOGGER.info("Registering ModBlocks for " + ThundyzDoritos.MOD_ID);
    }
}
