package Examplemod.examplemod.managers;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import Examplemod.examplemod.packets.ScanPacket;

public final class PacketManager {
    private static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("scanpig");

    public static void load() {
        INSTANCE.registerMessage(ScanPacket.Handler.class, ScanPacket.class, 0, Side.CLIENT);
    }

    public static void sendScanUpdate(boolean b, EntityPlayerMP player) {
        INSTANCE.sendTo(new ScanPacket(b), player);
    }
}