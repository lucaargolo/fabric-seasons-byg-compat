package io.github.lucaargolo.seasonsbygcompat.mixin;

import io.github.lucaargolo.seasons.utils.FertilizableUtil;
import io.github.lucaargolo.seasons.utils.SeasonalFertilizable;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = {
        "potionstudios.byg.common.block.AppleFruitBlock",
        "potionstudios.byg.common.block.JoshuaFruitBlock",
        "potionstudios.byg.common.block.GreenAppleFruitBlock",
        "potionstudios.byg.common.block.BaobabFruitBlock",
        "potionstudios.byg.common.block.AloeVeraBlock",
        "potionstudios.byg.common.block.HangingFruitLeavesBlock",
        "potionstudios.byg.common.block.CattailSproutBlock",
        "potionstudios.byg.common.block.EtherBulbsBlock",
        "potionstudios.byg.common.block.WhitePuffballBlock",
})
public abstract class BYGFertilizablesMixin extends Block implements Fertilizable, SeasonalFertilizable {

    public BYGFertilizablesMixin(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("HEAD"), method = "randomTick", cancellable = true)
    public void randomTickInject(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        FertilizableUtil.randomTickInject(this, state, world, pos, random, ci);
    }

    @Inject(at = @At("HEAD"), method = "grow", cancellable = true)
    public void growInject(ServerWorld world, Random random, BlockPos pos, BlockState state, CallbackInfo ci) {
        FertilizableUtil.growInject(this, world, random, pos, state, ci);
    }

}
