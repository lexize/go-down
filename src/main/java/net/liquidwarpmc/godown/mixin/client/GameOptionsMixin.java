package net.liquidwarpmc.godown.mixin.client;

import net.liquidwarpmc.godown.GoDownClient;
import net.minecraft.client.option.GameOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameOptions.class)
public class GameOptionsMixin {

    @Inject(at = @At("HEAD"), method = "accept")
    private void accept(GameOptions.Visitor visitor, CallbackInfo ci) {
        visitor.accept("toggleCrawl", GoDownClient.crawlToggled);
    }
}
