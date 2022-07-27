package net.liquidwarpmc.godown;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class GoDownClient implements ClientModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("GoDown");

    public static KeyBinding keyCrawl;

    @Override
    public void onInitializeClient() {
        keyCrawl = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "key.godown.crawl",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_Z,
                        "key.categories.movement"
                )
        );

        LOGGER.info("[Go Down Client] initialized!");
    }
}
