package com.vector.school.Utils;

import java.util.Arrays;
import java.util.Date;

public class DateUtils {
    public Date stringToDate(String stringDate){
        String[] month = new String[12];
        month[0] = "Jan";
        month[1] = "Feb";
        month[2] = "Mar";
        month[3] = "Apr";
        month[4] = "May";
        month[5] = "Jun";
        month[6] = "Jul";
        month[7] = "Aug";
        month[8] = "Sep";
        month[9] = "Oct";
        month[10] = "Nov";
        month[11] = "Dec";

        String[] dateList = stringDate.split(" ");
        int indexofMonth = Arrays.asList(month).indexOf(dateList[1]);
        return new Date(Integer.valueOf(dateList[5])-1900,indexofMonth+1,Integer.valueOf(dateList[2]));
    }
}
