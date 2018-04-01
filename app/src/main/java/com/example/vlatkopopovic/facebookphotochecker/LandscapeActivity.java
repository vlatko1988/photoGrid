package com.example.vlatkopopovic.facebookphotochecker;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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
            btn26, btn27, btn28, btn29, btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39, btn40, btn41, btn42, btn43, btn44, btn45, btn46, btn47, btn48, btn49, btn50;

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19, button20, button21, button22, button23, button24, button25,
            button26, button27, button28, button29, button30, button31, button32, button33, button34, button35, button36, button37, button38, button39, button40, button41, button42, button43, button44, button45, button46, button47, button48, button49, button50;

    int finalHeight, finalWidth;
    int counter = 0;
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
        if (actionBar != null) {
            actionBar.hide();
        }
        Bundle b = getIntent().getExtras();

        if (b != null) {
            finalWidth = b.getInt("sirina");
        }
        if (b != null) {
            finalHeight = b.getInt("visina");
        }
        if (b != null) {
            slika = Uri.parse(b.getString("slika"));
        }

        RelativeLayout relavtive = findViewById(R.id.layout2);
        cs = findViewById(R.id.cl);

        MovableFloatingActionButton mv = findViewById(R.id.fab);
        mv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_STREAM, slika);
                shareIntent.setType("image/jpeg");
                startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.share)));
            }
        });

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

    }
}

