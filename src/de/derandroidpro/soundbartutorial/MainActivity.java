package de.derandroidpro.soundbartutorial;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	

	public ListView lv1;
	public String[] soundnamen = {"Alarm","Böller","Donner","Drucker","Fliege","Glocke","PC Maus","Scherben klirren","Tastatur","Telefonklingeln","Wisch 1","Wisch 2"};
	public int[] soundId = {R.raw.alarm , R.raw.boeller , R.raw.donner , R.raw.drucker , R.raw.fliege , R.raw.glocke , R.raw.pc_maus , R.raw.scherben , R.raw.tastatur , R.raw.telefon , R.raw.wisch1 ,R.raw.wisch2 };
	
	public ArrayAdapter<String> listapdapter;
	
	public MediaPlayer mp1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mp1 = MediaPlayer.create(this,R.raw.alarm );
		
		
		lv1 = (ListView) findViewById(R.id.listView1);
		
		listapdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, soundnamen);
		lv1.setAdapter(listapdapter);
		lv1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view1, int arg2,
					long arg3) {
			
				
				mp1.release();
				mp1 = MediaPlayer.create(MainActivity.this, soundId[lv1.getPositionForView(view1)]);
				
				mp1.start();
				
				
				
				
			}
		});
		
	}


	@Override
	protected void onPause() {
		mp1.stop();
		super.onPause();
	}
	
}
