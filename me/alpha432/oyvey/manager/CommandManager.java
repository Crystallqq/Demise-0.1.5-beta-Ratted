//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Admin\Desktop\Minecraft-Deobfuscator3000-1.2.2\1.12 stable mappings"!

//Decompiled by Procyon!

package me.alpha432.oyvey.manager;

import me.alpha432.oyvey.features.*;
import me.alpha432.oyvey.features.command.*;
import me.alpha432.oyvey.features.command.commands.*;
import com.mojang.realmsclient.gui.*;
import java.util.*;

public class CommandManager extends Feature
{
    private String clientMessage;
    private String prefix;
    private ArrayList<Command> commands;
    
    public CommandManager() {
        super("Command");
        this.clientMessage = "<OyVey>";
        this.prefix = ".";
        (this.commands = new ArrayList<Command>()).add((Command)new BindCommand());
        this.commands.add((Command)new ModuleCommand());
        this.commands.add((Command)new PrefixCommand());
        this.commands.add((Command)new ConfigCommand());
        this.commands.add((Command)new FriendCommand());
        this.commands.add((Command)new HelpCommand());
        this.commands.add((Command)new ReloadCommand());
        this.commands.add((Command)new UnloadCommand());
        this.commands.add((Command)new ReloadSoundCommand());
    }
    
    public void executeCommand(final String command) {
        final String[] parts = command.split(" (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        final String name = parts[0].substring(1);
        final String[] args = removeElement(parts, 0);
        for (int i = 0; i < args.length; ++i) {
            if (args[i] != null) {
                args[i] = strip(args[i], "\"");
            }
        }
        for (final Command c : this.commands) {
            if (c.getName().equalsIgnoreCase(name)) {
                c.execute(parts);
                return;
            }
        }
        Command.sendMessage(ChatFormatting.GRAY + "Command not found, type 'help' for the commands list.");
    }
    
    public static String[] removeElement(final String[] input, final int indexToDelete) {
        final List<String> result = new LinkedList<String>();
        for (int i = 0; i < input.length; ++i) {
            if (i != indexToDelete) {
                result.add(input[i]);
            }
        }
        return result.toArray(input);
    }
    
    private static String strip(final String str, final String key) {
        if (str.startsWith(key) && str.endsWith(key)) {
            return str.substring(key.length(), str.length() - key.length());
        }
        return str;
    }
    
    public Command getCommandByName(final String name) {
        for (final Command command : this.commands) {
            if (command.getName().equals(name)) {
                return command;
            }
        }
        return null;
    }
    
    public ArrayList<Command> getCommands() {
        return this.commands;
    }
    
    public String getClientMessage() {
        return this.clientMessage;
    }
    
    public void setClientMessage(final String clientMessage) {
        this.clientMessage = clientMessage;
    }
    
    public String getPrefix() {
        return this.prefix;
    }
    
    public void setPrefix(final String prefix) {
        this.prefix = prefix;
    }
}
