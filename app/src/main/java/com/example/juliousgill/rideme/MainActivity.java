package com.example.juliousgill.rideme;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Julious Gulshan(15969) on 06/03/2018.
 */

public class MainActivity extends Activity {

     //variable
    String json_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getJSON(View view){

        new BackgroundTask().execute();


    }


    class BackgroundTask extends AsyncTask<Void,Void,String>{

        //variable
        String json_url;
        String JSON_STRING;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //url for fetching the dublin bike json data using the api key
            json_url="https://api.jcdecaux.com/vls/v1/stations?contract=Dublin&apiKey=10bc395ff68754278f775a6a9459c544454ced1c";
        }

        //getting JSON data from the above url
        @Override
        protected String doInBackground(Void... voids) {

            try {

                URL url = new  URL(json_url);
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection)url.openConnection();
                InputStream inputStream = httpsURLConnection.getInputStream();
                BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();

                while ((JSON_STRING = bufferedReader.readLine()) !=null)
                {

                    stringBuilder.append(JSON_STRING+ "\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpsURLConnection.disconnect();
                return stringBuilder.toString().trim();
            }catch (MalformedURLException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        //saving the fetched data in json_string.
        @Override
        protected void onPostExecute(String result) {
            TextView textView = findViewById(R.id.textview);
            textView.setText(result);

            json_string = result;
        }
    }

    // new activity with the avaiable json data and saved as json_string.
    //parsing json file with available json data
    //toast is applied first to get json
    public void parseJSON(View view)
    {

        if (json_string ==null){
            Toast.makeText(getApplicationContext(),"First Get JSON", Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent = new Intent(this,DisplayListView.class);
            intent.putExtra("json_data",json_string);
            startActivity(intent);
        }

    }
}

