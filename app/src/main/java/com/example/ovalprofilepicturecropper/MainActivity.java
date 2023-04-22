package com.example.ovalprofilepicturecropper;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.canhub.cropper.CropImageContract;
import com.canhub.cropper.CropImageContractOptions;
import com.canhub.cropper.CropImageOptions;
import com.canhub.cropper.CropImageView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private UserHelper userHelper;
    private ImageView edit, profilePic;

    private ActivityResultLauncher<CropImageContractOptions> cropImage =
            registerForActivityResult(new CropImageContract(), result -> {

                if (result.isSuccessful()) {
                    // Use the returned uri.
                    Uri uriContent = result.getUriContent();

                    profilePic.setImageURI(uriContent);

                    assert uriContent != null;

                    userHelper.setProfilePicture(uriContent.toString());

                } else {
                    // An error occurred.
                    Exception exception = result.getError();
                }
            });

    private ActivityResultLauncher<Intent> photoLibraryLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        Uri photoUri = Objects.requireNonNull(result.getData()).getData();

                        CropImageOptions cropImageOptions = new CropImageOptions();
                        cropImageOptions.cropShape = CropImageView.CropShape.OVAL;
                        cropImageOptions.fixAspectRatio = true;

                        //optionals
                        cropImageOptions.minCropWindowHeight = 110;
                        cropImageOptions.minCropWindowWidth = 110;

                        cropImage.launch(new CropImageContractOptions(photoUri, cropImageOptions));

                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vars();

        listeners();

        checkers();
    }

    private void vars(){
        userHelper = new UserHelper(MainActivity.this);
        edit = findViewById(R.id.editIcon);
        profilePic = findViewById(R.id.profile_image);
    }

    private void listeners(){
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                photoLibraryLauncher.launch(intent);
            }
        });
    }

    private void checkers(){
        String profilePicture = userHelper.getProfilePicture();

        if(!profilePicture.equals("")){
            profilePic.setImageURI(Uri.parse(profilePicture));
        }

    }
}