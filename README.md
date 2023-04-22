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

# Usage
<pre>
    <code>
     ```xml
     <de.hdodenhof.circleimageview.CircleImageView
            android:id="@+id/profile_image"
            android:layout_width="110dp"
            android:layout_height="110dp"
            android:src="@drawable/ic_launcher_background"
            app:civ_border_color="#606060"
            app:civ_border_width="1dp" />

        <ImageView
            android:id="@+id/editIcon"
            android:layout_width="30dp"
            android:layout_height="25dp"
            android:layout_gravity="bottom|end"
            android:src="@drawable/pen" />
     .```
    </code>
</pre>
