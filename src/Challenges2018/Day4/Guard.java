package Challenges2018.Day4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Guard Class
 * This was made in order to keep things a little more organized.
 * @Author Afaq Anwar
 * @Version 05/15/2019
 */
public class Guard {
    private int id;
    private HashMap<String, int[]> scheduleLog;
    private int[] minutes;
    private int mostFrequent;

    public Guard(int id) {
        this.id = id;
        scheduleLog = new HashMap<>();
        minutes = new int[60];
        mostFrequent = 0;
    }

    public int getId() { return this.id; }

    /**
     * Updates the HashMap of Arrays that contain the schedules based upon a given List of logs.
     * @param log ArrayList of Strings that contain all activities of the current Guard.
     */
    public void updateMinutes(ArrayList<String> log) {
        int start = 0;
        int end = 0;
        for (String entry : log) {
            String altered = entry.replace("[", "").replace("]", "");
            String[] splitStr = altered.split(" ");
            String date = splitStr[0];
            String status = splitStr[2];
            if (!scheduleLog.containsKey(date)) {
                minutes = new int[60];
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

    public int calculateTotalSleep() {
        int total = 0;
        for (int[] log : scheduleLog.values()) {
            for (int i : log) {
                if (i == 1) {
                    total++;
                }
            }
        }
        return total;
    }

    /**
     * @return HashMap that represents the amount a Guard has been asleep at each specific minute.
     */
    public HashMap<Integer, Integer> getMinuteMap() {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] log : scheduleLog.values()) {
            for (int i = 0; i < log.length; i++) {
                if (log[i] == 1) {
                    if (!map.containsKey(i)) {
                        map.put(i, 1);
                    } else {
                        int current = map.get(i);
                        current++;
                        map.replace(i, current);
                    }
                }
            }
        }
        return map;
    }

    /**
     * The most frequent minute is the one where the Guard is asleep the most.
     * Example:
     * * * * * * * * * * *
     * 01 02 03 04 05 06 07
     * 0  1  1  0  0  0  0
     * 1  1  1  0  0  0  0
     * 0  1  0  0  0  0  0
     * * * * * * * * * * *
     * In this case the third minute is the most frequent minute.
     * @return The minute with the most sleep.
     */
    public int getMostFrequentMinute() {
        HashMap<Integer, Integer> minuteMap = getMinuteMap();
        int greatest = 0;
        for (int key : minuteMap.keySet()) {
            if (minuteMap.get(key) > greatest) {
                mostFrequent = key;
                greatest = minuteMap.get(key);
            }
        }
        return this.mostFrequent;
    }
}
