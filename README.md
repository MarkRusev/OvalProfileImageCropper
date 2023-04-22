# OvalProfileImageCropper
 
Profile image cropper using [CircleImageView](https://github.com/hdodenhof/CircleImageView) and [CanHub](https://github.com/CanHub/Android-Image-Cropper).

# Gradle
<pre>
    <code>
       dependencies {
         ...
         implementation 'de.hdodenhof:circleimageview:3.1.0'
         implementation("com.vanniktech:android-image-cropper:4.5.0")
       }
    </code>
</pre>

# XML
<pre>
    <code>
   &lt;FrameLayout
        android:id="@+id/imageFl"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="@id/guideline"&gt;
    
       &lt;de.hdodenhof.circleimageview.CircleImageView
            android:id="@+id/profile_image"
            android:layout_width="110dp"
            android:layout_height="110dp"
            android:src="@drawable/ic_launcher_background"
            app:civ_border_color="#606060"
            app:civ_border_width="1dp" /&gt;

       &lt;ImageView
            android:id="@+id/editIcon"
            android:layout_width="30dp"
            android:layout_height="25dp"
            android:layout_gravity="bottom|end"
            android:src="@drawable/pen" /&gt;
            
   &lt;/FrameLayout&gt;   
         
   &lt;androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        app:layout_constraintGuide_percent="0.067031465" /&gt;
    </code>
</pre>

# Java
<p> First start the image picker launcher and then pass the given image to the crop launcher </p>
<pre>
    <code>
    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    photoLibraryLauncher.launch(intent);
    
    private final ActivityResultLauncher<Intent> photoLibraryLauncher = registerForActivityResult(
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

                        cropImageLauncher.launch(new CropImageContractOptions(photoUri, cropImageOptions));

                    }
                }
            });
            
     private final ActivityResultLauncher<CropImageContractOptions> cropImageLauncher =
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
    
    
    </code> 
</pre>
