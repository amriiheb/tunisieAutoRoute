package tn.Proxym.ProxymAcademy.util;

import java.util.Map;
import java.util.regex.Pattern;

public class PasswordRules {
    public static boolean validatePassword(String passwordhere, Map<String, String> maps) {

        Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
        Pattern lowerCasePatten = Pattern.compile("[a-z ]");
        Pattern digitCasePatten = Pattern.compile("[0-9 ]");

        boolean flag = true;

        if (passwordhere.isEmpty()) {
            maps.put("errorMessage", "password not be empty");
            flag = false;
        } else if (passwordhere.length() < 6) {
            maps.put("errorMessage", "password lenght must have alleast 6 character");
            flag = false;
        } else if (!specailCharPatten.matcher(passwordhere).find()) {
            maps.put("errorMessage", "password must have atleast one special character");
            flag = false;
        } else if (!UpperCasePatten.matcher(passwordhere).find()) {
            maps.put("errorMessage", "password must have atleast one uppercase character");
            flag = false;
        }else if (!lowerCasePatten.matcher(passwordhere).find()) {
            maps.put("errorMessage", "password must have atleast one lowercase character");
            flag = false;
        } else if (!digitCasePatten.matcher(passwordhere).find()) {
            maps.put("errorMessage", "password must have atleast one digit character");
            flag = false;
        }

        return flag;

    }
}
