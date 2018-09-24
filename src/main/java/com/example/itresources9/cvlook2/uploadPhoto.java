package com.example.itresources9.cvlook2;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class uploadPhoto extends Activity implements View.OnClickListener{

    Button choice,upload;
    ImageView imageView;

    Uri filepath;
    private final int PICK_IMAGE_REQUEST = 76;

    FirebaseStorage storage;
    StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_photo);

        choice = (Button)findViewById(R.id.choice);
        upload = (Button)findViewById(R.id.upload);

        imageView = (ImageView)findViewById(R.id.imageView);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        upload.setOnClickListener(this);
        choice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.choice:
                choiceImage();
                break;
            case R.id.upload:
                if(filepath!=null){
                    ProgressDialog progressDialog = new ProgressDialog(this);
                    progressDialog.setTitle("uploading...");
                    progressDialog.show();


                    StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());

                    ref.putFile(filepath).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                        }
                    });
                }
                break;
        }
    }
    private void choiceImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Photo"), PICK_IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE_REQUEST && data != null
                && data.getData() != null)
            {
                filepath = data.getData();
                try{
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),filepath);
                    imageView.setImageBitmap(bitmap);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }