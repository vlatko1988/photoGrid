package com.example.vlatkopopovic.facebookphotochecker;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

import static com.example.vlatkopopovic.facebookphotochecker.ScaleToFitWidthHeightTransform.sirina;
import static com.example.vlatkopopovic.facebookphotochecker.ScaleToFitWidthHeightTransform.visina;

public class Main2Activity extends AppCompatActivity {
    private final int IMAGE_PICKER_REQUEST = 1;
         int p;
         int l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button landscape = findViewById(R.id.button);
        Button portrait = findViewById(R.id.button2);


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






            if (l == 1){
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int height = displayMetrics.heightPixels;
                int width = displayMetrics.widthPixels;

              //int a =  Math.round(height/(Resources.getSystem().getDisplayMetrics().xdpi/DisplayMetrics.DENSITY_DEFAULT));

                ScaleToFitWidthHeightTransform sc = new ScaleToFitWidthHeightTransform(1200,true);
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),selectedImage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sc.transform(bitmap);
                //ImageView iv = findViewById(R.id.imageView);


                int visina = ScaleToFitWidthHeightTransform.visina;
                int sirina = ScaleToFitWidthHeightTransform.sirina;
                Intent i = new Intent(this, MainActivity.class);
                i.putExtra("slika",selectedImage.toString());
                i.putExtra("visina",visina);
                i.putExtra("sirina",sirina);
                startActivity(i);


            }if (p == 2){
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int height = displayMetrics.heightPixels;
                int width = displayMetrics.widthPixels;
                ScaleToFitWidthHeightTransform sc = new ScaleToFitWidthHeightTransform(width,false);
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),selectedImage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sc.transform(bitmap);
                //ImageView iv = findViewById(R.id.imageView);


                int visina = ScaleToFitWidthHeightTransform.visina;
                int sirina = width;
                Intent i = new Intent(this, Main3Activity.class);
                i.putExtra("slika",selectedImage.toString());
                i.putExtra("visina",visina);
                i.putExtra("sirina",sirina);
                startActivity(i);



            }





        }
    }

}
