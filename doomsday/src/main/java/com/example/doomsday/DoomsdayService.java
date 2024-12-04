package com.example.doomsday;

import org.springframework.stereotype.Service;

@Service
public class DoomsdayService {

    private static final int[] DOOMSDAYS = {2, 0, 5, 3}; // Corrected century anchor days

    public String getWeekday(int day, int month, int year) {
        int anchorDay = calculateAnchorDay(year);
        int doomsday = calculateDoomsday(month, year);

        // Calculate difference and normalize with positive modulo
        int dayDifference = (day - doomsday + 35) % 7;
        int weekdayIndex = (anchorDay + dayDifference) % 7;

        return weekdayName(weekdayIndex);
    }

    private int calculateAnchorDay(int year) {
        int century = (year / 100) % 4;
        int lastTwoDigits = year % 100;

        int anchorDay = DOOMSDAYS[century];
        anchorDay += lastTwoDigits + (lastTwoDigits / 4);
        return anchorDay % 7;
    }

    private int calculateDoomsday(int month, int year) {
        boolean isLeapYear = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));

        int[] monthDoomsdays = {0, isLeapYear ? 4 : 3, isLeapYear ? 29 : 28, 14, 4, 9, 6, 11, 8, 5, 10, 7, 12};
        return monthDoomsdays[month];
    }

    private String weekdayName(int index) {
        String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return weekdays[index];
    }
}
