//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Admin\Desktop\Minecraft-Deobfuscator3000-1.2.2\1.12 stable mappings"!

//Decompiled by Procyon!

package me.alpha432.oyvey.features.modules.misc;

import me.alpha432.oyvey.features.modules.*;
import me.alpha432.oyvey.features.setting.*;
import net.minecraft.client.network.*;
import net.minecraft.scoreboard.*;
import me.alpha432.oyvey.*;
import com.mojang.realmsclient.gui.*;

public class ExtraTab extends Module
{
    public Setting<Integer> size;
    private static ExtraTab INSTANCE;
    
    public ExtraTab() {
        super("ExtraTab", "Extends Tab.", Category.MISC, false, false, false);
        this.size = (Setting<Integer>)this.register(new Setting("Size", (T)250, (T)1, (T)1000));
        this.setInstance();
    }
    
    private void setInstance() {
        ExtraTab.INSTANCE = this;
    }
    
    public static String getPlayerName(final NetworkPlayerInfo networkPlayerInfoIn) {
        final String name = (networkPlayerInfoIn.getDisplayName() != null) ? networkPlayerInfoIn.getDisplayName().getFormattedText() : ScorePlayerTeam.formatPlayerName((Team)networkPlayerInfoIn.getPlayerTeam(), networkPlayerInfoIn.getGameProfile().getName());
        if (OyVey.friendManager.isFriend(name)) {
            return ChatFormatting.AQUA + name;
        }
        return name;
    }
    
    public static ExtraTab getINSTANCE() {
        if (ExtraTab.INSTANCE == null) {
            ExtraTab.INSTANCE = new ExtraTab();
        }
        return ExtraTab.INSTANCE;
    }
    
    static {
        ExtraTab.INSTANCE = new ExtraTab();
    }
}
