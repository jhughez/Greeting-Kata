package com.lislea.tdd.greetingkata;

public class Greeting {
    public String greet(String ... names) {
//        String message = "Hello, %s%s";
//        if (names == null)
//            return String.format(message, "my friend", terminateStandard);
//        else
        return getLowerCaseNames(names);
//            return String.format(message, getLowerCaseNames(names), terminateStandard);
//        else {
//            String returnVal =  String.format(message, names[0]);
//            if (names[0].equals(names[0].toUpperCase()))
//                returnVal = returnVal.toUpperCase();

            //return "returnVal";
       // }

    }

    private String getLowerCaseNames(String ... names) {
        char terminateShout = '!';
        char terminateStandard = '.';
//        StringBuilder lowerCaseStringBuilder = new StringBuilder("Hello, ");
//        StringBuilder upperCaseStringBuilder = new StringBuilder("HELLO, ");

        StringBuilder lowerCaseStringBuilder = new StringBuilder();
        StringBuilder upperCaseStringBuilder = new StringBuilder();
        for(int i = 0; i < names.length; i++) {
            if (names[i].equals(names[i].toUpperCase())) {
                upperCaseStringBuilder.append(" ");
                upperCaseStringBuilder.append(names[i]);
                upperCaseStringBuilder.append(",");
            } else {
                lowerCaseStringBuilder.append(" ");
                lowerCaseStringBuilder.append(names[i]);
                lowerCaseStringBuilder.append(",");
            }

        }
        if (lowerCaseStringBuilder.length() != 0){
            lowerCaseStringBuilder.insert(0, "Hello,");
            lowerCaseStringBuilder.replace(lowerCaseStringBuilder.length() - 1, lowerCaseStringBuilder.length(), ".");
        }

        if (upperCaseStringBuilder.length() != 0){
            upperCaseStringBuilder.insert(0, " AND HELLO");
            upperCaseStringBuilder.replace(upperCaseStringBuilder.length() - 1, upperCaseStringBuilder.length(), "!");
        }
            return lowerCaseStringBuilder.toString() + upperCaseStringBuilder.toString();
//        if (lowerCaseStringBuilder.)
//        long count2 = someString.codePoints().filter(ch -> ch == 'e').count();
//        String csv = String.join(
//                ", ", names);
//        String and = ", and";
//        int lastCommaIndex = csv.lastIndexOf(", ");
//        if(names.length == 2)
//            and = " and";
//        return csv.substring(0, lastCommaIndex) + and + csv.substring(lastCommaIndex + 1);
    }
}
