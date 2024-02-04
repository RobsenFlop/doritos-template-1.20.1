package net.robin.doritos;

import net.fabricmc.api.ModInitializer;

import net.robin.doritos.block.ModBlocks;
import net.robin.doritos.item.ModItemGroups;
import net.robin.doritos.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThundyzDoritos implements ModInitializer {
		public static final String MOD_ID = "thundyzdoritos";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}