package com.example.apprenti.blablawild;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.FileDescriptor;
import java.io.IOException;


public class AccountActivity extends AppCompatActivity implements View.OnClickListener{
    private static int RESULT_LOAD_IMAGE = 1;
    private Button buttonDisconnect;
    private TextView textViewDisplayName;
    private TextView textViewEmail;
    private ImageView imageViewProfile;
    private FirebaseUser mFirebaseUser;
    private FirebaseAuth mAuth;
    private Button buttonMenu;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        this.buttonDisconnect = (Button) findViewById(R.id.buttonDisconnect) ;
        this.buttonDisconnect.setOnClickListener(this);
        this.textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        this.textViewDisplayName = (TextView) findViewById(R.id.textViewDisplayName);
        this.imageViewProfile = (ImageView) findViewById(R.id.imageViewProfile);
        this.buttonMenu= (Button)findViewById(R.id.buttonMenu);
        this.buttonMenu.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        if (user == null){
            finish();
            startActivity(new Intent(this,SigninActivity.class));
        } else {
            textViewDisplayName.setText(user.getDisplayName());
            textViewEmail.setText(user.getEmail());
        }



        Button buttonChoosePic = (Button) findViewById(R.id.buttonChoosePic);
        buttonChoosePic.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageViewProfile = (ImageView) findViewById(R.id.imageViewProfile);

            Bitmap bmp = null;
            try {
                bmp = getBitmapFromUri(selectedImage);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            imageViewProfile.setImageBitmap(bmp);

        }


    }



    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }

    public void onClick(View v) {
        if (v == buttonDisconnect) {
            mAuth.signOut();
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intentToSigninActivity = new Intent(AccountActivity.this, SigninActivity.class);
            startActivity(intentToSigninActivity);
        }
        if (v == buttonMenu) {
            startActivity(new Intent(this, MainActivity.class));
        }
    }}