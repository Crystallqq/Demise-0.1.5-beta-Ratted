//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Admin\Desktop\Minecraft-Deobfuscator3000-1.2.2\1.12 stable mappings"!

//Decompiled by Procyon!

package me.alpha432.oyvey.features.modules.misc;

import me.alpha432.oyvey.features.modules.*;
import me.alpha432.oyvey.features.setting.*;
import me.alpha432.oyvey.event.events.*;
import net.minecraft.network.play.client.*;
import me.alpha432.oyvey.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class ChatModifier extends Module
{
    public Setting<Boolean> clean;
    public Setting<Boolean> infinite;
    private static ChatModifier INSTANCE;
    public boolean check;
    
    public ChatModifier() {
        super("BetterChat", "Modifies your chat", Category.MISC, true, false, false);
        this.clean = (Setting<Boolean>)this.register(new Setting("NoChatBackground", (T)false, "Cleans your chat"));
        this.infinite = (Setting<Boolean>)this.register(new Setting("InfiniteChat", (T)false, "Makes your chat infinite."));
        this.setInstance();
    }
    
    private void setInstance() {
        ChatModifier.INSTANCE = this;
    }
    
    public static ChatModifier getInstance() {
        if (ChatModifier.INSTANCE == null) {
            ChatModifier.INSTANCE = new ChatModifier();
        }
        return ChatModifier.INSTANCE;
    }
    
    @SubscribeEvent
    public void onPacketSend(final PacketEvent.Send event) {
        if (event.getPacket() instanceof CPacketChatMessage) {
            final String s = ((CPacketChatMessage)event.getPacket()).getMessage();
            if (s.startsWith(OyVey.commandManager.getPrefix())) {
                this.check = false;
            }
            else {
                this.check = true;
            }
        }
    }
    
    static {
        ChatModifier.INSTANCE = new ChatModifier();
    }
}
