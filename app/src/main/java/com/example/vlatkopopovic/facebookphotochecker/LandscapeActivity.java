package com.example.vlatkopopovic.facebookphotochecker;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class LandscapeActivity extends AppCompatActivity {
    boolean btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25,
            btn26, btn27, btn28, btn29, btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39, btn40, btn41, btn42, btn43, btn44, btn45, btn46, btn47, btn48, btn49, btn50,
            btn51, btn52, btn53, btn54, btn55, btn56, btn57, btn58, btn59, btn60, btn61, btn62, btn63, btn64, btn65, btn66, btn67, btn68, btn69, btn70, btn71, btn72, btn73, btn74, btn75,
            btn76, btn77, btn78, btn79, btn80, btn81, btn82, btn83, btn84, btn85, btn86, btn87, btn88, btn89, btn90, btn91, btn92, btn93, btn94, btn95, btn96, btn97, btn98, btn99, btn100;

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19, button20, button21, button22, button23, button24, button25,
            button26, button27, button28, button29, button30, button31, button32, button33, button34, button35, button36, button37, button38, button39, button40, button41, button42, button43, button44, button45, button46, button47, button48, button49, button50,
            button51, button52, button53, button54, button55, button56, button57, button58, button59, button60, button61, button62, button63, button64, button65, button66, button67, button68, button69, button70, button71, button72, button73, button74, button75,
            button76, button77, button78, button79, button80, button81, button82, button83, button84, button85, button86, button87, button88, button89, button90, button91, button92, button93, button94, button95, button96, button97, button98, button99, button100;

    int finalHeight, finalWidth;
    int counter = 0;
    int actionBarHeight;
    Uri slika;
    ConstraintLayout cs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_landscape);
        ActionBar actionBar = getSupportActionBar();

        //actionBar.setTitle("");
//        if (actionBar != null) {
//            actionBar.hide();
//        }



        TypedValue tv = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
        }
        Bundle b = getIntent().getExtras();

        if (b != null) {
            finalWidth = b.getInt("sirina");
        }
        if (b != null) {
            finalHeight = b.getInt("visina") - actionBarHeight;
        }
        if (b != null) {
            slika = Uri.parse(b.getString("slika"));
        }

        RelativeLayout relavtive = findViewById(R.id.layout2);
        cs = findViewById(R.id.cl);

