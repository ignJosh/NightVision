package me.josh.nightvision.utils;

/**
 * @author Josh Becconsall (https://github.com/ignJosh)
 * @Date 11/07/2021 19:39
 */

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class CC {
    public static final String BLUE;
    public static final String AQUA;
    public static final String YELLOW;
    public static final String RED;
    public static final String GRAY;
    public static final String GOLD;
    public static final String GREEN;
    public static final String WHITE;
    public static final String BLACK;
    public static final String BOLD;
    public static final String ITALIC;
    public static final String UNDER_LINE;
    public static final String STRIKE_THROUGH;
    public static final String RESET;
    public static final String MAGIC;
    public static final String DARK_BLUE;
    public static final String DARK_AQUA;
    public static final String DARK_GRAY;
    public static final String DARK_GREEN;
    public static final String DARK_PURPLE;
    public static final String DARK_RED;
    public static final String PINK;
    public static final String MENU_BAR;
    public static final String CHAT_BAR;
    public static final String SB_BAR;
    public static final String CONSOLE_NAME;
    public static final String NO_PERMISSION;
    public static final String PLAYER_ONLY;
    public static final String CONSOLE_ONLY;

    static {
        BLUE = ChatColor.BLUE.toString();
        AQUA = ChatColor.AQUA.toString();
        YELLOW = ChatColor.YELLOW.toString();
        RED = ChatColor.RED.toString();
        GRAY = ChatColor.GRAY.toString();
        GOLD = ChatColor.GOLD.toString();
        GREEN = ChatColor.GREEN.toString();
        WHITE = ChatColor.WHITE.toString();
        BLACK = ChatColor.BLACK.toString();
        BOLD = ChatColor.BOLD.toString();
        ITALIC = ChatColor.ITALIC.toString();
        UNDER_LINE = ChatColor.UNDERLINE.toString();
        STRIKE_THROUGH = ChatColor.STRIKETHROUGH.toString();
        RESET = ChatColor.RESET.toString();
        MAGIC = ChatColor.MAGIC.toString();
        DARK_BLUE = ChatColor.DARK_BLUE.toString();
        DARK_AQUA = ChatColor.DARK_AQUA.toString();
        DARK_GRAY = ChatColor.DARK_GRAY.toString();
        DARK_GREEN = ChatColor.DARK_GREEN.toString();
        DARK_PURPLE = ChatColor.DARK_PURPLE.toString();
        DARK_RED = ChatColor.DARK_RED.toString();
        PINK = ChatColor.LIGHT_PURPLE.toString();
        MENU_BAR = ChatColor.STRIKETHROUGH.toString() + "------------------------------";
        CHAT_BAR = ChatColor.BLUE.toString() + ChatColor.STRIKETHROUGH.toString() + "------------------------------------------------";
        SB_BAR = ChatColor.STRIKETHROUGH.toString() + "----------------------";
        NO_PERMISSION = ChatColor.RED.toString() + "No Permission";
        PLAYER_ONLY = ChatColor.RED.toString() + "Only players can use this command";
        CONSOLE_ONLY = ChatColor.RED.toString() + "Only console can use this command";
        CONSOLE_NAME = CC.DARK_RED + CC.BOLD + "CONSOLE";
    }

    public static String translate(final String in) {
        return ChatColor.translateAlternateColorCodes('&', in);
    }

    public static List<String> translate(final List<String> lines) {
        final List<String> toReturn = new ArrayList<String>();
        for (final String line : lines) {
            toReturn.add(ChatColor.translateAlternateColorCodes('&', line));
        }
        return toReturn;
    }

    public static List<String> translate(final String[] lines) {
        final List<String> toReturn = new ArrayList<String>();
        for (final String line : lines) {
            if (line != null) {
                toReturn.add(ChatColor.translateAlternateColorCodes('&', line));
            }
        }
        return toReturn;
    }

    public static String chat(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static List<String> list(List<String> s) {
        List<String> stringList = new ArrayList<String>();
        s.forEach(str -> stringList.add(chat(str)));
        return stringList;
    }
}
