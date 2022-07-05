package Examplemod.examplemod.client;

import net.minecraft.entity.passive.EntityPig;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public final class ClientRender {
    private boolean enableScan;

    @SubscribeEvent
    public void onEntityRenderPre(final RenderLivingEvent.Pre event) {
        if (this.enableScan) {
            Entity entity=event.getEntity();
            if (entity instanceof EntityPig)
                GL11.glDisable(GL11.GL_DEPTH_TEST);
        }
    }

    @SubscribeEvent
    public void onEntityRenderPost(final RenderLivingEvent.Post event) {
        if (this.enableScan) {
            Entity entity=event.getEntity();
            if (entity instanceof EntityPig)
                GL11.glEnable(GL11.GL_DEPTH_TEST);
        }
    }
    public void setEnableScan(final boolean value) {
        this.enableScan = value;
    }
}
