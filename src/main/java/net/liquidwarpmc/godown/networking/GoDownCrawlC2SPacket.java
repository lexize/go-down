package net.liquidwarpmc.godown.networking;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ServerPlayPacketListener;
import net.minecraft.network.packet.Packet;

public class GoDownCrawlC2SPacket implements Packet<ServerPlayPacketListener> {
    private boolean crawl;
    @Override
    public void write(PacketByteBuf buf) {
        buf.writeBoolean(crawl);
    }

    @Override
    public void apply(ServerPlayPacketListener listener) {

    }
}
