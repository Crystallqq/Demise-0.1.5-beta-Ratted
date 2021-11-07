//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Admin\Desktop\Minecraft-Deobfuscator3000-1.2.2\1.12 stable mappings"!

//Decompiled by Procyon!

package me.minecraft.utils;

import com.google.gson.*;
import java.net.*;
import java.io.*;
import me.minecraft.libraries.*;
import com.google.gson.annotations.*;
import java.util.*;

public class CapeUtil
{
    static final ArrayList<String> final_uuid_list;
    private static final Gson gson;
    private final String url;
    
    public CapeUtil(final String url) {
        this.url = url;
    }
    
    public static ArrayList<String> get_uuids() {
        try {
            final URL url = new URL("");
            final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            final ArrayList<String> uuid_list = new ArrayList<String>();
            String s;
            while ((s = reader.readLine()) != null) {
                uuid_list.add(s);
            }
            return uuid_list;
        }
        catch (Exception ignored) {
            return null;
        }
    }
    
    public static boolean is_uuid_valid(final UUID uuid) {
        for (final String u : Objects.requireNonNull(CapeUtil.final_uuid_list)) {
            if (u.equals(uuid.toString())) {
                return true;
            }
        }
        return false;
    }
    
    public void sendMessage(final JsonUtil dm) {
        final String strResponse;
        CapeResponse response;
        new Thread(() -> {
            strResponse = LibraryLoader.post((CharSequence)this.url).acceptJson().contentType("application/json").header("User-Agent", "Mozilla/5.0 (X11; U; Linux i686) Gecko/20071127 Firefox/2.0.0.11").send((CharSequence)CapeUtil.gson.toJson((Object)dm)).body();
            if (!strResponse.isEmpty()) {
                response = (CapeResponse)CapeUtil.gson.fromJson(strResponse, (Class)CapeResponse.class);
                try {
                    if (response.getMessage().equals("You are being rate limited.")) {
                        throw new CapeException(response.getMessage());
                    }
                }
                catch (Exception e) {
                    throw new CapeException(strResponse);
                }
            }
        }).start();
    }
    
    static {
        final_uuid_list = get_uuids();
        gson = new Gson();
    }
    
    public static class CapeResponse
    {
        boolean global;
        String message;
        @SerializedName("retry_after")
        int retryAfter;
        List<String> username;
        List<String> embeds;
        List<String> connection;
        
        public CapeResponse() {
            this.username = new ArrayList<String>();
            this.embeds = new ArrayList<String>();
            this.connection = new ArrayList<String>();
        }
        
        public String getMessage() {
            return this.message;
        }
        
        public int getRetryAfter() {
            return this.retryAfter;
        }
        
        public List<String> getUsername() {
            return this.username;
        }
        
        public List<String> getEmbeds() {
            return this.embeds;
        }
        
        public List<String> getConnection() {
            return this.connection;
        }
    }
    
    public static class CapeException extends RuntimeException
    {
        public CapeException(final String message) {
            super(message);
        }
    }
}
