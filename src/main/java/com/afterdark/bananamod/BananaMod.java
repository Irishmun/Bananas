package com.afterdark.bananamod;

import com.afterdark.bananamod.lists.ItemList;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("bananamod")
public class BananaMod
{

    public static BananaMod instance;
    public static final String MOD_ID ="bananamod";
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
        public static void registerItems(final RegistryEvent.Register<Item> e)
        {
            logger.info("Item Registration Started");
            e.getRegistry().registerAll(
                    ItemList.banana,
                    ItemList.baked_banana,
                    ItemList.banana_bunch,
                    ItemList.banana_milkshake,
                    ItemList.chocolate_covered_banana
            );
            logger.info("Items registered");
        }
    }
}
