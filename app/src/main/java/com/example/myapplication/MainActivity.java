package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText website,location,sharetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        website=findViewById(R.id.editText1);
        location=findViewById(R.id.editText2);
        sharetext=findViewById(R.id.editText3);
    }

    public void openWebsite(View view) {
      String url=website.getText().toString();
        Uri uri=Uri.parse(url);
        Intent i1=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i1);
    }

    public void openLocation(View view) {
        String getlocation=location.getText().toString();
        Uri loc=Uri.parse("geo:0,0?q=" + getlocation);
        Intent i2=new Intent(Intent.ACTION_VIEW,loc);
        startActivity(i2);
    }

    public void shareText(View view) {
        String gettext=sharetext.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.share_text_with)
                .setText(gettext)
                .startChooser();
    }

}