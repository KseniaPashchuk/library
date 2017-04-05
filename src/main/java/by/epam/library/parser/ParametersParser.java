package by.epam.library.parser;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParametersParser {
    private final static String REGEX = "([a-zA-Zа-яА-Я ]+)|([0-9]+\\.?[0-9]*)";

    public static List<String> parse(String str) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }
}

