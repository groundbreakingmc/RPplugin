package ru.siaw.free.rpplugin.function;

import org.bukkit.entity.Player;
import ru.siaw.free.rpplugin.utility.RpSender;

import java.util.Random;

public class Try {
    private static boolean enabled = false;
    private static String successful, unsuccessful, original;
    private static final RpSender sendUtil = new RpSender();

    public static void send(Player sender, String msg) {
        if (!enabled)
            return;

        StringBuilder newMsg = new StringBuilder(original);

        String word = "%luckmsg";
        if (original.contains(word)) {
            int index = original.indexOf(word);
            newMsg.replace(index, index + 8, luckMsg());
        }
        
        sendUtil.use(sender, msg, newMsg.toString());
    }

    private static String luckMsg() {
        return new Random().nextInt(2) == 1 ? successful : unsuccessful;
    }

    public static void setTryEnabled(boolean value) { enabled = value; }
    public static void setTrySuccessful(String value) { successful = value; }
    public static void setTryUnsuccessful(String value) { unsuccessful = value; }
    public static void setTryOriginal(String value) { original = value; }

    public static void setTryGlobal(boolean value) { sendUtil.setGlobal(value); }
    public static void setTryRadius(int value) { sendUtil.setRadius(value); }
}