package net.liquidwarpmc.godown;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.client.option.StickyKeyBinding;
import net.minecraft.text.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class GoDownClient implements ClientModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("GoDown");

    public static KeyBinding keyCrawl;
    public static SimpleOption<Boolean> crawlToggled;

    @Override
    public void onInitializeClient() {
        crawlToggled = new SimpleOption<>(
                "key.godown.crawl",
                SimpleOption.emptyTooltip(),
                (optionText, value) -> value ? Text.translatable("options.key.toggle") : Text.translatable("options.key.hold"),
                SimpleOption.BOOLEAN,
                false, (value) -> {}
        );

        keyCrawl = KeyBindingHelper.registerKeyBinding(
                new StickyKeyBinding(
                        "key.godown.crawl",
                        GLFW.GLFW_KEY_Z,
                        "key.categories.movement",
                        crawlToggled::getValue
                )
        );

        LOGGER.info("[Go Down Client] initialized!");
    }
}
