package com.example.vlatkopopovic.facebookphotochecker;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class StartActivity extends AppCompatActivity {
    private final int IMAGE_PICKER_REQUEST = 1;
    int p;
    int l;
    int width;
    int height;
     Bitmap image;
    int heightFromUri;
    int widthFromUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        Button selectPhotoBtn = findViewById(R.id.button2);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;

        selectPhotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(StartActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        1);



            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_PICKER_REQUEST && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                heightFromUri =  bitmap.getHeight();
                widthFromUri =  bitmap.getWidth();
                bitmap.getWidth();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (widthFromUri > heightFromUri) {

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

                Intent i = new Intent(this, LandscapeActivity.class);
                i.putExtra("slika", selectedImage.toString());
                i.putExtra("visina", visina);
                i.putExtra("sirina", sirina);
                startActivity(i);


            }
            else {

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



                int visina = ScaleToFitWidthHeightTransform.visina;
                int sirina = width;
                Intent i = new Intent(this, PortraitActivity.class);
                i.putExtra("slika", selectedImage.toString());
                i.putExtra("visina", visina);
                i.putExtra("sirina", sirina);
                startActivity(i);


            }
        }
    } @Override
    public void onBackPressed() {

        moveTaskToBack(true);

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(i, IMAGE_PICKER_REQUEST);
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(StartActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

}
