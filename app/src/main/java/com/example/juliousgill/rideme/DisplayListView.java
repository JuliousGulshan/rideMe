package com.example.juliousgill.rideme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by JuliousGill(15969) on 06/03/2018.
 */

public class DisplayListView extends AppCompatActivity {

    //variables
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ContactAdapter contactAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_listview_layout);

        listView = (ListView) findViewById(R.id.listview);

        //attaching adapter to the list view
        contactAdapter = new ContactAdapter(this,R.layout.row_layout);
        listView.setAdapter(contactAdapter);

        //open the fetched json file into new intent with list view
        json_string = getIntent().getExtras().getString("json_data");

        //try & catch method
        try {

            //converting json array into json objects
            JSONArray json = new JSONArray(json_string);


            int count = 0;

            String number,name,address,position,position1,banking,bonus,status,contract_name,bike_stands,available_bike_stands,available_bikes,last_update;

            while (count<json.length())
            {
                JSONObject JO = json.getJSONObject(count);

                //splitting the position into latitude and longitude
                JSONObject jb = JO.getJSONObject("position");

                jb.get("lat");
                jb.get("lng");

               //Log.i("latitude", jb.getString("lat"));

                //Adding values to Contacts activity arrays
                Contacts.myLat.add((double)jb.get("lat"));
                Contacts.myLng.add((double)jb.get("lng"));
                Contacts.myName.add((String)JO.get("name"));

               // Log.i("checking",Contacts.myList.add((double)jb.get("lat")));



                number = JO.getString("number");
                name = JO.getString("name");
                address = JO.getString("address");

                position= jb.getString("lat"); //latitude
                position1 = jb.getString("lng"); //longitude

                banking = JO.getString("banking");
                bonus = JO.getString("bonus");
                status = JO.getString("status");
                contract_name = JO.getString("contract_name");
                bike_stands = JO.getString("bike_stands");
                available_bike_stands = JO.getString("available_bike_stands");
                available_bikes = JO.getString("available_bikes");
                last_update = JO.getString("last_update");

                Contacts contacts = new Contacts("Station Number: "+ number,"Name: "+name,
                        "Address: "+address,"Latitude: "+position,"Longitude: "+position1,
                        "Banking: "+banking,"Bonus: "+bonus,"status: "+status,
                        "contractName: "+contract_name, "bikeStands: "+bike_stands,
                        "availableStands: "+available_bike_stands,
                        "availableBikes: "+available_bikes, "lastUpdate: "+last_update);

                contactAdapter.add(contacts);


                count++;
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
    }


}
