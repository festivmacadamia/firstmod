package com.festivmacadamia.first_mod.item;

import com.festivmacadamia.first_mod.FirstMod;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = FirstMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
	public static CreativeModeTab TUTORIAL_TAB;
	
	@SubscribeEvent
	public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
		TUTORIAL_TAB = event.registerCreativeModeTab(new ResourceLocation(FirstMod.MOD_ID, "tutorial_tab"),
				builder -> builder.icon(() -> new ItemStack(ModItems.BLACK_OPAL.get()))
				.title(Component.translatable("creativemodetab.first_tab")));
	}
}
