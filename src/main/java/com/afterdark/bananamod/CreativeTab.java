package com.afterdark.bananamod;

import com.afterdark.bananamod.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CreativeTab extends ItemGroup
{
    public CreativeTab()
    {
        super("banana_mod");
    }

    @Override
    public ItemStack createIcon()
    {
        return new ItemStack(ItemList.banana_bunch);
    }
}
