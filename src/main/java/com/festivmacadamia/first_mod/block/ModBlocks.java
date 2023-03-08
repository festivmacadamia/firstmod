package com.festivmacadamia.first_mod.block;

import java.util.function.Supplier;

import com.festivmacadamia.first_mod.FirstMod;
import com.festivmacadamia.first_mod.block.custom.ModFlammableRotatedPillarBlock;
import com.festivmacadamia.first_mod.item.ModItems;
import com.festivmacadamia.first_mod.worldgen.tree.EbonyTreeGrower;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = 
			DeferredRegister.create(ForgeRegistries.BLOCKS, FirstMod.MOD_ID);
	
	/*Black Opal*/
		public static final RegistryObject<Block> BLACK_OPAL_BLOCK = registerBlock("black_opal_block",
				() -> new Block(BlockBehaviour.Properties.of(Material.METAL)
						.strength(3.0F,3.0F).requiresCorrectToolForDrops()));
		
		public static final RegistryObject<Block> BLACK_OPAL_ORE = registerBlock("black_opal_ore",
				() -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
						.strength(2.0F,2.0F).requiresCorrectToolForDrops(),UniformInt.of(2,5)));
		public static final RegistryObject<Block> DEEPSLATE_BLACK_OPAL_ORE = registerBlock("deepslate_black_opal_ore",
				() -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
						.strength(4.0F).requiresCorrectToolForDrops(),UniformInt.of(2,5)));
		public static final RegistryObject<Block> NETHER_BLACK_OPAL_ORE = registerBlock("nether_black_opal_ore",
				() -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
						.strength(1.5F,1.5F).requiresCorrectToolForDrops(),UniformInt.of(2,5)));
		public static final RegistryObject<Block> END_BLACK_OPAL_ORE = registerBlock("end_black_opal_ore",
				() -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
						.strength(4.5F,4.5F).requiresCorrectToolForDrops(),UniformInt.of(2,5)));
	
	/*Tree*/
		public static final RegistryObject<Block> EBONY_LOG = registerBlock("ebony_log",
				() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
						.strength(2F,2F)));
		public static final RegistryObject<Block> EBONY_WOOD = registerBlock("ebony_wood",
				() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
						.strength(2F,2F)));
		
		public static final RegistryObject<Block> STRIPPED_EBONY_LOG = registerBlock("stripped_ebony_log",
				() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
						.strength(2F,2F)));
		public static final RegistryObject<Block> STRIPPED_EBONY_WOOD = registerBlock("stripped_ebony_wood",
				() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
						.strength(2F,2F)));
		
		public static final RegistryObject<Block> EBONY_PLANKS = registerBlock("ebony_planks",
				() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
						.strength(2F,3F)) {
					@Override
					public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
						return true;
					}
					@Override
					public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
						return 5;
					}
					@Override
					public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
						return 20;
					}
				});
		
		public static final RegistryObject<Block> EBONY_LEAVES = registerBlock("ebony_leaves",
				() -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
						.strength(0.2F,0.2F)) {
					@Override
					public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
						return true;
					}
					@Override
					public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
						return 30;
					}
					@Override
					public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
						return 60;
					}
				});
		
		public static final RegistryObject<Block> EBONY_SAPLING = registerBlock("ebony_sapling",
				() -> new SaplingBlock(new EbonyTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	
	
	
	
	
	
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}
	public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
		return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
				new Item.Properties()));
	}
	public static void register(IEventBus eventbus) {
		BLOCKS.register(eventbus);
	}
}
