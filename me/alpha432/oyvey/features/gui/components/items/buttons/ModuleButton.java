//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Admin\Desktop\Minecraft-Deobfuscator3000-1.2.2\1.12 stable mappings"!

//Decompiled by Procyon!

package me.alpha432.oyvey.features.gui.components.items.buttons;

import me.alpha432.oyvey.features.modules.*;
import net.minecraft.util.*;
import me.alpha432.oyvey.features.gui.components.items.*;
import me.alpha432.oyvey.features.setting.*;
import java.util.*;
import me.alpha432.oyvey.features.modules.client.*;
import me.alpha432.oyvey.features.gui.*;
import me.alpha432.oyvey.features.gui.components.*;
import org.lwjgl.opengl.*;
import net.minecraft.init.*;
import net.minecraft.client.audio.*;

public class ModuleButton extends Button
{
    private final Module module;
    private ResourceLocation logo;
    private List<Item> items;
    private boolean subOpen;
    
    public ModuleButton(final Module module) {
        super(module.getName());
        this.logo = new ResourceLocation("textures/oyvey.png");
        this.items = new ArrayList<Item>();
        this.module = module;
        this.initSettings();
    }
    
    public void initSettings() {
        final List<Item> newItems = new ArrayList<Item>();
        if (!this.module.getSettings().isEmpty()) {
            for (final Setting setting : this.module.getSettings()) {
                if (setting.getValue() instanceof Boolean && !setting.getName().equals("Enabled")) {
                    newItems.add((Item)new BooleanButton(setting));
                }
                if (setting.getValue() instanceof Bind && !setting.getName().equalsIgnoreCase("Keybind") && !this.module.getName().equalsIgnoreCase("Hud")) {
                    newItems.add((Item)new BindButton(setting));
                }
                if ((setting.getValue() instanceof String || setting.getValue() instanceof Character) && !setting.getName().equalsIgnoreCase("displayName")) {
                    newItems.add((Item)new StringButton(setting));
                }
                if (setting.isNumberSetting() && setting.hasRestriction()) {
                    newItems.add((Item)new Slider(setting));
                }
                else {
                    if (!setting.isEnumSetting()) {
                        continue;
                    }
                    newItems.add((Item)new EnumButton(setting));
                }
            }
        }
        newItems.add((Item)new BindButton(this.module.getSettingByName("Keybind")));
        this.items = newItems;
    }
    
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        if (!this.items.isEmpty()) {
            if (HUD.getInstance().magenDavid.getValue()) {
                ModuleButton.mc.getTextureManager().bindTexture(this.logo);
                drawCompleteImage(this.x - 1.5f + this.width - 7.4f, this.y - 2.2f - OyVeyGui.getClickGui().getTextOffset(), 8, 8);
            }
            if (this.subOpen) {
                float height = 1.0f;
                for (final Item item : this.items) {
                    ++Component.counter1[0];
                    if (!item.isHidden()) {
                        height += 15.0f;
                        item.setLocation(this.x + 1.0f, this.y + height);
                        item.setHeight(15);
                        item.setWidth(this.width - 9);
                        item.drawScreen(mouseX, mouseY, partialTicks);
                    }
                    item.update();
                }
            }
        }
    }
    
    public static void drawCompleteImage(final float posX, final float posY, final int width, final int height) {
        GL11.glPushMatrix();
        GL11.glTranslatef(posX, posY, 0.0f);
        GL11.glBegin(7);
        GL11.glTexCoord2f(0.0f, 0.0f);
        GL11.glVertex3f(0.0f, 0.0f, 0.0f);
        GL11.glTexCoord2f(0.0f, 1.0f);
        GL11.glVertex3f(0.0f, (float)height, 0.0f);
        GL11.glTexCoord2f(1.0f, 1.0f);
        GL11.glVertex3f((float)width, (float)height, 0.0f);
        GL11.glTexCoord2f(1.0f, 0.0f);
        GL11.glVertex3f((float)width, 0.0f, 0.0f);
        GL11.glEnd();
        GL11.glPopMatrix();
    }
    
    public void mouseClicked(final int mouseX, final int mouseY, final int mouseButton) {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        if (!this.items.isEmpty()) {
            if (mouseButton == 1 && this.isHovering(mouseX, mouseY)) {
                this.subOpen = !this.subOpen;
                ModuleButton.mc.getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord(SoundEvents.UI_BUTTON_CLICK, 1.0f));
            }
            if (this.subOpen) {
                for (final Item item : this.items) {
                    if (!item.isHidden()) {
                        item.mouseClicked(mouseX, mouseY, mouseButton);
                    }
                }
            }
        }
    }
    
    public void onKeyTyped(final char typedChar, final int keyCode) {
        super.onKeyTyped(typedChar, keyCode);
        if (!this.items.isEmpty() && this.subOpen) {
            for (final Item item : this.items) {
                if (!item.isHidden()) {
                    item.onKeyTyped(typedChar, keyCode);
                }
            }
        }
    }
    
    public int getHeight() {
        if (this.subOpen) {
            int height = 14;
            for (final Item item : this.items) {
                if (!item.isHidden()) {
                    height += item.getHeight() + 1;
                }
            }
            return height + 2;
        }
        return 14;
    }
    
    public Module getModule() {
        return this.module;
    }
    
    public void toggle() {
        this.module.toggle();
    }
    
    public boolean getState() {
        return this.module.isEnabled();
    }
}
