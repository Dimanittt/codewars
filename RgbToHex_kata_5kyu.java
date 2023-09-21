package Codewars;

import java.util.Locale;

public class RgbToHex_kata_5kyu {

    public static void main(String[] args) {
        System.out.println(rgb(125,-3,152));
    }

    public static String rgb(int r, int g, int b) {
        String rs = Integer.toHexString(Math.abs(r)).toUpperCase(Locale.ROOT);
        String gs = Integer.toHexString(Math.abs(g)).toUpperCase(Locale.ROOT);
        String bs = Integer.toHexString(Math.abs(b)).toUpperCase(Locale.ROOT);
        StringBuffer stringBuffer = new StringBuffer();
        if (rs.length() == 1 && r <= 255 && r > 0){
            stringBuffer.append("0");
            stringBuffer.append(rs);
        } else if (r <= 0 ) stringBuffer.append("00");
        else if (r > 255) stringBuffer.append("FF");
        else stringBuffer.append(rs);
        if (gs.length() == 1 && g <= 255 && g > 0){
            stringBuffer.append("0");
            stringBuffer.append(gs);
        } else if (g <= 0 ) stringBuffer.append("00");
        else if (g > 255) stringBuffer.append("FF");
        else stringBuffer.append(gs);
        if (bs.length() == 1 && b <= 255 && b > 0){
            stringBuffer.append("0");
            stringBuffer.append(bs);
        } else if (b <= 0 ) stringBuffer.append("00");
        else if (b > 255) stringBuffer.append("FF");
        else stringBuffer.append(bs);
        String result = stringBuffer.toString();
        System.out.println(rs + " " + gs + " " + bs);
        return result;
    }
}