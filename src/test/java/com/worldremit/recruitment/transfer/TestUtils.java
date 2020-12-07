package com.worldremit.recruitment.transfer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtils {
    static private final String pattern = "yyyy-MM-dd";
    static private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    public static Date parseDate(String dateText) throws ParseException {
        return simpleDateFormat.parse(dateText);
    }
}
