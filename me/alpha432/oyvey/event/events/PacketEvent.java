//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Admin\Desktop\Minecraft-Deobfuscator3000-1.2.2\1.12 stable mappings"!

//Decompiled by Procyon!

package me.alpha432.oyvey.event.events;

import me.alpha432.oyvey.event.*;
import net.minecraft.network.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class PacketEvent extends EventStage
{
    private final Packet<?> packet;
    
    public PacketEvent(final int stage, final Packet<?> packet) {
        super(stage);
        this.packet = packet;
    }
    
    public <T extends Packet<?>> T getPacket() {
        return (T)this.packet;
    }
    
    @Cancelable
    public static class Receive extends PacketEvent
    {
        public Receive(final int stage, final Packet<?> packet) {
            super(stage, packet);
        }
    }
    
    @Cancelable
    public static class Send extends PacketEvent
    {
        public Send(final int stage, final Packet<?> packet) {
            super(stage, packet);
        }
    }
}
