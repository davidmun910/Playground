import java.util.ArrayList;
import java.util.List;
import java.util.Arrays; 

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int minutesList[] = new int[timePoints.size()];

        for (int i = 0; i < timePoints.size(); ++i) {
            String time = timePoints.get(i);
            int minutes = Integer.parseInt(time.substring(time.indexOf(':') + 1))
                        + Integer.parseInt(time.substring(0, time.indexOf(':'))) * 60;
            minutesList[i] = minutes;
        }

        Arrays.sort(minutesList);

        int minDifference = Integer.MAX_VALUE;

        for (int i = 1; i < minutesList.length; ++i) {
            minDifference = Math.min(minDifference, minutesList[i] - minutesList[i - 1]);
        }

        int firstToLastDiff = 1440 - minutesList[minutesList.length - 1] + minutesList[0];

        return Math.min(minDifference, firstToLastDiff);
    }
}

class Q539 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("05:00");
        timePoints.add("22:59");
        System.out.println(sol.findMinDifference(timePoints));
    }
}