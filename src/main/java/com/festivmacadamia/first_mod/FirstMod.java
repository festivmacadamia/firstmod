package com.festivmacadamia.first_mod;

import com.mojang.logging.LogUtils;
import com.festivmacadamia.first_mod.block.ModBlocks;
import com.festivmacadamia.first_mod.item.ModCreativeModeTabs;
import com.festivmacadamia.first_mod.item.ModItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file

@Mod(FirstMod.MOD_ID)
public class FirstMod {
	
    public static final String MOD_ID = "first_mod";
    
    @SuppressWarnings("unused")
	private static final Logger LOGGER = LogUtils.getLogger();

    
    public FirstMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
    	if(event.getTab()==ModCreativeModeTabs.TUTORIAL_TAB) {
    		event.accept(ModItems.BLACK_OPAL);
    		event.accept(ModItems.RAW_BLACK_OPAL);
    		
    		event.accept(ModBlocks.BLACK_OPAL_BLOCK);
    		event.accept(ModBlocks.BLACK_OPAL_ORE);
    		event.accept(ModBlocks.DEEPSLATE_BLACK_OPAL_ORE);
    		event.accept(ModBlocks.NETHER_BLACK_OPAL_ORE);
    		event.accept(ModBlocks.END_BLACK_OPAL_ORE);
    		
    		event.accept(ModBlocks.EBONY_LOG);
    		event.accept(ModBlocks.EBONY_WOOD);
    		event.accept(ModBlocks.STRIPPED_EBONY_LOG);
    		event.accept(ModBlocks.STRIPPED_EBONY_WOOD);
    		event.accept(ModBlocks.EBONY_PLANKS);
    		event.accept(ModBlocks.EBONY_LEAVES);
    		event.accept(ModBlocks.EBONY_SAPLING);
    	}
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}