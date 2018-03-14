package com.example.juliousgill.rideme;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JuliousGill(15969) on 06/03/2018.
 */

public class ContactAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public ContactAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    //adding objects to list

    public void add(Contacts object) {
        super.add(object);
        list.add(object);


    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row;
        row = convertView;
        ContactHolder contactHolder;

        if(row==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = layoutInflater.inflate(R.layout.row_layout,parent,false);

            contactHolder = new ContactHolder();
            contactHolder.tx_number = (TextView) row.findViewById(R.id.tx_number);
            contactHolder.tx_name = (TextView) row.findViewById(R.id.tx_name);
            contactHolder.tx_address = (TextView) row.findViewById(R.id.tx_address);
            contactHolder.tx_position = (TextView) row.findViewById(R.id.tx_position);
            contactHolder.tx_position1 = (TextView) row.findViewById(R.id.tx_position1);

            contactHolder.tx_banking = (TextView) row.findViewById(R.id.tx_banking);
            contactHolder.tx_bonus = (TextView) row.findViewById(R.id.tx_bonus);
            contactHolder.tx_status = (TextView) row.findViewById(R.id.tx_status);
            contactHolder.tx_contract_name = (TextView) row.findViewById(R.id.tx_contract_name);
            contactHolder.tx_bike_stands = (TextView) row.findViewById(R.id.tx_bike_stands);
            contactHolder.tx_available_bike_stands = (TextView) row.findViewById(R.id.tx_available_bike_stands);
            contactHolder.tx_available_bikes = (TextView) row.findViewById(R.id.tx_available_bikes);
            contactHolder.tx_last_update = (TextView) row.findViewById(R.id.tx_last_update);

            row.setTag(contactHolder);

        }

        else{

            contactHolder = (ContactHolder) row.getTag();
        }

        Contacts contacts = (Contacts) this.getItem(position);

        contactHolder.tx_number.setText(contacts.getNumber());
        contactHolder.tx_name.setText(contacts.getName());
        contactHolder.tx_address.setText(contacts.getAddress());
        contactHolder.tx_position.setText(contacts.getPosition());
        contactHolder.tx_position1.setText(contacts.getPosition1());

        contactHolder.tx_banking.setText(contacts.getBanking());
        contactHolder.tx_bonus.setText(contacts.getBonus());
        contactHolder.tx_status.setText(contacts.getStatus());
        contactHolder.tx_contract_name.setText(contacts.getContract_name());
        contactHolder.tx_bike_stands.setText(contacts.getBike_stands());
        contactHolder.tx_available_bike_stands.setText(contacts.getAvailable_bike_stands());
        contactHolder.tx_available_bikes.setText(contacts.getAvailable_bikes());
        contactHolder.tx_last_update.setText(contacts.getLast_update());


        return row;
    }

    static class ContactHolder
    {
        TextView tx_number,tx_name,tx_address,tx_position,tx_position1,tx_banking,tx_bonus,
        tx_status,tx_contract_name,tx_bike_stands,tx_available_bike_stands,tx_available_bikes,tx_last_update;
    }
}
