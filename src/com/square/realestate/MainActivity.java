package com.square.realestate;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void postRequirement(View view) {
        //Intent intent = new Intent(this, PropertyRequirementActivity.class);
        Intent intent = new Intent(this, GalleryViewActivity.class);
        startActivity(intent);
    }

    public void postProperty(View view) {
        //Intent intent = new Intent(this, PostPropertyActivity.class);
        Intent intent = new Intent(this, GalleryViewActivity.class);
        startActivity(intent);
    }
}
