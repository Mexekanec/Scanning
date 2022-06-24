package Examplemod.examplemod.packets;

import Examplemod.examplemod.ExampleMod;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public final class ScanPacket implements IMessage {
    private boolean enable;

    public ScanPacket() {
    }

    public ScanPacket(final boolean enable) {
        this.enable = enable;
    }

    public boolean isEnable() {
        return this.enable;
    }

    @Override
    public void fromBytes(final ByteBuf buf) {
        this.enable = buf.readBoolean();
    }

    @Override
    public void toBytes(final ByteBuf buf) {
        buf.writeBoolean(this.enable);
    }

    public static class Handler implements IMessageHandler<ScanPacket, IMessage> {

        @Override
        public IMessage onMessage(ScanPacket message, MessageContext ctx) {
            if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
                final boolean value = message.isEnable();

                ExampleMod.instance.getClientRender().setEnableScan(value);
            }

            return null;
        }
    }
}