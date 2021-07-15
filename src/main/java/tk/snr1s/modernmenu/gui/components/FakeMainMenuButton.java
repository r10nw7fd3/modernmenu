package tk.snr1s.modernmenu.gui.components;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import tk.snr1s.modernmenu.Main;

public class FakeMainMenuButton extends GuiButton {

    private boolean playHoverSound = true;

    public FakeMainMenuButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
        super(buttonId, x, y, widthIn, heightIn, buttonText);
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        if (mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height) {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            if (playHoverSound) {
                playHoverSound = false;
//                mc.player.playSound(Main.SOUND_CLICKHOVER, 1.0F, 1.0F);
            }
        }
        else {
            GlStateManager.color(0.8F, 0.8F, 0.8F, 0.8F);
            playHoverSound = true;
        }
        mc.getTextureManager().bindTexture(new ResourceLocation(Main.MODID, "textures/gui/buttons/" + id + ".png"));
        drawModalRectWithCustomSizedTexture(x, y, 0, 0, width, height, 32, 32);
    }

    @Override
    public void playPressSound(SoundHandler soundHandlerIn) {
        soundHandlerIn.playSound(PositionedSoundRecord.getMasterRecord(Main.SOUND_CLICKHOVER, 1.0F));
    }
}
