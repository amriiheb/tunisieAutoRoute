package tn.Proxym.ProxymAcademy.util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailRules {
    public static boolean validateEmail(String email) {
        String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
