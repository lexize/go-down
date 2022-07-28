package net.liquidwarpmc.godown.mixin.client;

import com.google.common.collect.Lists;
import net.liquidwarpmc.godown.GoDownClient;
import net.minecraft.client.gui.screen.option.AccessibilityOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(AccessibilityOptionsScreen.class)
public class AccessibilityOptionsScreenMixin {

    @Inject(at = @At("RETURN"), method = "getOptions", cancellable = true)
    private static void getOptions(GameOptions gameOptions, CallbackInfoReturnable<SimpleOption<?>[]> cir) {
        List<SimpleOption<?>> options = Lists.newArrayList(cir.getReturnValue());
        options.add(GoDownClient.crawlToggled);
        cir.setReturnValue(options.toArray(new SimpleOption[0]));
    }
}
