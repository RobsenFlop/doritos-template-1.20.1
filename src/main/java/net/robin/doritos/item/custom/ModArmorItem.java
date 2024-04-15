package net.robin.doritos.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.robin.doritos.item.ModArmorMaterials;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {

    private static final Map<ArmorMaterial, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, List<StatusEffectInstance>>())
                    .put(ModArmorMaterials.DORITOS, Collections.singletonList(
                            new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 20, 0, false, false, true)))
                    .put(ModArmorMaterials.KING_DORITOS, Arrays.asList(
                            new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 20, 1, false, false, true),
                            new StatusEffectInstance(StatusEffects.LUCK, 20, 1, false, false, true)))
                    .build();


    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                // Check if the player has the helmet equipped
                if (player.getInventory().getArmorStack(3).getItem() == this) {
                    evaluateArmorEffects(player);
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, List<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();

            if (mapArmorMaterial == this.getMaterial()) {
                for (StatusEffectInstance mapStatusEffect : mapStatusEffects) {
                    addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
                }
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.getEffectType());

        if(hasPlayerEffect)
            return; // Skip if the player already has the effect

        player.addStatusEffect(new StatusEffectInstance(mapStatusEffect));
    }
}

