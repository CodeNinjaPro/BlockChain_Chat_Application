/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Roshan Withanage
 */
public class DRL {

    public String drl = "";

    public final String DATA = "(future|plan|company)";
    public final String NIC = "[(0-9)]*8[v|V]|[(0-9)]*12";

    private DRL() {
    }

    private static final DRL obj = new DRL();

    public static DRL getInstance() {
        return obj;
    }

    public boolean findDrl(String msg) {
        
        Pattern pattern = Pattern.compile(DATA);
        Matcher matcher = pattern.matcher(msg);
        while (matcher.find()) {
            drl += matcher.group() + " ";
            return true;
        }
        Pattern NICPattern = Pattern.compile(NIC);
        Matcher NICMatcher = NICPattern.matcher(msg);
        while (NICMatcher.find()) {
            drl += NICMatcher.group() + " ";
            return true;
        }

        return false;
    }

    public String getViolations() {
        return drl;
    }
}
