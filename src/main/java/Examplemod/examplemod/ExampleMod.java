package Examplemod.examplemod;


import Examplemod.examplemod.client.ClientRender;
import Examplemod.examplemod.managers.PacketManager;
import Examplemod.examplemod.server.handlers.TickHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;


import java.util.Arrays;

@Mod.EventBusSubscriber
@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION, name = ExampleMod.NAME)
public final class ExampleMod {
    public static final String MODID="examplemod";
    public static final String NAME="Example Mod";
    public static final String VERSION="1.0";

    private final ClientRender clientRender = new ClientRender();
    private final TickHandler tickHandler = new TickHandler();


    public ClientRender getClientRender() {
        return this.clientRender;
    }

    @Mod.Instance
    public static ExampleMod instance;

    @Mod.EventHandler
    public void preInit() {
        MinecraftForge.EVENT_BUS.register(this.clientRender);
        MinecraftForge.EVENT_BUS.register(this.tickHandler);
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        // NO-OP
    }

    @Mod.EventHandler
    public void init() {
        PacketManager.load();
    }
}
