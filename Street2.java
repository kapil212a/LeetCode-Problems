public class Street2 {
    //////////// Angle Between Hands Of Clock \\\\\\\\\\\\\\\\
    
    public static double angleClock(int hour, int minutes) {
        double hourAngle = 30 * hour + 0.5 * minutes;
        double minAngle = 6 * minutes;

        double angle = Math.abs(hourAngle - minAngle);

        return Math.min(angle , 360 - angle);
    }

    public static void main(String[] args) {
        int hour = 12;
        int minutes = 30;
        System.out.println(angleClock(hour, minutes));
    }

}
