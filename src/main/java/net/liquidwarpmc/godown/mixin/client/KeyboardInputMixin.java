package net.liquidwarpmc.godown.mixin.client;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.liquidwarpmc.godown.GoDown;
import net.liquidwarpmc.godown.GoDownClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.Input;
import net.minecraft.client.input.KeyboardInput;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyboardInput.class)
public class KeyboardInputMixin extends Input {

    @Inject(method = "tick", at = @At("HEAD"))
    void onTickBegin(CallbackInfo ci) {
        PlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null)
            return;

        boolean wannaCrawl = GoDownClient.keyCrawl.isPressed();
        boolean isCrawling = player.getPose() == EntityPose.SWIMMING;

        if (wannaCrawl != isCrawling) {
            ClientPlayNetworking.send(GoDown.GODOWN_IDENTIFIER, new PacketByteBuf(Unpooled.wrappedBuffer(new byte[] {
                    (byte) (wannaCrawl ? 1 : 0)
            })));
            player.getDataTracker().set(GoDown.Shared.CRAWLING_REQUEST, wannaCrawl);
        }
    }
}
