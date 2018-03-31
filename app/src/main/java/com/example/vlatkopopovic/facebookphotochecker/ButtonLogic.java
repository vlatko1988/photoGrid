package com.example.vlatkopopovic.facebookphotochecker;

import android.graphics.Color;
import android.util.Log;
import android.widget.Button;

public class ButtonLogic {

    static int btn_percent_1;
    static int counter = 0;

    public static void buttonOff(Button button) {
        button.setBackgroundColor(Color.TRANSPARENT);
        button.setText("");
        btn_percent_1 = 2;
        counter -= 2;
        Log.i("kita", String.valueOf(counter));
    }

    public static void buttonOn(Button button) {
        button.setBackgroundResource(R.color.button_red);
        button.setText("2%");
        button.setTextColor(Color.WHITE);
        btn_percent_1 = 0;
        counter += 2;
        Log.i("kita", String.valueOf(counter));
    }
}
