package com.example.vlatkopopovic.facebookphotochecker;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;


import static com.example.vlatkopopovic.facebookphotochecker.ScaleToFitWidthHeightTransform.sirina;
import static com.example.vlatkopopovic.facebookphotochecker.ScaleToFitWidthHeightTransform.visina;

public class MainActivity extends AppCompatActivity {
    boolean btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24,btn25;
         int btn_percent_1,btn_percent_2,btn_percent_3,btn_percent_4,btn_percent_5;
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14,button15,button16,button17,button18,button19,button20,button21,button22,button23,button24,button25;
    private final int IMAGE_PICKER_REQUEST = 1;
    int finalHeight, finalWidth;
    int counter = 0;
    RelativeLayout relavtive;
    ScaleToFitWidthHeightTransform sc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
Bundle b = new Bundle();

b = getIntent().getExtras();
finalWidth = b.getInt("sirina");
finalHeight = b.getInt("visina");
Uri slika = Uri.parse(b.getString("slika"));

        RelativeLayout relavtive = findViewById(R.id.layout2);
         ConstraintLayout cs = findViewById(R.id.cl);
        ViewGroup.LayoutParams kurac = cs.getLayoutParams();


        //sc = new ScaleToFitWidthHeightTransform(kurac.height,true);


        ImageView iv = findViewById(R.id.imageView);
        Picasso.with(this)
                .load(slika)
                .resize(finalWidth,finalHeight)
                //.transform(sc)
                .into(iv);




        ViewGroup.LayoutParams dimensions = relavtive.getLayoutParams();

        dimensions.width = finalWidth;

        dimensions.height = finalHeight;



        //relavtive.setLayoutParams(dimensions);

       // relavtive.requestLayout();




