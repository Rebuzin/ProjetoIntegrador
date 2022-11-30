package com.example.appmedia.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Util {


    public static String formatDecimaltoString(Double valor) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return decimalFormat.format(valor);
    }

}
