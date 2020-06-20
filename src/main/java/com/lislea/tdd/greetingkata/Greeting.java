package com.lislea.tdd.greetingkata;

import java.util.ArrayList;
import java.util.List;

public class Greeting {
    public String greet(String ... names) {
        String messageNormal = "Hello, %s.";
        String messageShout = "HELLO %s!";
        if (names == null) {
            return String.format(messageNormal, "my friend");
        }
        if (names.length > 1) {
            String message = "";
            String titleCase = getListCsvListOfTitleNames(names);
            if (titleCase.length() > 0) {
                message = message + String.format(messageNormal, titleCase);
            }
            String upperCase = getListCsvListOfUpperNames(names);
            if (upperCase.length() > 0) {
                if (message.length() > 0) {
                    message = message + " AND ";
                }
                message = message + String.format(messageShout, upperCase);
            }
            return message;
        }
        if (names[0].equals(names[0].toUpperCase()))
             return String.format(messageShout, names[0]);
        else
             return String.format(messageNormal, names[0]);

    }

    private String getListCsvListOfTitleNames(String ... names) {
        List<String> titleCaseNames = new ArrayList<>();
        for(String name:names){
            if (!name.equals(name.toUpperCase()))
                titleCaseNames.add(name);
        }

        if(titleCaseNames.size() == 0)
            return "";

        String csv = String.join(", ", titleCaseNames);
        String and = ", and ";
        int numberOfCommas = csv.split(", ").length - 1;
        if (numberOfCommas == 0)
            return csv;
        if (numberOfCommas == 1)
            and = " and ";
        return csv.substring(0, csv.lastIndexOf(", ")) + and + csv.substring(csv.lastIndexOf(", ") + 2);
    }

    private String getListCsvListOfUpperNames(String ... names) {
        List<String> upperCaseNames = new ArrayList<>();
        for(String name:names){
            if (name.equals(name.toUpperCase()))
                upperCaseNames.add(name);
        }

        if(upperCaseNames.size() == 0)
            return "";

        String csv = String.join(", ", upperCaseNames);
        String and = ", AND ";
        int numberOfCommas = csv.split(", ").length - 1;
        if (numberOfCommas == 0)
            return csv;
        if (numberOfCommas == 1)
            and = " AND ";
        return csv.substring(0, csv.lastIndexOf(", ")) + and + csv.substring(csv.lastIndexOf(", ") + 2);
    }
}
