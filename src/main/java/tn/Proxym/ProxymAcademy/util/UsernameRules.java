package tn.Proxym.ProxymAcademy.util;

public class UsernameRules {
    public static boolean validUsername(String username) {
        return username.matches("[A-Za-z0-9_]+");
    }

}
