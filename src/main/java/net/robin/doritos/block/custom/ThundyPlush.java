package net.robin.doritos.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.robin.doritos.item.ModItems;
import net.robin.doritos.sounds.ModSounds;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.stream.Stream;

import static net.minecraft.util.function.BooleanBiFunction.*;

public class ThundyPlush extends Block {
    private static final VoxelShape SHAPE = Block.createCuboidShape(4,0,4,12,12,12);
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public ThundyPlush(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public int getOpacity(BlockState state, BlockView world, BlockPos pos) {
        return super.getOpacity(state, world, pos);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(1000) == 0) {
            world.playSound((double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, ModSounds.THUNDY_PLUSH, SoundCategory.BLOCKS, 10F, 1F, true);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getStackInHand(hand);
        Item itemInHand = heldItem.getItem();

        // Check if the player is holding a specific item (for example, a potato)
        if (itemInHand == ModItems.DORITOS) {
            // Check if the player is in creative mode
            if (!player.isCreative()) {
                // Remove one dorito from the player's hand
                heldItem.decrement(1);
            }

            // Play the sound effects
            world.playSound((double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.BLOCKS, 0.5F, 1F, false);
            world.playSound((double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.BLOCKS, 0.5F, 1F, false);
            world.playSound((double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, SoundEvents.ENTITY_VILLAGER_YES, SoundCategory.BLOCKS, 0.5F, 1F, false);

            // Display a particle at the location of the block
            world.addParticle(ParticleTypes.HEART, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 0, 0);

            return ActionResult.SUCCESS;
        } else {
            // Return without playing the sound if the player is not holding a potato
            world.playSound((double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.BLOCKS, 0.5F, 1F, false);
            world.playSound((double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.BLOCKS, 0.5F, 1F, false);
            world.playSound((double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, SoundEvents.ENTITY_PILLAGER_AMBIENT, SoundCategory.BLOCKS, 0.5F, 1F, false);

            world.addParticle(ParticleTypes.ANGRY_VILLAGER, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 0, 0);
            return ActionResult.SUCCESS;
        }
    }
}
