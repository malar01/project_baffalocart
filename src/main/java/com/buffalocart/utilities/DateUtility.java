package com.buffalocart.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

    public String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String str = formatter.format(date);
        return str;
    }
}
