//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Admin\Desktop\Minecraft-Deobfuscator3000-1.2.2\1.12 stable mappings"!

//Decompiled by Procyon!

package me.alpha432.oyvey.manager;

import me.alpha432.oyvey.features.*;
import net.minecraftforge.common.*;
import com.mojang.realmsclient.gui.*;
import me.alpha432.oyvey.features.command.*;
import me.alpha432.oyvey.event.events.*;
import net.minecraft.network.play.client.*;
import me.alpha432.oyvey.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class ReloadManager extends Feature
{
    public String prefix;
    
    public void init(final String prefix) {
        this.prefix = prefix;
        MinecraftForge.EVENT_BUS.register((Object)this);
        if (!fullNullCheck()) {
            Command.sendMessage(ChatFormatting.RED + "OyVey has been unloaded. Type " + prefix + "reload to reload.");
        }
    }
    
    public void unload() {
        MinecraftForge.EVENT_BUS.unregister((Object)this);
    }
    
    @SubscribeEvent
    public void onPacketSend(final PacketEvent.Send event) {
        if (event.getPacket() instanceof CPacketChatMessage) {
            final CPacketChatMessage packet = (CPacketChatMessage)event.getPacket();
            if (packet.getMessage().startsWith(this.prefix) && packet.getMessage().contains("reload")) {
                OyVey.load();
                event.setCanceled(true);
            }
        }
    }
}
