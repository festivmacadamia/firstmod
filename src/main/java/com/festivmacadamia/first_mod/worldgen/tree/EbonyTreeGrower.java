package com.festivmacadamia.first_mod.worldgen.tree;

import org.jetbrains.annotations.Nullable;

import com.festivmacadamia.first_mod.worldgen.ModConfiguredFeatures;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class EbonyTreeGrower extends AbstractTreeGrower{
	@Nullable
	@Override
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222910_, boolean p_222911_) {

		return ModConfiguredFeatures.EBONY_KEY;
	}
	
}
