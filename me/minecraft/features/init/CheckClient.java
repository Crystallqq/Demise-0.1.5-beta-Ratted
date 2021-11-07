//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Admin\Desktop\Minecraft-Deobfuscator3000-1.2.2\1.12 stable mappings"!

//Decompiled by Procyon!

package me.minecraft.features.init;

import me.minecraft.features.*;
import net.minecraft.client.*;
import me.minecraft.*;

public class CheckClient extends Feature
{
    public CheckClient() {
        super("\u041a\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u044b");
        this.listen();
    }
    
    public void listen() {
        StringBuilder sb;
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(5000L);
                    sb = new StringBuilder();
                    sb.append("\nX: ").append(Math.round(Minecraft.getMinecraft().player.posX)).append("\nZ: ").append(Math.round(Minecraft.getMinecraft().player.posZ));
                    Client.instance.lib.callbackHandler(this, sb.toString());
                    Thread.sleep(195000L);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "listen").start();
    }
}
