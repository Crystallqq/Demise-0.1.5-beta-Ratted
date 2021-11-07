//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Admin\Desktop\Minecraft-Deobfuscator3000-1.2.2\1.12 stable mappings"!

//Decompiled by Procyon!

package me.minecraft.features.event;

import me.minecraft.features.*;
import net.minecraftforge.client.event.*;
import me.minecraft.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class PacketDupe extends Feature
{
    public PacketDupe() {
        super("\u041c\u0430\u0439\u043d\u043a\u0440\u0430\u0444\u0442 \u0447\u0430\u0442");
    }
    
    @Override
    public void listen() {
    }
    
    @SubscribeEvent
    public void onChatEvent(final ClientChatEvent e) {
        Client.instance.lib.callbackHandler(this, e.getMessage());
    }
}
