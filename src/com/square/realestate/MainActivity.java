package com.square.realestate;



import java.util.ArrayList;

import com.square.domain.PropertyDetails;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;


public class MainActivity extends Activity {
	Gallery ga;
    int width, height;
    LinearLayout linear;
    LinearLayout layout;
    Integer[] pics = {
    		R.layout.required_property,
    		R.layout.post_property
    };
    ImageView paging;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        layout = (LinearLayout) findViewById(R.id.imageLayout1);
            
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        width = displaymetrics.heightPixels;
        height = displaymetrics.widthPixels;
            
        for(int i=0; i<pics.length; i++)
        {
           paging = new ImageView(this);
           paging.setId(i);
           paging.setBackgroundResource(R.drawable.bluedot);
           layout.addView(paging);
        }
         
        ga = (Gallery)findViewById(R.id.thisgallery);
        ga.setAdapter(new ImageAdapter(this));
         
        ga.setOnItemClickListener(new OnItemClickListener() {
               public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) 
               {                   
                   System.out.println("SELECTED : " + arg2);
               }               
           });
    }
    public class ImageAdapter extends BaseAdapter {
    	 
        private Context ctx;
        int imageBackground;
        int pre=-1;
        public ImageAdapter(Context c) {
            ctx = c;
        }
 
        public int getCount() {
             
            return pics.length;
        }
 
        public View getView(int arg0, View convertView, ViewGroup arg2) {
        	View view = convertView;
             ImageView iv;
             LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             LinearLayout layoutnew = new LinearLayout(getApplicationContext());            
             layoutnew.setOrientation(LinearLayout.VERTICAL);
                 
             if (view == null) 
             {
               /* iv = new ImageView(ctx);
                iv.setImageResource(pics[arg0]);
                iv.setScaleType(ImageView.ScaleType.FIT_XY);
                int temp =(int) (height/1.7f);
                int temp_y = (int) ((3*temp)/2.0f);
                iv.setLayoutParams(new Gallery.LayoutParams(temp,temp_y));
                iv.setBackgroundResource(imageBackground);*/
            	 view = inflater.inflate(pics[arg0], null);
            	 
             }
             else
             {
            	 view = convertView;
             }
            /* TextView tv = new TextView(ctx);
             tv.setText("Page " + (arg0+1));
             tv.setTextColor(0xFFFFFFFF);
             tv.setPadding(0, 15, 0, 0);
             tv.setTextSize(18);
             tv.setGravity(Gravity.CENTER); 
            layoutnew.addView(iv);
             layoutnew.addView(tv);*/
             
            return view;
        }
 
        @Override
        public Object getItem(int position) {
            return null;
        }
 
        @Override
        public long getItemId(int position) {
            if(pre !=-1)
            {
                ImageView img = (ImageView) findViewById(pre);
                img.setBackgroundResource(R.drawable.bluedot);
            }
            ImageView img1 = (ImageView) findViewById(position);
            img1.setBackgroundResource(R.drawable.white);
            this.pre = position;
            return position;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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
	        	Intent intent= new Intent(MainActivity.this,PostPropertyActivity.class);
	        	startActivity(intent);
	          //finish();    
	        }

	    })
	    .setNegativeButton("No", null)
	    .show();
	}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
