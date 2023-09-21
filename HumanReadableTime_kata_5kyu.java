package Codewars;

public class HumanReadableTime_kata_5kyu {
    public static void main(String[] args) {

        System.out.println(makeReadable(86399));
    }

    public static String makeReadable(int seconds) {
        int h=0;
        int min=0;
        if (seconds >= 3600){
            h = seconds/3600;
            seconds -= h*3600;
        }
        if (seconds >= 60 ){
            min = seconds/60;
            seconds -= min*60;
        }
        System.out.println("h = " + h + " min = " + min + " sec = " + seconds);
        StringBuffer result = new StringBuffer();
        if (h < 10) result.append("0" + h + ":"); else result.append(h + ":");
        if (min < 10) result.append("0" + min + ":"); else result.append(min + ":");
        if (seconds < 10) result.append("0" + seconds); else result.append(seconds);
        return result.toString();
    }
}