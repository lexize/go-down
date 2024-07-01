package net.liquidwarpmc.godown.networking;

import net.liquidwarpmc.godown.GoDown;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.listener.ServerPlayPacketListener;
import net.minecraft.network.packet.CustomPayload;
import static net.minecraft.network.packet.CustomPayload.codecOf;
import net.minecraft.network.packet.Packet;

public record GoDownCrawlC2SPacket(boolean crawl) implements CustomPayload {
    public static final CustomPayload.Id<GoDownCrawlC2SPacket> ID = new Id<>(GoDown.GODOWN_IDENTIFIER);
    public static final PacketCodec<RegistryByteBuf, GoDownCrawlC2SPacket> CODEC =
        codecOf();

    public void write(RegistryByteBuf buf)

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
