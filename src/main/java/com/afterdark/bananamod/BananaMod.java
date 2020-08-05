package com.afterdark.bananamod;

import com.afterdark.bananamod.lists.ItemList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.annotation.Resource;

import static com.afterdark.bananamod.util.Reference.*;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MOD_ID)
public class BananaMod
{
    public static BananaMod instance;
    private static Logger logger = LogManager.getLogger(MOD_ID);

    public BananaMod()
    {
        instance = this;
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent e)
    {
        logger.info("setup method registered");
    }

    private void clientRegistries(final FMLClientSetupEvent e)
    {
        logger.info("client registries method registered");
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void RegisterItems(final RegistryEvent.Register<Item> e)
        {
            ItemList.banana = CreateNewItem(ItemGroup.FOOD, "banana");

            logger.info("Items registered");
        }

        private static Item CreateNewItem(ItemGroup group, String name)
        {
            return new Item(new Item.Properties().group(group)).setRegistryName(new ResourceLocation(MOD_ID, name));
        }
    }
}
