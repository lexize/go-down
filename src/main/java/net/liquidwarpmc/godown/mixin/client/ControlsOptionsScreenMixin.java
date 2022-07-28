package net.liquidwarpmc.godown.mixin.client;

import net.liquidwarpmc.godown.GoDownClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.ControlsOptionsScreen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ControlsOptionsScreen.class)
public class ControlsOptionsScreenMixin extends GameOptionsScreen {

    public ControlsOptionsScreenMixin(Screen parent, GameOptions gameOptions, Text title) {
        super(parent, gameOptions, title);
    }

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/GameOptions;getAutoJump()Lnet/minecraft/client/option/SimpleOption;", shift = At.Shift.AFTER), method = "init", locals = LocalCapture.CAPTURE_FAILSOFT)
    private void init(CallbackInfo ci, int i, int j, int k) {
        this.addDrawableChild(GoDownClient.crawlToggled.createButton(this.gameOptions, j, k, 150));
    }
}
