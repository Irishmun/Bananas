package com.afterdark.bananamod.CustomProperties;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

import java.util.function.Supplier;

public class ModFoods
{
    public static final Food BANANA_BUNCH;
    public static final Food BANANA_MILKSHAKE;

    private static final Supplier<EffectInstance> ef = () -> new EffectInstance(Effects.FIRE_RESISTANCE,30);
    static
    {
        BANANA_BUNCH = (new Food.Builder()).hunger(14).saturation(12.8F).build();
        BANANA_MILKSHAKE =(new Food.Builder()).hunger(8).saturation(12.8F).effect(ef,100).build();
    }
}