package tk.snr1s.modernmenu;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tk.snr1s.modernmenu.gui.GuiFakeMainMenu;

public class EventHandler  {
    public static boolean replaceGui = true;

    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent e) {
        if ((e.getGui() instanceof GuiMainMenu) && replaceGui) {
            replaceGui = true;
            Main.logger.debug("Opening modern gui...");
            e.setGui(new GuiFakeMainMenu());
        }
    }

    @SubscribeEvent
    public void onRegister(RegistryEvent.Register<SoundEvent> e) {
        e.getRegistry().register(Main.SOUND_CLICKHOVER);
    }
}
