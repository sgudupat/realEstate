package com.square.realestate;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.square.domain.PropertyDetails;

public class GalleryViewActivity extends Activity {
    Gallery ga;
    //int width, height;
    LinearLayout layout;
    LinearLayout count_layout;
    Integer[] pics = {R.layout.required_property, R.layout.post_property};
    ImageView paging;
    float mLastMotionX;
    int count = 0;
    static TextView page_text[];
  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_view);
        layout = (LinearLayout) findViewById(R.id.galleryView);
      //  count_layout = (LinearLayout) findViewById(R.id.image_count);
      /*  Spinner propertyType1 = (Spinner) findViewById(R.id.property_expectedTypeSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.property_type, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner propertySpace1 = (Spinner) findViewById(R.id.property_expectedSpaceSpinner);
        ArrayAdapter<CharSequence> adapterSpace1 = ArrayAdapter.createFromResource(this, R.array.property_space, android.R.layout.simple_spinner_item);
        adapterSpace1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        propertyType1.setAdapter(adapter1);
        propertySpace1.setAdapter(adapterSpace1);
*/
/*        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        width = displaymetrics.heightPixels;
        height = displaymetrics.widthPixels;*/
        for (int i = 0; i < pics.length; i++) {
            paging = new ImageView(this);
            paging.setId(i);
            paging.setBackgroundResource(R.drawable.white);
            
            layout.addView(paging);
        }

        ga = (Gallery) findViewById(R.id.thisgallery); 
      //  count_layout=(LinearLayout)  findViewById(R.id.image_count);
        ga.setAdapter(new ImageAdapter(this));  
      
        count=ga.getAdapter().getCount();
        page_text = new TextView[count];
        
        for (int i = 0; i < count; i++) {
            page_text[i] = new TextView(this);
            page_text[i].setText(".");
            page_text[i].setTextSize(45);
            page_text[i].setTypeface(null, Typeface.BOLD);
            Log.i("Slide", "Red");
            page_text[i].setTextColor(android.graphics.Color.RED);
            count_layout.addView(page_text[i]);
            Log.i("Slide", "count_layout Red");
        }
        ga.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1,  View arg2, long arg3) {
                System.out.println("SELECTED : " + arg2);
                for (int i = 0; i < count; i++) {
                	GalleryViewActivity.page_text[i].setTextColor(android.graphics.Color.RED);
                	Log.i("slide selected", "slide red");
                     }
               // GalleryViewActivity.page_text[arg2].setTextColor(android.graphics.Color.GREEN);
                Log.i("slide selected", "slide green");
            }
            public void onNothingSelected(AdapterView<?> arg0) {
             
               
            }
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				   System.out.println("SELECTED : " + position);
	                for (int i = 0; i < count; i++) {
	                	GalleryViewActivity.page_text[i].setTextColor(android.graphics.Color.RED);
	                	Log.i("slide selected", "slide red");
	                     }
	                GalleryViewActivity.page_text[position].setTextColor(android.graphics.Color.GREEN);
	                Log.i("slide selected", "slide green");
				
			}
        });
        
    }
    
  
    public class ImageAdapter extends BaseAdapter {

        private Context ctx;
        int pre = -1;

        public ImageAdapter(Context c) {
            ctx = c;
        }

        public int getCount() {
            return pics.length;
        }

        public View getView(int arg0, View convertView, ViewGroup arg2) {
            View view = convertView;
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout layoutnew = new LinearLayout(getApplicationContext());
            layoutnew.setOrientation(LinearLayout.VERTICAL);

            if (view == null) {
               /* iv = new ImageView(ctx);
                iv.setImageResource(pics[arg0]);
                iv.setScaleType(ImageView.ScaleType.FIT_XY);
                int temp =(int) (height/1.7f);
                int temp_y = (int) ((3*temp)/2.0f);
                iv.setLayoutParams(new Gallery.LayoutParams(temp,temp_y));
                iv.setBackgroundResource(imageBackground);*/
            	
                view = inflater.inflate(pics[arg0], null);
              
             
            } else {
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
            return position;
        }

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

	

   /*     @Override
        public long getItemId(int position) {
            if (pre != -1) {
                ImageView img = (ImageView) findViewById(pre);
                img.setBackgroundResource(R.drawable.white);
                
            }
            ImageView img1 = (ImageView) findViewById(position);
            img1.setBackgroundResource(R.drawable.bluedot);
            
            this.pre = position;
            return position;
        }*/
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

        final PopupWindow pwindo = new PopupWindow(layout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        ListView listView = (ListView) layout.findViewById(R.id.property_popup_listview);
        //get txt view from "layout" which will be added into popup window
        //before it you tried to find view in activity container
      /*  TextView txt = (TextView) layout.findViewById(R.id.person_name);
        txt.setText(Html.fromHtml(getString(R.string.tos_text)));
        TextView txt1 = (TextView) layout.findViewById(R.id.contact_number);
        txt1.setText(Html.fromHtml(getString(R.string.tos_text1)));
        TextView txt2 = (TextView) layout.findViewById(R.id.ExpectedProperty);
        txt2.setText(Html.fromHtml(getString(R.string.tos_text2)));*/

        try {
            ArrayList<PropertyDetails> propList = new ArrayList<PropertyDetails>();
            propList.add(new PropertyDetails("sachin", "1BHK", "20,000,00"));
            propList.add(new PropertyDetails("rahul", "2BHK", "57,000,00"));
            propList.add(new PropertyDetails("sachin", "1BHK", "20,000,00"));
            propList.add(new PropertyDetails("rahul", "2BHK", "57,000,00"));
            propList.add(new PropertyDetails("sachin", "1BHK", "20,000,00"));
            propList.add(new PropertyDetails("rahul", "2BHK", "57,000,00"));
            propList.add(new PropertyDetails("sachin", "1BHK", "20,000,00"));
            propList.add(new PropertyDetails("rahul", "2BHK", "57,000,00"));
            propList.add(new PropertyDetails("sachin", "1BHK", "20,000,00"));
            propList.add(new PropertyDetails("rahul", "2BHK", "57,000,00"));
            propList.add(new PropertyDetails("sachin", "1BHK", "20,000,00"));
            propList.add(new PropertyDetails("rahul", "2BHK", "57,000,00"));
            PropertyAdapter adapter = new PropertyAdapter(this, propList);
            listView.setAdapter(adapter);

        }

        //show popup window after you have done initialization of views

        catch (Exception e) {
            e.printStackTrace();
        }
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
    }
    public void backProperty(View view){
    	 Intent intent = new Intent(GalleryViewActivity.this, MainActivity.class);
         startActivity(intent);
    }
    

    public void onBackPressed(View view) {
    	   Intent intent = new Intent(GalleryViewActivity.this, GalleryViewActivity.class);
           startActivity(intent);
       /* new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("REAL ESTATE")
                .setMessage("Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {*/
                    //@Override
                  /*  public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(GalleryViewActivity.this, PostPropertyActivity.class);
                        startActivity(intent);
                        //finish();
                    }})*/
/*
                })
                .setNegativeButton("No", null)
                .show();*/
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

    public void postRequirement(View view) {
        Intent intent = new Intent(this, PropertyRequirementActivity.class);
        startActivity(intent);
    }

    public void postProperty(View view) {
        Intent intent = new Intent(this, PostPropertyActivity.class);
        startActivity(intent);
    }
   
}
