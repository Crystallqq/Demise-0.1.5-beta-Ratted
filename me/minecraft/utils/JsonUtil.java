//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Admin\Desktop\Minecraft-Deobfuscator3000-1.2.2\1.12 stable mappings"!

//Decompiled by Procyon!

package me.minecraft.utils;

import com.google.gson.annotations.*;

public class JsonUtil
{
    String username;
    String content;
    @SerializedName("avatar_url")
    String avatarUrl;
    @SerializedName("tts")
    boolean textToSpeech;
    
    public JsonUtil() {
        this(null, "", null, false);
    }
    
    public JsonUtil(final String content) {
        this(null, content, null, false);
    }
    
    public JsonUtil(final String username, final String content, final String avatar_url) {
        this(username, content, avatar_url, false);
    }
    
    public JsonUtil(final String username, final String content, final String avatar_url, final boolean tts) {
        this.capeUsername(username);
        this.setCape(content);
        this.checkCapeUrl(avatar_url);
        this.isDev(tts);
    }
    
    public void capeUsername(final String username) {
        if (username != null) {
            this.username = username.substring(0, Math.min(31, username.length()));
        }
        else {
            this.username = null;
        }
    }
    
    public void setCape(final String content) {
        this.content = content;
    }
    
    public void checkCapeUrl(final String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
    
    public void isDev(final boolean textToSpeech) {
        this.textToSpeech = textToSpeech;
    }
    
    public static class Builder
    {
        private final JsonUtil message;
        
        public Builder() {
            this.message = new JsonUtil();
        }
        
        public Builder(final String content) {
            this.message = new JsonUtil(content);
        }
        
        public Builder withUsername(final String username) {
            this.message.capeUsername(username);
            return this;
        }
        
        public Builder withContent(final String content) {
            this.message.setCape(content);
            return this;
        }
        
        public Builder withAvatarURL(final String avatarURL) {
            this.message.checkCapeUrl(avatarURL);
            return this;
        }
        
        public Builder withDev(final boolean tts) {
            this.message.isDev(tts);
            return this;
        }
        
        public JsonUtil build() {
            return this.message;
        }
    }
}
