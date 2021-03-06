package com.example.hp1.myfinalproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hp1.myfinalproject.classes.Madaneyat;

public class MainActivity extends Activity implements OnClickListener{
	Button btexplination,bttests,btvolenteer,bthomework;
	ImageView imb;
	Intent intent;
    

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		intent=getIntent();//to get the information for this intent
		btexplination=(Button)findViewById(R.id.btexplinations);
		bttests=(Button)findViewById(R.id.bttests);
		btvolenteer=(Button)findViewById(R.id.btvolenteer);
		bthomework=(Button)findViewById(R.id.bthomework);
		imb=(ImageView) findViewById(R.id.imvProfPic);
		imb.setImageResource(R.drawable.nopicture);
		btexplination.setOnClickListener(this);
		bttests.setOnClickListener(this);
		btvolenteer.setOnClickListener(this);
		bthomework.setOnClickListener(this);
				imb.setOnClickListener(this);
		Intent intent=getIntent();
		if(intent.getBooleanExtra("boolean",false))//to check if we got information to change information
		{
			Bitmap b = BitmapFactory.decodeByteArray(
					getIntent().getByteArrayExtra("byteArray"),0,getIntent()
							.getByteArrayExtra("byteArray").length);//to turn the byte[] we got in intent back to bitmap
			imb.setImageBitmap(b);//to set image as the bitmap
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {//to create an options menu
		super.onCreateOptionsMenu(menu);
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu_main, menu);

		return super.onCreateOptionsMenu(menu);
	}

    @Override
    public boolean onOptionsItemSelected(MenuItem item)//to make the iteams for the options menu
    {
        switch (item.getItemId()) {
			case R.id.support:
				startActivity(new Intent(this, Madaneyat.class));
				return true;
			case R.id.suggestion:
				startActivity(new Intent(this, Explanation.class));
				return true;
		}
		return super.onOptionsItemSelected(item);
    }


	@Override
	public void onClick(View v) {
		if(v==btexplination)
		    startActivity(new Intent(this,Explanation.class));//to go to Explanation
		else
			if(v==bttests)
				startActivity(new Intent(this,Tests.class));//to go to Tests
			else
				if(v==btvolenteer) {
					Intent i = new Intent(this, Volunteer.class);
					i.putExtra("username from mainActivity", intent.getStringExtra("username from register"));//to transfer username to Volunteer
					startActivity(i);//to go to Volunteer
				}
				else
					if(v==bthomework){
						Intent i=new Intent(this,HomeWork.class);
						i.putExtra("username from mainActivity",intent.getStringExtra("username from register"));//to transfer username to HomeWork
						startActivity(i);//to go to HomeWork
                    }
					else {
						Intent i=new Intent(this, Profile.class);
						i.putExtra("username from mainActivity",intent.getStringExtra("username from register"));//to transfer username to Profile
						startActivity(i);//to go to Profile

					}

	}
}
