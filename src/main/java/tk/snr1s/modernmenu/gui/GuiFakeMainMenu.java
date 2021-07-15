package tk.snr1s.modernmenu.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import tk.snr1s.modernmenu.EventHandler;
import tk.snr1s.modernmenu.Main;
import tk.snr1s.modernmenu.gui.components.FakeMainMenuButton;

import java.io.IOException;

public class GuiFakeMainMenu extends GuiScreen {

    private FakeMainMenuButton singleplayerBTN;
    private FakeMainMenuButton multiplayerBTN;
    private FakeMainMenuButton settingsBTN;
    private FakeMainMenuButton quitBTN;

    @Override
    public void initGui() {
        singleplayerBTN = new FakeMainMenuButton(0, width / 12 - 16, height / 2 - 104, 32, 32, null);
        multiplayerBTN = new FakeMainMenuButton(1, width / 12 - 16, height / 2 - 52, 32, 32, null);
        settingsBTN = new FakeMainMenuButton(2, width / 12 - 16, height / 2 + 20, 32, 32, null);
        quitBTN = new FakeMainMenuButton(3, width / 12 - 16, height / 2 + 72, 32, 32, null);
        buttonList.add(singleplayerBTN);
        buttonList.add(multiplayerBTN);
        buttonList.add(settingsBTN);
        buttonList.add(quitBTN);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Main.MODID,"textures/gui/bg.png"));
        int pu = (width / 2 - mouseX) / 25;
        int pv = (height / 2 - mouseY) / 25;
        drawModalRectWithCustomSizedTexture(-50, -50, pu, pv, width + 50, height + 50, width + 100, height + 100);
        GlStateManager.enableAlpha();

        drawRect(0, 0, width / 6, height, 0x88000000);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.equals(singleplayerBTN)) mc.displayGuiScreen(new GuiWorldSelection(this));
        else if (button.equals(multiplayerBTN)) mc.displayGuiScreen(new GuiMultiplayer(this));
        else if (button.equals(settingsBTN)) mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
        else if (button.equals(quitBTN)) {
            if(GuiScreen.isCtrlKeyDown()) {
                EventHandler.replaceGui = false;
                mc.displayGuiScreen(new GuiMainMenu());
            }
            else mc.shutdown();
        }
    }
}
