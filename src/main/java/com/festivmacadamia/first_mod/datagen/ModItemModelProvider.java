package com.festivmacadamia.first_mod.datagen;

import com.festivmacadamia.first_mod.FirstMod;
import com.festivmacadamia.first_mod.item.ModItems;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider{
	
	
	public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, FirstMod.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		simpleItem(ModItems.BLACK_OPAL);
		simpleItem(ModItems.RAW_BLACK_OPAL);
	}
	
	private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(FirstMod.MOD_ID, "item/" + item.getId().getPath()));
	}
	@SuppressWarnings("unused")
	private ItemModelBuilder handhelpItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/handheld")).texture("layer0",
				new ResourceLocation(FirstMod.MOD_ID,"item/"+item.getId().getPath()));
	}
}
