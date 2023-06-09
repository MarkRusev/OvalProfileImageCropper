# OvalProfileImageCropper ✂️
 
Profile image cropper using [CircleImageView](https://github.com/hdodenhof/CircleImageView) and [CanHub](https://github.com/CanHub/Android-Image-Cropper).

<p float="left">
  <img src="https://user-images.githubusercontent.com/68556824/233808056-1d0b8f3b-1115-457d-8b0e-316b5c853e0b.jpg" width="300" height="600"> &nbsp;
  <img src="https://user-images.githubusercontent.com/68556824/233807937-7ad9345e-50c4-49f9-ae5b-c55efb59a5b5.jpg" width="300" height="600"> &nbsp;
  <img src="https://user-images.githubusercontent.com/68556824/233808339-81ab69aa-34fb-4fb5-94aa-5e7952c329f9.jpg" width="200" height="137"> 
</p>


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

# [See code 👀](https://github.com/MarkRusev/OvalProfileImageCropper/tree/main/app/src/main/java/com/example/ovalprofilepicturecropper)

# [LinkedIn 🔗](https://www.linkedin.com/in/mark-rusev-4805141b3/)

