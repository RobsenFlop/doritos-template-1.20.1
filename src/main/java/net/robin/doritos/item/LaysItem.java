package net.robin.doritos.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.UseAction;
import net.robin.doritos.sounds.ModSounds;

public class LaysItem extends Item {

    public LaysItem(Settings settings) {
        super(settings);
    }
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT;
    }
    @Override
    public SoundEvent getDrinkSound() {
        return ModSounds.LAYS_EAT;
    }
    @Override
    public SoundEvent getEatSound() {
        return ModSounds.LAYS_EAT;
    }
}
