package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnOpenInGoogleMaps (View view) {
        EditText teamAddres = (EditText) findViewById(R.id.teamAddressField);
        // Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamAddres.getText());
        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");
        // Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }
   public void OnSetAvatarButton(View view){
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) return;
        ImageView avatarImage = (ImageView) findViewById(R.id.logoImage);
        String drawableName = "ic_logo_00"; // Default value

        int imageId = data.getIntExtra("imageID", R.id.logoImage00);
        if (imageId == R.id.logoImage00) {
            drawableName = "ic_logo_00";
        } else if (imageId == R.id.logoImage01) {
            drawableName = "ic_logo_01";
        } else if (imageId == R.id.logoImage02) {
            drawableName = "ic_logo_02";
        } else if (imageId == R.id.logoImage03) {
            drawableName = "ic_logo_03";
        } else if (imageId == R.id.logoImage04) {
            drawableName = "ic_logo_04";
        } else if (imageId == R.id.logoImage05) {
            drawableName = "ic_logo_05";
        }

        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }

    }