//        MovableFloatingActionButton mv = findViewById(R.id.fab);
//        mv.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (ButtonLogic.counter > 20){
//
//                    showDialogAlert();
//                    // Toast.makeText(PortraitActivity.this,"This photo contains more than 20% text",Toast.LENGTH_LONG).show();
//
//
//                }else{
//                    Intent shareIntent = new Intent();
//                    shareIntent.setAction(Intent.ACTION_SEND);
//                    shareIntent.putExtra(Intent.EXTRA_STREAM, slika);
//                    shareIntent.setType("image/jpeg");
//                    startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.share)));
//
//                }
//
//            }
//        });

        ImageView iv = findViewById(R.id.imageView);
        Picasso.with(this)
                .load(slika)
                .resize(finalWidth, finalHeight)
                .into(iv);

        ViewGroup.LayoutParams dimensions = relavtive.getLayoutParams();
        dimensions.width = finalWidth;
        dimensions.height = finalHeight;
        showButtons();
        if (counter > 20) {
            Toast.makeText(this, "Ne moze bre!", Toast.LENGTH_LONG).show();
        }
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

    private void snack() {
        Snackbar snackbar = Snackbar
                .make(cs, "Text takes: " + String.valueOf(ButtonLogic.counter) + "%" + " of photo", Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    @Override
    public void onBackPressed() {

        ButtonLogic.counter = 0;
        Intent intent = new Intent(this, StartActivity.class);


        startActivity(intent);
        finish();
    }

    public void showButtons() {

        button1 = findViewById(R.id.btn_1);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                System.out.println(String.valueOf(btn1));
                if (btn1) {
                    ButtonLogic.buttonOff(button1);
                    btn1 = false;
                } else {
                    ButtonLogic.buttonOn(button1);
                    btn1 = true;
                }
                snack();
            }
        });
        button2 = findViewById(R.id.btn_2);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn2));
                if (btn2) {
                    ButtonLogic.buttonOff(button2);
                    btn2 = false;
                } else {
                    ButtonLogic.buttonOn(button2);
                    btn2 = true;
                }
                snack();
            }
        });
        button3 = findViewById(R.id.btn_3);
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn3));
                if (btn3) {
                    ButtonLogic.buttonOff(button3);
                    btn3 = false;
                } else {
                    ButtonLogic.buttonOn(button3);
                    btn3 = true;
                }
                snack();

            }
        });
        button4 = findViewById(R.id.btn_4);
        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn4));
                if (btn4) {
                    ButtonLogic.buttonOff(button4);
                    btn4 = false;
                } else {
                    ButtonLogic.buttonOn(button4);
                    btn4 = true;
                }
                snack();

            }
        });
        button5 = findViewById(R.id.btn_5);
        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn5));
                if (btn5) {
                    ButtonLogic.buttonOff(button5);
                    btn5 = false;
                } else {
                    ButtonLogic.buttonOn(button5);
                    btn5 = true;
                }
                snack();

            }
        });
        button6 = findViewById(R.id.btn_6);
        button6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                System.out.println(String.valueOf(btn6));
                if (btn6) {
                    ButtonLogic.buttonOff(button6);
                    btn6 = false;
                } else {
                    ButtonLogic.buttonOn(button6);
                    btn6 = true;
                }
                snack();
            }

        });
        button7 = findViewById(R.id.btn_7);
        button7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn7));
                if (btn7) {
                    ButtonLogic.buttonOff(button7);
                    btn7 = false;
                } else {
                    ButtonLogic.buttonOn(button7);
                    btn7 = true;
                }
                snack();

            }
        });
        button8 = findViewById(R.id.btn_8);
        button8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn8));
                if (btn8) {
                    ButtonLogic.buttonOff(button8);
                    btn8 = false;
                } else {
                    ButtonLogic.buttonOn(button8);
                    btn8 = true;
                }
                snack();

            }
        });
        button9 = findViewById(R.id.btn_9);
        button9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn9));
                if (btn9) {
                    ButtonLogic.buttonOff(button9);
                    btn9 = false;
                } else {
                    ButtonLogic.buttonOn(button9);
                    btn9 = true;
                }
                snack();

            }
        });
        button10 = findViewById(R.id.btn_10);
        button10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn10));
                if (btn10) {
                    ButtonLogic.buttonOff(button10);
                    btn10 = false;
                } else {
                    ButtonLogic.buttonOn(button10);
                    btn10 = true;
                }
                snack();

            }
        });
        button11 = findViewById(R.id.btn_11);
        button11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn11));
                if (btn11) {
                    ButtonLogic.buttonOff(button11);
                    btn11 = false;
                } else {
                    ButtonLogic.buttonOn(button11);
                    btn11 = true;
                }
                snack();

            }
        });
        button12 = findViewById(R.id.btn_12);
        button12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn12));
                if (btn12) {
                    ButtonLogic.buttonOff(button12);
                    btn12 = false;
                } else {
                    ButtonLogic.buttonOn(button12);
                    btn12 = true;
                }
                snack();

            }
        });
        button13 = findViewById(R.id.btn_13);
        button13.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn13));
                if (btn13) {
                    ButtonLogic.buttonOff(button13);
                    btn13 = false;
                } else {
                    ButtonLogic.buttonOn(button13);
                    btn13 = true;
                }
                snack();

            }
        });
        button14 = findViewById(R.id.btn_14);
        button14.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn14));
                if (btn14) {
                    ButtonLogic.buttonOff(button14);
                    btn14 = false;
                } else {
                    ButtonLogic.buttonOn(button14);
                    btn14 = true;
                }
                snack();

            }
        });
        button15 = findViewById(R.id.btn_15);
        button15.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn15));
                if (btn15) {
                    ButtonLogic.buttonOff(button15);
                    btn15 = false;
                } else {
                    ButtonLogic.buttonOn(button15);
                    btn15 = true;
                }
                snack();

            }
        });
        button16 = findViewById(R.id.btn_16);
        button16.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn16));
                if (btn16) {
                    ButtonLogic.buttonOff(button16);
                    btn16 = false;
                } else {
                    ButtonLogic.buttonOn(button16);
                    btn16 = true;
                }
                snack();

            }
        });
        button17 = findViewById(R.id.btn_17);
        button17.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn17));
                if (btn17) {
                    ButtonLogic.buttonOff(button17);
                    btn17 = false;
                } else {
                    ButtonLogic.buttonOn(button17);
                    btn17 = true;
                }
                snack();

            }
        });
        button18 = findViewById(R.id.btn_18);
        button18.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn18));
                if (btn18) {
                    ButtonLogic.buttonOff(button18);
                    btn18 = false;
                } else {
                    ButtonLogic.buttonOn(button18);
                    btn18 = true;
                }
                snack();

            }
        });
        button19 = findViewById(R.id.btn_19);
        button19.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                System.out.println(String.valueOf(btn19));
                if (btn19) {
                    ButtonLogic.buttonOff(button19);
                    btn19 = false;
                } else {
                    ButtonLogic.buttonOn(button19);
                    btn19 = true;
                }
                snack();

            }
        });
        button20 = findViewById(R.id.btn_20);
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                System.out.println(String.valueOf(btn20));
                if (btn20) {
                    ButtonLogic.buttonOff(button20);
                    btn20 = false;
                } else {
                    ButtonLogic.buttonOn(button20);
                    btn20 = true;
                }
                snack();
            }
        });
        button21 = findViewById(R.id.btn_21);
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                System.out.println(String.valueOf(btn21));
                if (btn21) {
                    ButtonLogic.buttonOff(button21);
                    btn21 = false;
                } else {
                    ButtonLogic.buttonOn(button21);
                    btn21 = true;
                }
                snack();
            }
        });
        button22 = findViewById(R.id.btn_22);
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                System.out.println(String.valueOf(btn22));
                if (btn22) {
                    ButtonLogic.buttonOff(button22);
                    btn22 = false;
                } else {
                    ButtonLogic.buttonOn(button22);
                    btn22 = true;
                }
                snack();
            }
        });
        button23 = findViewById(R.id.btn_23);
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                System.out.println(String.valueOf(btn23));
                if (btn23) {
                    ButtonLogic.buttonOff(button23);
                    btn23 = false;
                } else {
                    ButtonLogic.buttonOn(button23);
                    btn23 = true;
                }
                snack();
            }
        });
        button24 = findViewById(R.id.btn_24);
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                System.out.println(String.valueOf(btn24));
                if (btn24) {
                    ButtonLogic.buttonOff(button24);
                    btn24 = false;
                } else {
                    ButtonLogic.buttonOn(button24);
                    btn24 = true;
                }
                snack();
            }
        });
        button25 = findViewById(R.id.btn_25);
        button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                System.out.println(String.valueOf(btn25));
                if (btn25) {
                    ButtonLogic.buttonOff(button25);
                    btn25 = false;
                } else {
                    ButtonLogic.buttonOn(button25);
                    btn25 = true;
                }
                snack();
            }
        });
        button26 = findViewById(R.id.btn_26);
        button26.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn26));
                if (btn26) {
                    ButtonLogic.buttonOff(button26);
                    btn26 = false;
                } else {
                    ButtonLogic.buttonOn(button26);
                    btn26 = true;
                }
                snack();
            }
        });
        button27 = findViewById(R.id.btn_27);
        button27.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn27));
                if (btn27) {
                    ButtonLogic.buttonOff(button27);
                    btn27 = false;
                } else {
                    ButtonLogic.buttonOn(button27);
                    btn27 = true;
                }
                snack();
            }
        });
        button28 = findViewById(R.id.btn_28);
        button28.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn28));
                if (btn28) {
                    ButtonLogic.buttonOff(button28);
                    btn28 = false;
                } else {
                    ButtonLogic.buttonOn(button28);
                    btn28 = true;
                }
                snack();
            }
        });
        button29 = findViewById(R.id.btn_29);
        button29.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn29));
                if (btn29) {
                    ButtonLogic.buttonOff(button29);
                    btn29 = false;
                } else {
                    ButtonLogic.buttonOn(button29);
                    btn29 = true;
                }
                snack();
            }
        });
        button30 = findViewById(R.id.btn_30);
        button30.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn30));
                if (btn30) {
                    ButtonLogic.buttonOff(button30);
                    btn30 = false;
                } else {
                    ButtonLogic.buttonOn(button30);
                    btn30 = true;
                }
                snack();
            }
        });
        button31 = findViewById(R.id.btn_31);
        button31.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn31));
                if (btn31) {
                    ButtonLogic.buttonOff(button31);
                    btn31 = false;
                } else {
                    ButtonLogic.buttonOn(button31);
                    btn31 = true;
                }
                snack();
            }
        });
        button32 = findViewById(R.id.btn_32);
        button32.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn32));
                if (btn32) {
                    ButtonLogic.buttonOff(button32);
                    btn32 = false;
                } else {
                    ButtonLogic.buttonOn(button32);
                    btn32 = true;
                }
                snack();
            }
        });
        button33 = findViewById(R.id.btn_33);
        button33.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn33));
                if (btn33) {
                    ButtonLogic.buttonOff(button33);
                    btn33 = false;
                } else {
                    ButtonLogic.buttonOn(button33);
                    btn33 = true;
                }
                snack();
            }
        });
        button34 = findViewById(R.id.btn_34);
        button34.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn34));
                if (btn34) {
                    ButtonLogic.buttonOff(button34);
                    btn34 = false;
                } else {
                    ButtonLogic.buttonOn(button34);
                    btn34 = true;
                }
                snack();
            }
        });
        button35 = findViewById(R.id.btn_35);
        button35.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn35));
                if (btn35) {
                    ButtonLogic.buttonOff(button35);
                    btn35 = false;
                } else {
                    ButtonLogic.buttonOn(button35);
                    btn35 = true;
                }
                snack();
            }
        });

        button36 = findViewById(R.id.btn_36);
        button36.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn36));
                if (btn36) {
                    ButtonLogic.buttonOff(button36);
                    btn36 = false;
                } else {
                    ButtonLogic.buttonOn(button36);
                    btn36 = true;
                }
                snack();
            }
        });
        button37 = findViewById(R.id.btn_37);
        button37.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn37));
                if (btn37) {
                    ButtonLogic.buttonOff(button37);
                    btn37 = false;
                } else {
                    ButtonLogic.buttonOn(button37);
                    btn37 = true;
                }
                snack();
            }
        });
        button38 = findViewById(R.id.btn_38);
        button38.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn38));
                if (btn38) {
                    ButtonLogic.buttonOff(button38);
                    btn38 = false;
                } else {
                    ButtonLogic.buttonOn(button38);
                    btn38 = true;
                }
                snack();
            }
        });
        button39 = findViewById(R.id.btn_39);
        button39.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn39));
                if (btn39) {
                    ButtonLogic.buttonOff(button39);
                    btn39 = false;
                } else {
                    ButtonLogic.buttonOn(button39);
                    btn39 = true;
                }
                snack();
            }
        });
        button40 = findViewById(R.id.btn_40);
        button40.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn40));
                if (btn40) {
                    ButtonLogic.buttonOff(button40);
                    btn40 = false;
                } else {
                    ButtonLogic.buttonOn(button40);
                    btn40 = true;
                }
                snack();
            }
        });
        button41 = findViewById(R.id.btn_41);
        button41.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn41));
                if (btn41) {
                    ButtonLogic.buttonOff(button41);
                    btn41 = false;
                } else {
                    ButtonLogic.buttonOn(button41);
                    btn41 = true;
                }
                snack();

            }
        });
        button42 = findViewById(R.id.btn_42);
        button42.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn42));
                if (btn42) {
                    ButtonLogic.buttonOff(button42);
                    btn42 = false;
                } else {
                    ButtonLogic.buttonOn(button42);
                    btn42 = true;
                }
                snack();

            }
        });
        button43 = findViewById(R.id.btn_43);
        button43.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn43));
                if (btn43) {
                    ButtonLogic.buttonOff(button43);
                    btn43 = false;
                } else {
                    ButtonLogic.buttonOn(button43);
                    btn43 = true;
                }
                snack();

            }
        });
        button44 = findViewById(R.id.btn_44);
        button44.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn44));
                if (btn44) {
                    ButtonLogic.buttonOff(button44);
                    btn44 = false;
                } else {
                    ButtonLogic.buttonOn(button44);
                    btn44 = true;
                }
                snack();

            }
        });
        button45 = findViewById(R.id.btn_45);
        button45.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn45));
                if (btn45) {
                    ButtonLogic.buttonOff(button45);
                    btn45 = false;
                } else {
                    ButtonLogic.buttonOn(button45);
                    btn45 = true;
                }
                snack();

            }
        });
        button46 = findViewById(R.id.btn_46);
        button46.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn46));
                if (btn46) {
                    ButtonLogic.buttonOff(button46);
                    btn46 = false;
                } else {
                    ButtonLogic.buttonOn(button46);
                    btn46 = true;
                }
                snack();

            }
        });
        button47 = findViewById(R.id.btn_47);
        button47.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn47));
                if (btn47) {
                    ButtonLogic.buttonOff(button47);
                    btn47 = false;
                } else {
                    ButtonLogic.buttonOn(button47);
                    btn47 = true;
                }
                snack();

            }
        });
        button48 = findViewById(R.id.btn_48);
        button48.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn48));
                if (btn48) {
                    ButtonLogic.buttonOff(button48);
                    btn48 = false;
                } else {
                    ButtonLogic.buttonOn(button48);
                    btn48 = true;
                }
                snack();

            }
        });
        button49 = findViewById(R.id.btn_49);
        button49.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn49));
                if (btn49) {
                    ButtonLogic.buttonOff(button49);
                    btn49 = false;
                } else {
                    ButtonLogic.buttonOn(button49);
                    btn49 = true;
                }
                snack();

            }
        });
        button50 = findViewById(R.id.btn_50);
        button50.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn50));
                if (btn50) {
                    ButtonLogic.buttonOff(button50);
                    btn50 = false;
                } else {
                    ButtonLogic.buttonOn(button50);
                    btn50 = true;
                }
                snack();

            }
        });
        button51 = findViewById(R.id.btn_51);
        button51.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                System.out.println(String.valueOf(btn51));
                if (btn51) {
                    ButtonLogic.buttonOff(button51);
                    btn50 = false;
                } else {
                    ButtonLogic.buttonOn(button51);
                    btn51 = true;
                }
                snack();

            }
        });
        button52 = findViewById(R.id.btn_52);
        button52.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn52) {
                    ButtonLogic.buttonOff(button52);
                    btn52 = false;
                } else {
                    ButtonLogic.buttonOn(button52);
                    btn52 = true;
                }
                snack();

            }
        });
        button53 = findViewById(R.id.btn_53);
        button53.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn53) {
                    ButtonLogic.buttonOff(button53);
                    btn53 = false;
                } else {
                    ButtonLogic.buttonOn(button53);
                    btn53 = true;
                }
                snack();

            }
        });
        button54 = findViewById(R.id.btn_54);
        button54.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn54) {
                    ButtonLogic.buttonOff(button54);
                    btn54 = false;
                } else {
                    ButtonLogic.buttonOn(button54);
                    btn54 = true;
                }
                snack();

            }
        });
        button54 = findViewById(R.id.btn_54);
        button54.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn54) {
                    ButtonLogic.buttonOff(button54);
                    btn54 = false;
                } else {
                    ButtonLogic.buttonOn(button54);
                    btn54 = true;
                }
                snack();

            }
        });
        button55 = findViewById(R.id.btn_55);
        button55.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn55) {
                    ButtonLogic.buttonOff(button55);
                    btn55 = false;
                } else {
                    ButtonLogic.buttonOn(button55);
                    btn55 = true;
                }
                snack();

            }
        });
        button56 = findViewById(R.id.btn_56);
        button56.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn56) {
                    ButtonLogic.buttonOff(button56);
                    btn56 = false;
                } else {
                    ButtonLogic.buttonOn(button56);
                    btn56= true;
                }
                snack();

            }
        });
        button57 = findViewById(R.id.btn_57);
        button57.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn57) {
                    ButtonLogic.buttonOff(button57);
                    btn57 = false;
                } else {
                    ButtonLogic.buttonOn(button57);
                    btn57 = true;
                }
                snack();

            }
        });
        button58 = findViewById(R.id.btn_58);
        button58.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn58) {
                    ButtonLogic.buttonOff(button58);
                    btn58 = false;
                } else {
                    ButtonLogic.buttonOn(button58);
                    btn58 = true;
                }
                snack();

            }
        });
        button59 = findViewById(R.id.btn_59);
        button59.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn59) {
                    ButtonLogic.buttonOff(button59);
                    btn59 = false;
                } else {
                    ButtonLogic.buttonOn(button59);
                    btn59 = true;
                }
                snack();

            }
        });
        button60 = findViewById(R.id.btn_60);
        button60.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn60) {
                    ButtonLogic.buttonOff(button60);
                    btn60 = false;
                } else {
                    ButtonLogic.buttonOn(button60);
                    btn60 = true;
                }
                snack();

            }
        });
        button61 = findViewById(R.id.btn_61);
        button61.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn61) {
                    ButtonLogic.buttonOff(button61);
                    btn61 = false;
                } else {
                    ButtonLogic.buttonOn(button61);
                    btn61 = true;
                }
                snack();

            }
        });
        button62 = findViewById(R.id.btn_62);
        button62.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn62) {
                    ButtonLogic.buttonOff(button62);
                    btn62 = false;
                } else {
                    ButtonLogic.buttonOn(button62);
                    btn62 = true;
                }
                snack();

            }
        });
        button63 = findViewById(R.id.btn_63);
        button63.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn63) {
                    ButtonLogic.buttonOff(button63);
                    btn63 = false;
                } else {
                    ButtonLogic.buttonOn(button63);
                    btn63 = true;
                }
                snack();

            }
        });
        button64 = findViewById(R.id.btn_64);
        button64.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn64) {
                    ButtonLogic.buttonOff(button64);
                    btn64 = false;
                } else {
                    ButtonLogic.buttonOn(button64);
                    btn64 = true;
                }
                snack();

            }
        });
        button65 = findViewById(R.id.btn_65);
        button65.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn65) {
                    ButtonLogic.buttonOff(button65);
                    btn65 = false;
                } else {
                    ButtonLogic.buttonOn(button65);
                    btn65 = true;
                }
                snack();

            }
        });
        button66 = findViewById(R.id.btn_66);
        button66.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn66) {
                    ButtonLogic.buttonOff(button66);
                    btn66 = false;
                } else {
                    ButtonLogic.buttonOn(button66);
                    btn66 = true;
                }
                snack();

            }
        });
        button67 = findViewById(R.id.btn_67);
        button67.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn67) {
                    ButtonLogic.buttonOff(button67);
                    btn67 = false;
                } else {
                    ButtonLogic.buttonOn(button67);
                    btn67 = true;
                }
                snack();

            }
        });
        button68 = findViewById(R.id.btn_68);
        button68.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn68) {
                    ButtonLogic.buttonOff(button68);
                    btn68 = false;
                } else {
                    ButtonLogic.buttonOn(button68);
                    btn68 = true;
                }
                snack();

            }
        });
        button69 = findViewById(R.id.btn_69);
        button69.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn69) {
                    ButtonLogic.buttonOff(button69);
                    btn69 = false;
                } else {
                    ButtonLogic.buttonOn(button69);
                    btn69 = true;
                }
                snack();

            }
        });
        button70 = findViewById(R.id.btn_70);
        button70.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn70) {
                    ButtonLogic.buttonOff(button70);
                    btn70 = false;
                } else {
                    ButtonLogic.buttonOn(button70);
                    btn70 = true;
                }
                snack();

            }
        });
        button71 = findViewById(R.id.btn_71);
        button71.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn71) {
                    ButtonLogic.buttonOff(button71);
                    btn71 = false;
                } else {
                    ButtonLogic.buttonOn(button71);
                    btn71 = true;
                }
                snack();

            }
        });
        button72 = findViewById(R.id.btn_72);
        button72.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn72) {
                    ButtonLogic.buttonOff(button72);
                    btn72 = false;
                } else {
                    ButtonLogic.buttonOn(button72);
                    btn72 = true;
                }
                snack();

            }
        });
        button73 = findViewById(R.id.btn_73);
        button73.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn73) {
                    ButtonLogic.buttonOff(button73);
                    btn73 = false;
                } else {
                    ButtonLogic.buttonOn(button73);
                    btn73 = true;
                }
                snack();

            }
        });
        button74 = findViewById(R.id.btn_74);
        button74.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn74) {
                    ButtonLogic.buttonOff(button74);
                    btn74 = false;
                } else {
                    ButtonLogic.buttonOn(button74);
                    btn74 = true;
                }
                snack();

            }
        });
        button75 = findViewById(R.id.btn_75);
        button75.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn75) {
                    ButtonLogic.buttonOff(button75);
                    btn75 = false;
                } else {
                    ButtonLogic.buttonOn(button75);
                    btn75 = true;
                }
                snack();

            }
        });
        button76 = findViewById(R.id.btn_76);
        button76.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn76) {
                    ButtonLogic.buttonOff(button76);
                    btn76 = false;
                } else {
                    ButtonLogic.buttonOn(button76);
                    btn76 = true;
                }
                snack();

            }
        });
        button77 = findViewById(R.id.btn_77);
        button77.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn77) {
                    ButtonLogic.buttonOff(button77);
                    btn77 = false;
                } else {
                    ButtonLogic.buttonOn(button77);
                    btn77 = true;
                }
                snack();

            }
        });
        button78 = findViewById(R.id.btn_78);
        button78.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn78) {
                    ButtonLogic.buttonOff(button78);
                    btn78 = false;
                } else {
                    ButtonLogic.buttonOn(button78);
                    btn78 = true;
                }
                snack();

            }
        });
        button79 = findViewById(R.id.btn_79);
        button79.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn79) {
                    ButtonLogic.buttonOff(button79);
                    btn79 = false;
                } else {
                    ButtonLogic.buttonOn(button79);
                    btn79 = true;
                }
                snack();

            }
        });
        button80 = findViewById(R.id.btn_80);
        button80.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn80) {
                    ButtonLogic.buttonOff(button80);
                    btn80 = false;
                } else {
                    ButtonLogic.buttonOn(button80);
                    btn80 = true;
                }
                snack();

            }
        });
        button81 = findViewById(R.id.btn_81);
        button81.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn81) {
                    ButtonLogic.buttonOff(button81);
                    btn81 = false;
                } else {
                    ButtonLogic.buttonOn(button81);
                    btn81 = true;
                }
                snack();

            }
        });
        button82 = findViewById(R.id.btn_82);
        button82.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn82) {
                    ButtonLogic.buttonOff(button82);
                    btn82 = false;
                } else {
                    ButtonLogic.buttonOn(button82);
                    btn82 = true;
                }
                snack();

            }
        });
        button83 = findViewById(R.id.btn_83);
        button83.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn83) {
                    ButtonLogic.buttonOff(button83);
                    btn83 = false;
                } else {
                    ButtonLogic.buttonOn(button83);
                    btn83 = true;
                }
                snack();

            }
        });
        button84 = findViewById(R.id.btn_84);
        button84.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn84) {
                    ButtonLogic.buttonOff(button84);
                    btn84 = false;
                } else {
                    ButtonLogic.buttonOn(button84);
                    btn84 = true;
                }
                snack();

            }
        });
        button85 = findViewById(R.id.btn_85);
        button85.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn85) {
                    ButtonLogic.buttonOff(button85);
                    btn85 = false;
                } else {
                    ButtonLogic.buttonOn(button85);
                    btn85 = true;
                }
                snack();

            }
        });
        button86 = findViewById(R.id.btn_86);
        button86.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn86) {
                    ButtonLogic.buttonOff(button86);
                    btn86 = false;
                } else {
                    ButtonLogic.buttonOn(button86);
                    btn86= true;
                }
                snack();

            }
        });
        button87 = findViewById(R.id.btn_87);
        button87.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn87) {
                    ButtonLogic.buttonOff(button87);
                    btn87 = false;
                } else {
                    ButtonLogic.buttonOn(button87);
                    btn87 = true;
                }
                snack();

            }
        });
        button88 = findViewById(R.id.btn_88);
        button88.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn88) {
                    ButtonLogic.buttonOff(button88);
                    btn88 = false;
                } else {
                    ButtonLogic.buttonOn(button88);
                    btn88 = true;
                }
                snack();

            }
        });
        button89 = findViewById(R.id.btn_89);
        button89.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn89) {
                    ButtonLogic.buttonOff(button89);
                    btn89 = false;
                } else {
                    ButtonLogic.buttonOn(button89);
                    btn89 = true;
                }
                snack();

            }
        });
        button90 = findViewById(R.id.btn_90);
        button90.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn90) {
                    ButtonLogic.buttonOff(button90);
                    btn90 = false;
                } else {
                    ButtonLogic.buttonOn(button90);
                    btn90 = true;
                }
                snack();

            }
        });
        button91 = findViewById(R.id.btn_91);
        button91.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn91) {
                    ButtonLogic.buttonOff(button91);
                    btn91 = false;
                } else {
                    ButtonLogic.buttonOn(button91);
                    btn91 = true;
                }
                snack();

            }
        });
        button92 = findViewById(R.id.btn_92);
        button92.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn92) {
                    ButtonLogic.buttonOff(button92);
                    btn92 = false;
                } else {
                    ButtonLogic.buttonOn(button92);
                    btn92 = true;
                }
                snack();

            }
        });
        button93 = findViewById(R.id.btn_93);
        button93.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn93) {
                    ButtonLogic.buttonOff(button93);
                    btn93 = false;
                } else {
                    ButtonLogic.buttonOn(button93);
                    btn93 = true;
                }
                snack();

            }
        });
        button94 = findViewById(R.id.btn_94);
        button94.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn94) {
                    ButtonLogic.buttonOff(button94);
                    btn94 = false;
                } else {
                    ButtonLogic.buttonOn(button94);
                    btn94 = true;
                }
                snack();

            }
        });
        button95 = findViewById(R.id.btn_95);
        button95.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn95) {
                    ButtonLogic.buttonOff(button95);
                    btn95 = false;
                } else {
                    ButtonLogic.buttonOn(button95);
                    btn95 = true;
                }
                snack();

            }
        });
        button96 = findViewById(R.id.btn_96);
        button96.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn96) {
                    ButtonLogic.buttonOff(button96);
                    btn96 = false;
                } else {
                    ButtonLogic.buttonOn(button96);
                    btn96 = true;
                }
                snack();

            }
        });
        button97 = findViewById(R.id.btn_97);
        button97.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn97) {
                    ButtonLogic.buttonOff(button97);
                    btn97 = false;
                } else {
                    ButtonLogic.buttonOn(button97);
                    btn97 = true;
                }
                snack();

            }
        });
        button98 = findViewById(R.id.btn_98);
        button98.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn98) {
                    ButtonLogic.buttonOff(button98);
                    btn98 = false;
                } else {
                    ButtonLogic.buttonOn(button98);
                    btn98 = true;
                }
                snack();

            }
        });
        button99 = findViewById(R.id.btn_99);
        button99.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn99) {
                    ButtonLogic.buttonOff(button99);
                    btn99 = false;
                } else {
                    ButtonLogic.buttonOn(button99);
                    btn99 = true;
                }
                snack();

            }
        });
        button100 = findViewById(R.id.btn_100);
        button100.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if (btn100) {
                    ButtonLogic.buttonOff(button100);
                    btn100 = false;
                } else {
                    ButtonLogic.buttonOn(button100);
                    btn100 = true;
                }
                snack();

            }
        });

    }
    private void showDialogAlert(){


        AlertDialog.Builder builder = new AlertDialog.Builder(LandscapeActivity.this);
        builder.setTitle("Your ad may not run");
        builder.setIcon(R.drawable.warn);
        builder.setMessage("Are you shure to share?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                        Intent shareIntent = new Intent();
                        shareIntent.setAction(Intent.ACTION_SEND);
                        shareIntent.putExtra(Intent.EXTRA_STREAM, slika);
                        shareIntent.setType("image/jpeg");
                        startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.share)));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.share, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.share:
                if (ButtonLogic.counter > 20){

                    showDialogAlert();
                    // Toast.makeText(PortraitActivity.this,"This photo contains more than 20% text",Toast.LENGTH_LONG).show();


                }else{
                    Intent shareIntent = new Intent();
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.putExtra(Intent.EXTRA_STREAM, slika);
                    shareIntent.setType("image/jpeg");
                    startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.share)));

                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

