package com.example.vlatkopopovic.facebookphotochecker;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.io.IOException;

public class StartActivity extends AppCompatActivity {
    private final int IMAGE_PICKER_REQUEST = 1;
    int p;
    int l;
    int width;
    int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Button landscape = findViewById(R.id.button);
        Button portrait = findViewById(R.id.button2);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;

        landscape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = 1;
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, IMAGE_PICKER_REQUEST);
            }
        });
        portrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p = 2;
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, IMAGE_PICKER_REQUEST);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_PICKER_REQUEST && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();

            if (l == 1) {

                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int height = displayMetrics.heightPixels;


                //int a =  Math.round(height/(Resources.getSystem().getDisplayMetrics().xdpi/DisplayMetrics.DENSITY_DEFAULT));

                ScaleToFitWidthHeightTransform sc = new ScaleToFitWidthHeightTransform(height, true);
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sc.transform(bitmap);
                //ImageView iv = findViewById(R.id.imageView);


                int visina = ScaleToFitWidthHeightTransform.visina;
                int sirina = ScaleToFitWidthHeightTransform.sirina;
                Log.d("kitaSirina slike", String.valueOf(sirina));
                Log.d("kitaVisina slike", String.valueOf(visina));
                Intent i = new Intent(this, LandscapeActivity.class);
                i.putExtra("slika", selectedImage.toString());
                i.putExtra("visina", visina);
                i.putExtra("sirina", sirina);
                startActivity(i);


            }
            if (p == 2) {

                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

                int width = displayMetrics.widthPixels;
                ScaleToFitWidthHeightTransform sc = new ScaleToFitWidthHeightTransform(width, false);
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sc.transform(bitmap);
                //ImageView iv = findViewById(R.id.imageView);


                int visina = ScaleToFitWidthHeightTransform.visina;
                int sirina = width;
                Intent i = new Intent(this, PortraitActivity.class);
                i.putExtra("slika", selectedImage.toString());
                i.putExtra("visina", visina);
                i.putExtra("sirina", sirina);
                startActivity(i);


            }
        }
    }

}
