package com.integral.examplemod;



import com.integral.examplemod.client.ClientRender;
import com.integral.examplemod.events.TickHandler;
import com.integral.examplemod.gui.energy;
import com.integral.examplemod.managers.PacketManager;
import com.integral.examplemod.packets.ScanPacket;
import com.integral.examplemod.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;


@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION, name = ExampleMod.NAME)
public class ExampleMod {
    public static final String MODID="examplemod";
    public static final String NAME="The Example Mod";
    public static final String VERSION="1.0.0";

    private final ClientRender clientRender = new ClientRender();

@SidedProxy(clientSide = "com.integral.examplemod.proxy.ClientProxy", serverSide = "com.integral.examplemod.proxy.CommonProxy")
public static CommonProxy proxy;

@Mod.Instance
public static ExampleMod instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        PacketManager.load();
    }


    public ClientRender getClientRender() {
        return this.clientRender;
    }


    @EventHandler
    public void init(FMLInitializationEvent event) {
        PacketManager.load();
   proxy.init(event);
    }


    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    proxy.postInit(event);
        MinecraftForge.EVENT_BUS.register(new energy());

    }


    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        // NO-OP
    }
}
