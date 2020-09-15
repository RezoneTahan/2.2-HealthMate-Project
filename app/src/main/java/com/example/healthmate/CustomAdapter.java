package com.example.healthmate;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<User> {

    private Activity context;
    private List<User> userList;


    public CustomAdapter( Activity context,  @NonNull List<User> userList) {
        super(context, R.layout.sample_layout,userList);
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view =  layoutInflater.inflate(R.layout.sample_layout,null,true);

        User user = userList.get(position);

        TextView t1 = view.findViewById(R.id.hospitalEditTextId);
        TextView t2 = view.findViewById(R.id.locationEditTextId);

        t1.setText("Hospital Name: "+user.getHospital());
        t2.setText("Location"+user.getLocation());

        return view;
    }
}
