package com.festivmacadamia.first_mod.datagen;

import java.util.Set;

import com.festivmacadamia.first_mod.block.ModBlocks;
import com.festivmacadamia.first_mod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLootSubProvider{
	
	
	protected ModBlockLootTables() {
		super(Set.of(),FeatureFlags.REGISTRY.allFlags());

	}

	@Override
	protected void generate() {
		dropSelf(ModBlocks.BLACK_OPAL_BLOCK.get());
		
		add(ModBlocks.BLACK_OPAL_ORE.get(),
			(block) -> createOreDrop(ModBlocks.BLACK_OPAL_ORE.get(),ModItems.RAW_BLACK_OPAL.get()));
		add(ModBlocks.DEEPSLATE_BLACK_OPAL_ORE.get(),
				(block) -> createOreDrop(ModBlocks.DEEPSLATE_BLACK_OPAL_ORE.get(),ModItems.RAW_BLACK_OPAL.get()));
		add(ModBlocks.NETHER_BLACK_OPAL_ORE.get(),
				(block) -> createOreDrop(ModBlocks.NETHER_BLACK_OPAL_ORE.get(),ModItems.RAW_BLACK_OPAL.get()));
		add(ModBlocks.END_BLACK_OPAL_ORE.get(),
				(block) -> createOreDrop(ModBlocks.END_BLACK_OPAL_ORE.get(),ModItems.RAW_BLACK_OPAL.get()));
		
		
		this.dropSelf(ModBlocks.EBONY_LOG.get());
		this.dropSelf(ModBlocks.EBONY_WOOD.get());
		this.dropSelf(ModBlocks.STRIPPED_EBONY_LOG.get());
		this.dropSelf(ModBlocks.STRIPPED_EBONY_WOOD.get());
		this.dropSelf(ModBlocks.EBONY_PLANKS.get());
		this.dropSelf(ModBlocks.EBONY_SAPLING.get());
		
		this.add(ModBlocks.EBONY_LEAVES.get(),(block) ->
			createLeavesDrops(block, ModBlocks.EBONY_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));
	}
	
	@Override
	protected Iterable<Block> getKnownBlocks(){
		return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
}
