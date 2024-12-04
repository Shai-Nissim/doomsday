package com.example.doomsday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/date")
public class DateController {

    @Autowired
    private DoomsdayService doomsdayService;

    @GetMapping("/dayOfWeek")
    public String getDayOfWeek(@RequestParam int day, @RequestParam int month, @RequestParam int year) {
        return doomsdayService.getWeekday(day, month, year);
    }
}
