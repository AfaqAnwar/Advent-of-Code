package Challenges2018.Day4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Gaurd Class
 * This was made in order to keep things a little more organized.
 * @Author Afaq Anwar
 * @Version 05/13/2019
 */
public class Gaurd {
    private int id;
    private HashMap<String, int[]> scheduleLog;
    private int[] minutes;
    private int mostFrequent;

    public Gaurd(int id) {
        this.id = id;
        scheduleLog = new HashMap<>();
        minutes = new int[60];
    }

    public void updateMinutes(ArrayList<String> log) {
        int start = 0;
        int end = 0;
        int duration = 0;
        for (String entry : log) {
            entry.replace("[", "").replace("]", "");
            String[] splitStr = entry.split(" ");
            String date = splitStr[0];
            String status = splitStr[2];
            if (!scheduleLog.containsKey(date)) {
                if (status.equals("falls")) {
                    start = Integer.parseInt(splitStr[1].split(":")[1]);
                } else if (status.equals("wakes")) {
                    end = Integer.parseInt(splitStr[1].split(":")[1]);
                    updateMinutes(start, end);
                    scheduleLog.put(date, minutes);
                }
            } else if (scheduleLog.containsKey(date)) {
                if (status.equals("falls")) {
                    start = Integer.parseInt(splitStr[1].split(":")[1]);
                } else if (status.equals("wakes")) {
                    end = Integer.parseInt(splitStr[1].split(":")[1]);
                    updateMinutes(start, end);
                    scheduleLog.replace(date, minutes);
                }
            }
        }
    }

    private void updateMinutes(int start, int end) {
       for (int i = start; i < end; i++) {
           minutes[i] = 1;
       }
    }
}
