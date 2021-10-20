package com.example.complainmanagerapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ComplainActivity extends AppCompatActivity {

    EditText fullName,phone,address,complain;
    Button submitComplain,takePhoto;
//    HorizontalScrollView scrollableList;
//    LinearLayout listOfPhotoEvidence;

//    boolean photosProvided = false;
//    ArrayList<ImageView> photos;


    ImageView imageViewTemp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);

        fullName = findViewById(R.id.fullName);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        complain = findViewById(R.id.complain);

        submitComplain = findViewById(R.id.submitComplain);
        takePhoto = findViewById(R.id.takePhoto);


        FirebaseDatabase fath = FirebaseDatabase.getInstance();
        DatabaseReference myRef = fath.getReference();
        myRef.setValue("HELLO WORLD");
        int i = (int) (Math.random()*100);
        String id = new String(String.valueOf(i));


        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grantCameraPermission();
                Intent openCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(openCamera,1000);
            }
        });

        submitComplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FullName = fullName.getText().toString();
                String Phone = phone.getText().toString();
                String Address = address.getText().toString();
                String Complain = complain.getText().toString();
                Information info = new Information(FullName,Phone,Address,Complain);
                myRef.child(id).setValue(info);

            }
        });
    }

    void grantCameraPermission(){
        if(ContextCompat.checkSelfPermission(ComplainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(ComplainActivity.this, new String[]{Manifest.permission.CAMERA},100);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000 && RESULT_OK == resultCode){
            ImageView imageView = new ImageView(ComplainActivity.this);
            Bitmap capturedImage = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(capturedImage);
            imageViewTemp = findViewById(R.id.imageView);
            imageViewTemp.setImageBitmap(capturedImage);
//            listOfPhotoEvidence.addView(imageView);
//            photos.add(imageView);
//            photosProvided = true;
        }
    }
}