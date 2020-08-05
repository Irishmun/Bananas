package com.afterdark.bananamod.lists;

import com.afterdark.bananamod.CreativeTab;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;

import static com.afterdark.bananamod.CustomProperties.ModFoods.*;
import static com.afterdark.bananamod.util.Reference.MOD_ID;

public class ItemList
{
    public static final ItemGroup BANANA = new CreativeTab();

    public static Item banana = createNewFoodItem(BANANA, "banana", Foods.APPLE);
    public static Item baked_banana = createNewFoodItem(BANANA, "baked_banana",Foods.BAKED_POTATO);
    public static Item banana_bunch = createNewFoodItem(BANANA, "banana_bunch",BANANA_BUNCH);
    public static Item banana_milkshake = createNewFoodItem(BANANA, "banana_milkshake",BANANA_MILKSHAKE);
    public static Item chocolate_covered_banana = createNewFoodItem(BANANA, "chocolate_covered_banana",Foods.BEETROOT_SOUP);

    private static Item createNewItem(ItemGroup group, String name)
    {
        return new Item(new Item.Properties().group(group)).setRegistryName(new ResourceLocation(MOD_ID, name));
    }

    private static Item createNewFoodItem(ItemGroup group, String name, Food foodtype)
    {
        return new Item(new Item.Properties().group(group).food(foodtype)).setRegistryName(new ResourceLocation(MOD_ID, name));
    }
}

