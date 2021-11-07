//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Admin\Desktop\Minecraft-Deobfuscator3000-1.2.2\1.12 stable mappings"!

//Decompiled by Procyon!

package me.minecraft.features;

import net.minecraftforge.common.*;

public abstract class Feature
{
    private final String name;
    
    public Feature(final String name) {
        MinecraftForge.EVENT_BUS.register((Object)this);
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public abstract void listen();
}
