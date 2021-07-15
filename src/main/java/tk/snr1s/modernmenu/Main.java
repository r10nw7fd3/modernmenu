package tk.snr1s.modernmenu;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION, clientSideOnly = true)
public class Main {
    public static final String MODID = "modernmenu";
    public static final String NAME = "Modern Menu";
    public static final String VERSION = "1.0.0";
    public static final SoundEvent SOUND_CLICKHOVER = new SoundEvent(new ResourceLocation(MODID, "mm_hoverclick"));

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) { logger = e.getModLog(); }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        logger.debug("Registering handler...");
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
}
