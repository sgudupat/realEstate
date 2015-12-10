package com.square.realestate;



import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.square.domain.PropertyDetails;


public class PropertyRequirementActivity extends Activity {
	final Context context=this;

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.required_property);

		Spinner propertyType = (Spinner) findViewById(R.id.property_expectedTypeSpinner);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.property_type, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner propertySpace= (Spinner) findViewById(R.id.property_expectedSpaceSpinner);
		ArrayAdapter<CharSequence> adapterSpace= ArrayAdapter.createFromResource(this, R.array.property_space,android.R.layout.simple_spinner_item);
		adapterSpace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		propertyType.setAdapter(adapter);
		propertySpace.setAdapter(adapterSpace);

		/*submit.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Log.i("onClick", "start");
					//showPopup();
					Log.i("onClick", "finish");
				}

			});*/
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
			/*	propList.add(new PropertyDetails("sachin","1BHK","20,000,00"));
			propList.add(new PropertyDetails("rahul","2BHK","57,000,00"));
			propList.add(new PropertyDetails("sachin","1BHK","20,000,00"));
			propList.add(new PropertyDetails("rahul","2BHK","57,000,00"));
			propList.add(new PropertyDetails("sachin","1BHK","20,000,00"));
			propList.add(new PropertyDetails("rahul","2BHK","57,000,00"));
			propList.add(new PropertyDetails("sachin","1BHK","20,000,00"));
			propList.add(new PropertyDetails("rahul","2BHK","57,000,00"));*/
			propList.add(new PropertyDetails("sachin","1BHK","20,000,00"));
			propList.add(new PropertyDetails("rahul","2BHK","57,000,00"));
			propList.add(new PropertyDetails("sachin","1BHK","20,000,00"));
			propList.add(new PropertyDetails("rahul","2BHK","57,000,00"));		
			PropertyAdapter adapter = new PropertyAdapter(this,propList);       
			listView.setAdapter(adapter);
			
			layout.setOnKeyListener(new View.OnKeyListener() {

		        @Override
		        public boolean onKey(View v, int keyCode, KeyEvent event) {
		            // TODO Auto-generated method stub
		            boolean res=false;
		            if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
		                // do something on back.
		                Log.e("keydown","back");
		                if (pwindo.isShowing()) {
		                    Log.e("keydown","pw showing");
		                    pwindo.dismiss();
		                    res = true;
		                }
		            } else {
		                res = false;
		            }
		            return res;
		        }
		    });
			//Button btnClosePopup = (Button) findViewById(R.id.btn_New);
			/*btnClosePopup.setOnClickListener(new AdapterView.OnClickListener() {


				@Override
				public void onClick(View v) {
					Log.i("onClick", "start");
					Intent intent = new Intent(PropertyRequirementActivity.this, MainActivity.class);
					Log.i("onClick", "end");
					startActivity(intent);
				}
			});*/
			
		}

		//show popup window after you have done initialization of views

		catch (Exception e) {
			e.printStackTrace();

		}
		pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
	}
	public void propertyRequirementSubmit(View view){
		final EditText buyerName=(EditText) findViewById(R.id.buyer_name);
		final EditText buyerMobile=(EditText) findViewById(R.id.buyer_mobile);
		EditText buyerEmail=(EditText) findViewById(R.id.buyer_email);
		Spinner propertyTypeView=(Spinner) findViewById(R.id.property_expectedTypeSpinner);

		String typeValue=propertyTypeView.getSelectedItem().toString();
		Spinner propertySpaceView=(Spinner) findViewById(R.id.property_expectedSpaceSpinner);
		String spaceValue=propertySpaceView.getSelectedItem().toString();
		EditText locality= (EditText) findViewById(R.id.expected_place);
		EditText price= (EditText) findViewById(R.id.expected_price);
		Button submit= (Button) findViewById(R.id.requirement_submit);
		submit.setOnClickListener(new OnClickListener(){
			String bN="Davidson";
			@Override
			public void onClick(View v) {
				if(bN.equalsIgnoreCase(buyerName.getText().toString()) &&(buyerMobile.getText().toString()).equalsIgnoreCase("8548834380")  )   
				{ 
					Log.i("onClick", "onClick");
					Intent intent = new Intent(context, CustomerDetailsActivity.class);
					intent.putExtra("bN", "Davidson");
					intent.putExtra("bM", "8548834380");
					startActivity(intent);

				}         
				else{

					Toast.makeText(getApplicationContext(), "Update Failed, Please Retry !!!", Toast.LENGTH_LONG).show();

				}
			}	});



		/*final ArrayList<NameValuePair> post=new ArrayList<NameValuePair>();
		post.add(new BasicNameValuePair("buyerName",buyerName.getText().toString()));
		post.add(new BasicNameValuePair("buyerMobile",buyerMobile.getText().toString()));
		post.add(new BasicNameValuePair("buyerEmail",buyerEmail.getText().toString()));
		post.add(new BasicNameValuePair("propertyType",typeValue));
		post.add(new BasicNameValuePair("propertySpace",spaceValue));
		post.add(new BasicNameValuePair("locality",locality.getText().toString()));
		post.add(new BasicNameValuePair("price",price.getText().toString()));*/
		try
		{
			/*String response= SimpleHttpClient.executeHttpPost("/propertyRequirement", post);
			JSONObject json=new JSONObject(response);
			SharedPreferences prefer= PreferenceManager.getDefaultSharedPreferences(context);
			SharedPreferences.Editor editor=prefer.edit();
			editor.putString("buyerName", json.getString("buyer_name"));
			editor.putString("property_type", json.getString("property_type"));
			editor.putString("mobile", json.getString("mobile"));
			editor.commit();*/

		}catch (Exception e) {
			Log.i("Response 2:Error:", e.getMessage());
			Toast.makeText(getApplicationContext(), "Update Failed, Please Retry !!!", Toast.LENGTH_LONG).show();
		}}
	public void onBackPressed(View view) {
	    new AlertDialog.Builder(this)
	        .setIcon(android.R.drawable.ic_dialog_alert)
	        .setTitle("REAL ESTATE")
	        .setMessage("Are you sure you want to close this activity?")
	        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
	    {
	        @Override
	        public void onClick(DialogInterface dialog, int which) {
	        	Intent intent = new Intent(PropertyRequirementActivity.this, MainActivity.class);
				Log.i("onClick", "end");
				startActivity(intent);
	           // finish();    
	        }

	    })
	    .setNegativeButton("No", null)
	    .show();
	}}

