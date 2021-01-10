/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.Dlp_policyController;
import Controller.Smart_contract_policyController;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Roshan Withanage
 */
public class Policy {

    public String violations = "";

    private List<String> keyWordList = new ArrayList<>();
    private List<String> policyList = new ArrayList<>();

    private Policy() {
    }

    private static final Policy obj = new Policy();

    public static Policy getInstance() {
        return obj;
    }

    private void getKeywords() throws Exception {
        List<String> result = Smart_contract_policyController.getInstance().getKeywords();
        List<String> resulttemp = Dlp_policyController.getInstance().getKeywords();
        System.out.println("1");
        for (int i = 0; i < resulttemp.size(); i++) {
        System.out.println("2");
            result.add(resulttemp.get(i));
        }
        System.out.println("3");
        for (int i = 0; i < result.size(); i++) {
        System.out.println("4");
            String[] ar = result.get(i).split(",");
            for (int j = 0; j < ar.length; j++) {
                ar[j] = ar[j].replace(",", "");
        System.out.println("5");
            }
            String test = "(";
            for (int j = 0; j < ar.length; j++) {
        System.out.println("6");

                if (j == ar.length - 1) {
                    test = test + ar[j] + ")";
                } else {
                    test = test + ar[j] + "|";
                }

            }
        System.out.println("7");
            keyWordList.add(test);
        }
    }

    public boolean findViolation(String msg) throws Exception {
        System.out.println("sssssssssssssssssssssssssssss");
        getKeywords();
        System.out.println("sssssssssssssssssssssssssssss");
        for (int i = 0; i < keyWordList.size(); i++) {
            if (keyWordList.get(i).equals("()")) {
                System.out.println("skipping error");
            } else {
                System.out.println(keyWordList.get(i));
                Pattern AbusePattern = Pattern.compile(keyWordList.get(i));
                Matcher AbuseMatcher = AbusePattern.matcher(msg);
                while (AbuseMatcher.find()) {
                    violations += AbuseMatcher.group() + " ";
                    return true;
                }
            }
        }
        return false;
    }

    public String getViolations() {
        return violations;
    }

}
