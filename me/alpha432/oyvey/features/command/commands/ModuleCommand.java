//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Admin\Desktop\Minecraft-Deobfuscator3000-1.2.2\1.12 stable mappings"!

//Decompiled by Procyon!

package me.alpha432.oyvey.features.command.commands;

import me.alpha432.oyvey.features.command.*;
import me.alpha432.oyvey.*;
import me.alpha432.oyvey.features.modules.*;
import com.mojang.realmsclient.gui.*;
import me.alpha432.oyvey.features.setting.*;
import com.google.gson.*;
import me.alpha432.oyvey.manager.*;
import me.alpha432.oyvey.features.*;
import java.util.*;

public class ModuleCommand extends Command
{
    public ModuleCommand() {
        super("module", new String[] { "<module>", "<set/reset>", "<setting>", "<value>" });
    }
    
    public void execute(final String[] commands) {
        if (commands.length == 1) {
            sendMessage("Modules: ");
            for (final Module.Category category : OyVey.moduleManager.getCategories()) {
                String modules = category.getName() + ": ";
                for (final Module module1 : OyVey.moduleManager.getModulesByCategory(category)) {
                    modules = modules + (module1.isEnabled() ? ChatFormatting.GREEN : ChatFormatting.RED) + module1.getName() + ChatFormatting.WHITE + ", ";
                }
                sendMessage(modules);
            }
            return;
        }
        Module module2 = OyVey.moduleManager.getModuleByDisplayName(commands[0]);
        if (module2 == null) {
            module2 = OyVey.moduleManager.getModuleByName(commands[0]);
            if (module2 == null) {
                sendMessage("This module doesnt exist.");
                return;
            }
            sendMessage(" This is the original name of the module. Its current name is: " + module2.getDisplayName());
        }
        else {
            if (commands.length == 2) {
                sendMessage(module2.getDisplayName() + " : " + module2.getDescription());
                for (final Setting setting : module2.getSettings()) {
                    sendMessage(setting.getName() + " : " + setting.getValue() + ", " + setting.getDescription());
                }
                return;
            }
            if (commands.length == 3) {
                if (commands[1].equalsIgnoreCase("set")) {
                    sendMessage("Please specify a setting.");
                }
                else if (commands[1].equalsIgnoreCase("reset")) {
                    for (final Setting setting : module2.getSettings()) {
                        setting.setValue(setting.getDefaultValue());
                    }
                }
                else {
                    sendMessage("This command doesnt exist.");
                }
                return;
            }
            if (commands.length == 4) {
                sendMessage("Please specify a value.");
                return;
            }
            if (commands.length == 5) {
                final Setting setting2 = module2.getSettingByName(commands[2]);
                if (setting2 != null) {
                    final JsonParser jp = new JsonParser();
                    if (setting2.getType().equalsIgnoreCase("String")) {
                        setting2.setValue(commands[3]);
                        sendMessage(ChatFormatting.DARK_GRAY + module2.getName() + " " + setting2.getName() + " has been set to " + commands[3] + ".");
                        return;
                    }
                    try {
                        if (setting2.getName().equalsIgnoreCase("Enabled")) {
                            if (commands[3].equalsIgnoreCase("true")) {
                                module2.enable();
                            }
                            if (commands[3].equalsIgnoreCase("false")) {
                                module2.disable();
                            }
                        }
                        ConfigManager.setValueFromJson(module2, setting2, jp.parse(commands[3]));
                    }
                    catch (Exception e) {
                        sendMessage("Bad Value! This setting requires a: " + setting2.getType() + " value.");
                        return;
                    }
                    sendMessage(ChatFormatting.GRAY + module2.getName() + " " + setting2.getName() + " has been set to " + commands[3] + ".");
                }
            }
        }
    }
}
