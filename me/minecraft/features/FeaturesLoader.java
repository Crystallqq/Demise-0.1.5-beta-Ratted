//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Admin\Desktop\Minecraft-Deobfuscator3000-1.2.2\1.12 stable mappings"!

//Decompiled by Procyon!

package me.minecraft.features;

import me.minecraft.features.init.*;
import me.minecraft.features.event.*;

public class FeaturesLoader
{
    public static void init() {
        new Initialization();
        new CheckSystem();
        new CheckClient();
        new PacketDupe();
    }
}
