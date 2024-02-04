package net.robin.doritos.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent DORITOS = new FoodComponent.Builder().hunger(6).saturationModifier(1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20, 1),100).build();
    public static final FoodComponent SWEET_CHILI_DORITOS = new FoodComponent.Builder().hunger(6).saturationModifier(1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600, 0),100).build();
    public static final FoodComponent FLAMING_HOT_DORITOS = new FoodComponent.Builder().hunger(6).saturationModifier(1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 600, 1),100)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 600, 1),100).build();
    public static final FoodComponent CHEESE = new FoodComponent.Builder().hunger(4).saturationModifier(0.5f).build();
    public static final FoodComponent CORN = new FoodComponent.Builder().hunger(2).saturationModifier(0.25f).build();
    public static final FoodComponent CHILI = new FoodComponent.Builder().hunger(2).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 200, 0),100)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200, 0),100).build();
    public static final FoodComponent CORN_ON_THE_COB = new FoodComponent.Builder().hunger(5).saturationModifier(0.5f).build();
    public static final FoodComponent MOUNTAIN_DEW = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 300, 2), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300, 0), 1.0F)
            .alwaysEdible().build();
    public static final FoodComponent RED_BULL = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 100, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 300, 1), 1.0F)
            .alwaysEdible().build();
    public static final FoodComponent LAYS = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 1), 1.0F)
            .alwaysEdible().build();


}
