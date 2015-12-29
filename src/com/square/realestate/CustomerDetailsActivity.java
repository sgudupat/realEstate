package com.square.realestate;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.square.domain.PropertyDetails;

public class CustomerDetailsActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {

        ArrayList<PropertyDetails> propList = new ArrayList<PropertyDetails>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property_popup);

        propList.add(new PropertyDetails("sachin", "8548834380", "1BHK"));
        propList.add(new PropertyDetails("rahul", "9940842416", "2BHK"));

		/*Intent intent= getIntent();
		intent.getStringExtra("bN");
		intent.getStringExtra("bM");
		//<style name="AppBaseTheme" parent="Theme.AppCompat.Light.DarkActionBar">*/
        ListView listView = (ListView) findViewById(R.id.property_popup_listview);
        final PropertyAdapter adapter = new PropertyAdapter(CustomerDetailsActivity.this, propList);
        listView.setAdapter(adapter);
    }

	/*private ArrayList<propertyDetails> finalData(){
		ArrayList<propertyDetails> time = new ArrayList<propertyDetails>();
		String pN="Sachin";
		String pM="9940842416";

		time.add("sachin","8548834380");
		return time;

	}*/

}
