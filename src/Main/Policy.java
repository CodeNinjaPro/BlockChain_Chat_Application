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
public class Policy {

    public String violations = "";

    public final String ABUSE = "(sex|xxx|porn|naked|prostitute)";
    public final String SALARY = "(salary|sal|money)";
    public final String USER_DETAILS = "(password|key|keyword|token|pass)";

    private Policy() {
    }

    private static final Policy obj = new Policy();

    public static Policy getInstance() {
        return obj;
    }

    public boolean findViolation(String msg) {
        //find Abuse
        Pattern AbusePattern = Pattern.compile(ABUSE);
        Matcher AbuseMatcher = AbusePattern.matcher(msg);
        while (AbuseMatcher.find()) {
            violations += AbuseMatcher.group() + " ";
            return true;
        }
        //find salary
        Pattern SalaryPattern = Pattern.compile(SALARY);
        Matcher SalaryMatcher = SalaryPattern.matcher(msg);
        while (SalaryMatcher.find()) {
            violations += SalaryMatcher.group() + " ";
            return true;
        }
        //find user details
        Pattern UserDetailsPattern = Pattern.compile(USER_DETAILS);
        Matcher UserDetailsMatcher = UserDetailsPattern.matcher(msg);
        while (UserDetailsMatcher.find()) {
            violations += UserDetailsMatcher.group() + " ";
            return true;
        }

        return false;
    }

    public String getViolations() {
        return violations;
    }

}
