package net.liquidwarpmc.godown.mixin.client;

import net.minecraft.client.option.SimpleOption;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(targets = "net.minecraft.client.option.GameOptions$Visitor")
public interface GameOptionsVisitorInvoker {

    @Invoker("accept")
    <T> void acceptOption(String key, SimpleOption<T> option);
}
