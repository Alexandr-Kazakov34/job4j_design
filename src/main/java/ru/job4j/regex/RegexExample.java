package ru.job4j.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Я учусь на Job4j");

        String textOne = "Я учусь на Job4j";
        Matcher matcherOne = pattern.matcher(textOne);
        boolean isPresentOne = matcherOne.matches();
        System.out.println(isPresentOne);

        String textTwo = "Я учусь на курсе Job4j";
        Matcher matcherTwo = pattern.matcher(textTwo);
        boolean isPresentTwo = matcherTwo.matches();
        System.out.println(isPresentTwo);

        Pattern pattern2 = Pattern.compile("11");
        String text = "111111";
        Matcher matcher2 = pattern2.matcher(text);
        while (matcher2.find()) {
            System.out.println("Найдено совпадение: " + matcher2.group());
        }

        String string = "123+=-456:/789";
        String[] result = string.split("\\D+");
        System.out.println(Arrays.toString(result));

        Pattern pattern3 = Pattern.compile("\\b\\d{2}\\.\\d{2}\\.\\d{4}\\b");
        String text2 = "20.04.1987 11.11.111111 99.99.99991 99.99.9999 9999.9999 00.00.0000";
        Matcher matcher3 = pattern3.matcher(text2);
        while (matcher3.find()) {
            System.out.println("Найдено совпадение: " + matcher3.group());
        }
    }
}