        showButtons();
       //
       /* int rotation = getWindowManager().getDefaultDisplay()
                .getRotation();
        // DisplayMetrics dm = new DisplayMetrics();
        // getWindowManager().getDefaultDisplay().getMetrics(dm);
        int orientation;
        CharSequence text;

        switch (rotation) {
            case Surface.ROTATION_0:
                text = "SCREEN_ORIENTATION_PORTRAIT";

                break;
            case Surface.ROTATION_90:
                text = "SCREEN_ORIENTATION_LANDSCAPE";


                break;
            case Surface.ROTATION_180:
                text = "SCREEN_ORIENTATION_REVERSE_PORTRAIT";
                break;
            case Surface.ROTATION_270:
                text = "SCREEN_ORIENTATION_REVERSE_LANDSCAPE";
                break;
            default:
                text = "SCREEN_ORIENTATION_PORTRAIT";
                break;
        }

        // CharSequence text = String.valueOf(orientation);
        Toast toast = Toast.makeText(getApplicationContext(), text,
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER | Gravity.CENTER, 10, 0);
        toast.show();*/






    }












    private int getHeightOfView(View contentview) {
        contentview.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        //contentview.getMeasuredWidth();
        return contentview.getMeasuredHeight();
    }



      public void showButtons(){

          button1 = findViewById(R.id.btn_1);
          button1.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View arg0) {

                  //System.out.println(String.valueOf(btn1));

                  if (btn1){

                      button1.setBackgroundColor(Color.TRANSPARENT);
                      button1.setText("");
                      btn1 = false;
                      btn_percent_1 = 4;

                      counter--;
                      Log.i("kita", String.valueOf(counter));

                  }else{

                      button1.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button1.setText("4%");
                      button1.setTextColor(Color.WHITE);
                      btn1 = true;
                      btn_percent_1 = 0;
                      counter++;
                      Log.i("kita", String.valueOf(counter));
                  }

              }
          });
          button2 = findViewById(R.id.btn_2);
          button2.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View arg0) {

                  System.out.println(String.valueOf(btn2));

                  if (btn2){

                      button2.setBackgroundColor(Color.TRANSPARENT);
                      button2.setText("");
                      btn2 = false;
                      btn_percent_2 = 4;
                      counter--;
                  }else{

                      button2.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button2.setText("4%");
                      button2.setTextColor(Color.WHITE);

                      btn2 = true;
                      btn_percent_2 = 0;
                      counter++;
                  }

              }
          });
          button3 = findViewById(R.id.btn_3);
          button3.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View arg0) {

                  System.out.println(String.valueOf(btn3));

                  if (btn3){

                      button3.setBackgroundColor(Color.TRANSPARENT);
                      button3.setText("");
                      btn3 = false;
                      counter--;
                  }else{

                      button3.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button3.setText("4%");
                      button3.setTextColor(Color.WHITE);
                      counter++;
                      btn3 = true;
                  }

              }
          });
          button4 = findViewById(R.id.btn_4);
          button4.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View arg0) {

                  System.out.println(String.valueOf(btn4));

                  if (btn4){

                      button4.setBackgroundColor(Color.TRANSPARENT);
                      button4.setText("");
                      btn4 = false;

                  }else{

                      button4.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button4.setText("4%");
                      button4.setTextColor(Color.WHITE);

                      btn4 = true;
                  }

              }
          });
          button5 = findViewById(R.id.btn_5);
          button5.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View arg0) {

                  System.out.println(String.valueOf(btn5));

                  if (btn5){

                      button5.setBackgroundColor(Color.TRANSPARENT);
                      button5.setText("");
                      btn5 = false;
                  }else{

                      button5.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button5.setText("4%");
                      button5.setTextColor(Color.WHITE);

                      btn5 = true;
                  }

              }
          });
          button6 = findViewById(R.id.btn_6);
          button6.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View arg0) {

                  //System.out.println(String.valueOf(btn6));

                  if (btn6){

                      button6.setBackgroundColor(Color.TRANSPARENT);
                      button6.setText("");
                      btn6 = false;
                  }else{

                      button6.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button6.setText("4%");
                      button6.setTextColor(Color.WHITE);

                      btn6 = true;
                  }

              }
          });
          button7 = findViewById(R.id.btn_7);
          button7.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View arg0) {

                  //System.out.println(String.valueOf(btn6));

                  if (btn7){

                      button7.setBackgroundColor(Color.TRANSPARENT);
                      button7.setText("");
                      btn7 = false;
                  }else{

                      button7.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button7.setText("4%");
                      button7.setTextColor(Color.WHITE);

                      btn7 = true;
                  }

              }
          });
          button8 = findViewById(R.id.btn_8);
          button8.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View arg0) {

                  //System.out.println(String.valueOf(btn6));

                  if (btn8){

                      button8.setBackgroundColor(Color.TRANSPARENT);
                      button8.setText("");
                      btn8 = false;
                  }else{

                      button8.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button8.setText("4%");
                      button8.setTextColor(Color.WHITE);

                      btn8 = true;
                  }

              }
          });
          button9 = findViewById(R.id.btn_9);
          button9.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View arg0) {

                  //System.out.println(String.valueOf(btn6));

                  if (btn9){

                      button9.setBackgroundColor(Color.TRANSPARENT);
                      button9.setText("");
                      btn9 = false;
                  }else{

                      button9.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button9.setText("4%");
                      button9.setTextColor(Color.WHITE);

                      btn9 = true;
                  }

              }
          });
          button10 = findViewById(R.id.btn_10);
          button10.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View arg0) {

                  //System.out.println(String.valueOf(btn6));

                  if (btn10){

                      button10.setBackgroundColor(Color.TRANSPARENT);
                      button10.setText("");
                      btn10 = false;
                  }else{

                      button10.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button10.setText("4%");
                      button10.setTextColor(Color.WHITE);

                      btn10 = true;
                  }

              }
          });
          button11 = findViewById(R.id.btn_11);
          button11.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View arg0) {

                  //System.out.println(String.valueOf(btn6));

                  if (btn11){

                      button11.setBackgroundColor(Color.TRANSPARENT);
                      button11.setText("");
                      btn11 = false;
                  }else{

                      button11.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button11.setText("4%");
                      button11.setTextColor(Color.WHITE);

                      btn11 = true;
                  }

              }
          });
          button12 = findViewById(R.id.btn_12);
          button12.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View arg0) {

                  //System.out.println(String.valueOf(btn6));

                  if (btn12){

                      button12.setBackgroundColor(Color.TRANSPARENT);
                      button12.setText("");
                      btn12 = false;
                  }else{

                      button12.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button12.setText("4%");
                      button12.setTextColor(Color.WHITE);

                      btn12 = true;
                  }

              }
          });
          button13 = findViewById(R.id.btn_13);
          button13.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View arg0) {

                  //System.out.println(String.valueOf(btn6));

                  if (btn13){

                      button13.setBackgroundColor(Color.TRANSPARENT);
                      button13.setText("");
                      btn13 = false;
                  }else{

                      button13.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button13.setText("4%");
                      button13.setTextColor(Color.WHITE);

                      btn13 = true;
                  }

              }
          });
          button14 = findViewById(R.id.btn_14);
          button14.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View arg0) {

                  //System.out.println(String.valueOf(btn6));

                  if (btn14){

                      button14.setBackgroundColor(Color.TRANSPARENT);
                      button14.setText("");
                      btn14 = false;
                  }else{

                      button14.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button14.setText("4%");
                      button14.setTextColor(Color.WHITE);

                      btn14 = true;
                  }

              }
          });
          button15 = findViewById(R.id.btn_15);
          button15.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View arg0) {

                  //System.out.println(String.valueOf(btn6));

                  if (btn15){

                      button15.setBackgroundColor(Color.TRANSPARENT);
                      button15.setText("");
                      btn15 = false;
                  }else{

                      button15.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button15.setText("4%");
                      button15.setTextColor(Color.WHITE);

                      btn15 = true;
                  }

              }
          });
          button16 = findViewById(R.id.btn_16);
          button16.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View arg0) {

                  //System.out.println(String.valueOf(btn6));

                  if (btn16){

                      button16.setBackgroundColor(Color.TRANSPARENT);
                      button16.setText("");
                      btn16 = false;
                  }else{

                      button16.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button16.setText("4%");
                      button16.setTextColor(Color.WHITE);

                      btn16 = true;
                  }

              }
          });
          button17 = findViewById(R.id.btn_17);
          button17.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View arg0) {

                  //System.out.println(String.valueOf(btn6));

                  if (btn17){

                      button17.setBackgroundColor(Color.TRANSPARENT);
                      button17.setText("");
                      btn17 = false;
                  }else{

                      button17.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button17.setText("4%");
                      button17.setTextColor(Color.WHITE);

                      btn17 = true;
                  }

              }
          });
          button18 = findViewById(R.id.btn_18);
          button18.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View arg0) {

                  //System.out.println(String.valueOf(btn6));

                  if (btn18){

                      button18.setBackgroundColor(Color.TRANSPARENT);
                      button18.setText("");
                      btn18 = false;
                  }else{

                      button18.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button18.setText("4%");
                      button18.setTextColor(Color.WHITE);

                      btn18 = true;
                  }

              }
          });
          button19 = findViewById(R.id.btn_19);
          button19.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View arg0) {

                  //System.out.println(String.valueOf(btn6));

                  if (btn19){

                      button19.setBackgroundColor(Color.TRANSPARENT);
                      button19.setText("");
                      btn19 = false;
                  }else{

                      button19.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button19.setText("4%");
                      button19.setTextColor(Color.WHITE);

                      btn19 = true;
                  }

              }
          });
          button20 = findViewById(R.id.btn_20);
          button20.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View arg0) {
                  //System.out.println(String.valueOf(btn6));
                  if (btn20){
                      button20.setBackgroundColor(Color.TRANSPARENT);
                      button20.setText("");
                      btn20 = false;
                  }else{
                      button20.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button20.setText("4%");
                      button20.setTextColor(Color.WHITE);
                      btn20 = true;
                  }
              }
          });
          button21 = findViewById(R.id.btn_21);
          button21.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View arg0) {
                  //System.out.println(String.valueOf(btn6));
                  if (btn21){
                      button21.setBackgroundColor(Color.TRANSPARENT);
                      button21.setText("");
                      btn21 = false;
                  }else{
                      button21.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button21.setText("4%");
                      button21.setTextColor(Color.WHITE);
                      btn21 = true;
                  }
              }
          });
          button22 = findViewById(R.id.btn_22);
          button22.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View arg0) {
                  //System.out.println(String.valueOf(btn6));
                  if (btn22){
                      button22.setBackgroundColor(Color.TRANSPARENT);
                      button22.setText("");
                      btn22 = false;
                  }else{
                      button22.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button22.setText("4%");
                      button22.setTextColor(Color.WHITE);
                      btn22 = true;
                  }
              }
          });
          button23 = findViewById(R.id.btn_23);
          button23.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View arg0) {
                  //System.out.println(String.valueOf(btn6));
                  if (btn23){
                      button23.setBackgroundColor(Color.TRANSPARENT);
                      button23.setText("");
                      btn23 = false;
                  }else{
                      button23.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button23.setText("4%");
                      button23.setTextColor(Color.WHITE);
                      btn23 = true;
                  }
              }
          });
          button24 = findViewById(R.id.btn_24);
          button24.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View arg0) {
                  //System.out.println(String.valueOf(btn6));
                  if (btn24){
                      button24.setBackgroundColor(Color.TRANSPARENT);
                      button24.setText("");
                      btn24 = false;
                  }else{
                      button24.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button24.setText("4%");
                      button24.setTextColor(Color.WHITE);
                      btn24 = true;
                  }
              }
          });
          button25 = findViewById(R.id.btn_25);
          button25.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View arg0) {
                  //System.out.println(String.valueOf(btn6));
                  if (btn25){
                      button25.setBackgroundColor(Color.TRANSPARENT);
                      button25.setText("");
                      btn25 = false;
                  }else{
                      button25.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.button_red));
                      button25.setText("4%");
                      button25.setTextColor(Color.WHITE);
                      btn25 = true;
                  }
              }
          });




      }





    }

