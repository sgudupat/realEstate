package com.square.realestate;

import java.util.ArrayList;

import com.square.domain.PropertyDetails;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;

public class PostPropertyActivity extends Activity {
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.post_property);
		 Spinner propertyType = (Spinner) findViewById(R.id.property_typeSpinner);
	        // Create an ArrayAdapter using the string array and a default spinner layout
	        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.property_type, android.R.layout.simple_spinner_item);
	        // Specify the layout to use when the list of choices appears
	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        Spinner propertySpace= (Spinner) findViewById(R.id.property_spaceSpinner);
	        ArrayAdapter<CharSequence> adapterSpace= ArrayAdapter.createFromResource(this, R.array.property_space,android.R.layout.simple_spinner_item);
	        adapterSpace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        propertyType.setAdapter(adapter);
	        propertySpace.setAdapter(adapterSpace);
	}

	public void showPopup(View view) {
        //if you call this method correctly then you do not need to wrap 
        // this method by try-catch block which affects performance
		
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layout = inflater.inflate(R.layout.property_popup, (ViewGroup) findViewById(R.id.property_popup_relative), false);

        final PopupWindow pwindo = new PopupWindow(layout, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        ListView listView = (ListView) layout.findViewById(R.id.property_popup_listview);
        //get txt view from "layout" which will be added into popup window
        //before it you tried to find view in activity container
      /*  TextView txt = (TextView) layout.findViewById(R.id.person_name);
        txt.setText(Html.fromHtml(getString(R.string.tos_text)));
        TextView txt1 = (TextView) layout.findViewById(R.id.contact_number);
        txt1.setText(Html.fromHtml(getString(R.string.tos_text1)));
        TextView txt2 = (TextView) layout.findViewById(R.id.ExpectedProperty);
        txt2.setText(Html.fromHtml(getString(R.string.tos_text2)));*/
       
     try{   
    	 ArrayList<PropertyDetails> propList = new ArrayList<PropertyDetails>();
 		propList.add(new PropertyDetails("sachin","1BHK","20,000,00"));
 		propList.add(new PropertyDetails("rahul","2BHK","57,000,00"));
 		propList.add(new PropertyDetails("sachin","1BHK","20,000,00"));
 		propList.add(new PropertyDetails("rahul","2BHK","57,000,00"));
 		propList.add(new PropertyDetails("sachin","1BHK","20,000,00"));
 		propList.add(new PropertyDetails("rahul","2BHK","57,000,00"));
 		propList.add(new PropertyDetails("sachin","1BHK","20,000,00"));
 		propList.add(new PropertyDetails("rahul","2BHK","57,000,00"));
 		propList.add(new PropertyDetails("sachin","1BHK","20,000,00"));
 		propList.add(new PropertyDetails("rahul","2BHK","57,000,00"));
 		propList.add(new PropertyDetails("sachin","1BHK","20,000,00"));
 		propList.add(new PropertyDetails("rahul","2BHK","57,000,00"));		
		 PropertyAdapter adapter = new PropertyAdapter(this,propList);       
		listView.setAdapter(adapter);
        
     }

        //show popup window after you have done initialization of views
      
        catch (Exception e) {
            e.printStackTrace();
            
        }
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
}
	public void onBackPressed(View view) {
	    new AlertDialog.Builder(this)
	        .setIcon(android.R.drawable.ic_dialog_alert)
	        .setTitle("REAL ESTATE")
	        .setMessage("Are you sure you want to close this activity?")
	        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
	    {
	        @Override
	        public void onClick(DialogInterface dialog, int which) {
	        	Intent intent = new Intent(PostPropertyActivity.this, MainActivity.class);
				Log.i("onClick", "end");
				startActivity(intent);
	           // finish();    
	        }

	    })
	    .setNegativeButton("No", null)
	    .show();
	}}
