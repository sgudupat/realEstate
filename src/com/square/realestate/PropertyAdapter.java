package com.square.realestate;

import java.util.ArrayList;
import java.util.List;


import com.square.domain.PropertyDetails;
import com.square.realestate.PropertyRequirementActivity;
import com.square.realestate.R;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

public class PropertyAdapter extends BaseAdapter implements ListAdapter {
    private final Context context;
    ArrayList<PropertyDetails> dataList;

    public PropertyAdapter(Context context, ArrayList<PropertyDetails> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public PropertyDetails getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Log.i("campaign adapter", "campaign adapter");
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.property_menu, null);

            TextView pNa = (TextView) view.findViewById(R.id.property_name);
            TextView pMo = (TextView) view.findViewById(R.id.property_details);
            TextView pEP = (TextView) view.findViewById(R.id.Property_price);
            pNa.setText(dataList.get(position).getBuyerName());
            pMo.setText(dataList.get(position).getBuyerMobile());
            pEP.setText(dataList.get(position).getApartment());
        }
        return view;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}