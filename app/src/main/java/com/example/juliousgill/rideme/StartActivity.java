package com.example.juliousgill.rideme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by JuliousGill(15969) on 11/03/2018.
 */

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


    }

    //when display list view button is clicked open list view activity
    public void displayListView (View view){

            startActivity(new Intent(StartActivity.this,MainActivity.class));

         }

    //when display map view button is clicked open map view activity
        public void displayMapView (View view){

            startActivity(new Intent(StartActivity.this,MapsActivity.class));

        }

    //when display list about button is clicked open about view activity
    public void displayAboutView (View view){

        startActivity(new Intent(StartActivity.this,AboutActivity.class));

    }


}
