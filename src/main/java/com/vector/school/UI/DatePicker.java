package com.vector.school.UI;

public class DatePicker {
    private int[] year, date;
    private String[] month;

    public int[] getYearList(int year_start, int year_end){
        year = new int[year_end-year_start];
        for(int y=year_start;y<year_end;y++){
            year[y-year_start]=y;
        }
        return year;
    }

    public String[] getMonthList(){
        month = new String[12];
        month[0] = "January";
        month[1] = "February";
        month[2] = "March";
        month[3] = "April";
        month[4] = "May";
        month[5] = "June";
        month[6] = "July";
        month[7] = "August";
        month[8] = "September";
        month[9] = "October";
        month[10] = "November";
        month[11] = "December";


        return month;
    }

    public int[] getDateList(int selectedMonth, int selectedYear){
        int dates = 30;
        if(selectedMonth==1){
            if(selectedYear%4==0){
                if(selectedYear%100==0){
                    dates = 28;
                }
                else{
                    dates = 29;
                }
            }
            else{
                dates = 28;
            }
        }
        if(selectedMonth<7 && selectedMonth%2==0){
            dates = 31;
        }
        else if(selectedMonth>6 && selectedMonth%2==1){
            dates = 31;
        }
        date = new int[dates];
        for(int d=0;d<dates;d++){
            date[d] = d+1;
        }
        return date;
    }
}
