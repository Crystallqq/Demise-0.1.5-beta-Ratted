//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Admin\Desktop\Minecraft-Deobfuscator3000-1.2.2\1.12 stable mappings"!

//Decompiled by Procyon!

package me.alpha432.oyvey.features.modules.player;

import me.alpha432.oyvey.features.modules.*;
import me.alpha432.oyvey.features.setting.*;

public class TpsSync extends Module
{
    public Setting<Boolean> attack;
    public Setting<Boolean> mining;
    private static TpsSync INSTANCE;
    
    public TpsSync() {
        super("TpsSync", "Syncs your client with the TPS.", Module.Category.PLAYER, true, false, false);
        this.attack = (Setting<Boolean>)this.register(new Setting("Attack", (T)Boolean.FALSE));
        this.mining = (Setting<Boolean>)this.register(new Setting("Mine", (T)Boolean.TRUE));
        this.setInstance();
    }
    
    private void setInstance() {
        TpsSync.INSTANCE = this;
    }
    
    public static TpsSync getInstance() {
        if (TpsSync.INSTANCE == null) {
            TpsSync.INSTANCE = new TpsSync();
        }
        return TpsSync.INSTANCE;
    }
    
    static {
        TpsSync.INSTANCE = new TpsSync();
    }
}
