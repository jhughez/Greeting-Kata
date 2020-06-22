package com.lislea.tdd.greetingkata;

import java.util.ArrayList;
import java.util.List;

public class Greeting {
    public String greet(String ... names) {
        String messageNormal = "Hello, %s.";
        String messageShout = "HELLO %s!";
        if (names == null) {
            return String.format("Hello, my friend.");
        }
        if (names.length > 1) {
            String message = "";
            String titleCase = getListCsvListOfNames(getTitleCaseNames(names));
            if (titleCase.length() > 0) {
                message = message + String.format(messageNormal, titleCase);
            }
            String upperCase = getListCsvListOfNames(getListUpperNames(names));
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

    private String getListCsvListOfNames(String ... names) {

        if(names.length == 0)
            return "";

        String csv = String.join(", ", names);
        String and = ", and ";
        int numberOfCommas = csv.split(", ").length - 1;
        if (numberOfCommas == 0)
            return csv;
        if (numberOfCommas == 1)
            and = " and ";
        return csv.substring(0, csv.lastIndexOf(", ")) + and + csv.substring(csv.lastIndexOf(", ") + 2)
                .replaceAll("%", ",");
    }

    private String[] getListUpperNames(String ... names) {
        List<String> nameList = new ArrayList<>();
        for (String name : names) {
            if(name.startsWith("\"") && name.endsWith("\"")){
                name = name.replaceAll(",", "%");
            }
            if (name.equals(name.toUpperCase()))
                nameList.add(name);
        }
        return nameList.toArray(new String[nameList.size()]);
    }

    private String[] getTitleCaseNames(String ... names){
        List<String> nameList = new ArrayList<String>();
        for(String name:names){
            if(name.startsWith("\"") && name.endsWith("\"")){
                name = name.replaceAll(",", "%").replaceAll("\"", "");
            }
            if (!name.equals(name.toUpperCase()))
                nameList.add(name);
        }
        return nameList.toArray(new String[nameList.size()]);
    }
}
