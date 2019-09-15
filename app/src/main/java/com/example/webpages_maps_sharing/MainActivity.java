package com.example.webpages_maps_sharing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCreateYourOwnBtn(View view) {
        Toast.makeText(getApplicationContext(), "Can include any intent you want", Toast.LENGTH_LONG).show();
    }

    public void onClickShareTextBtn(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is the text i wanted to share with you using intent");
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, "Learning How to Share");
        startActivity(shareIntent);
    }

    public void onClickOpenAddressBtn(View view) {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:6.1509,80.6937?z=15&q=Walasmulla+National+School"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void onClickOpenWebpageBtn(View view) {
        String urlAsString = "http://www.udacity.com";
        Uri webpage = Uri.parse(urlAsString);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
