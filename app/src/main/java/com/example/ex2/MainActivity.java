package com.example.ex2;


import java.util.Date;


import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	final String keyPressCount = "press-count";
	int pressCount =0;
	
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		
    	if (savedInstanceState != null)
    		this.pressCount =  savedInstanceState.getInt ("resumed");
    	else
    		this.pressCount =0;
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        
        ((EditText)findViewById(R.id.edit_lastname)).
        			addTextChangedListener(new HandleFieldContent());;
        Log.d(MyApp.MY_TAG, "MainActivity.onCreate() event");
    }

    @Override
	protected void onRestart() {
       	Log.d(MyApp.MY_TAG, "MainActivity.onRestart() event");
		super.onRestart();
	}

	@Override 
    protected void onStart() { 
    	super.onStart(); 
//    	String t = DateFormat.getTimeFormat(this).format(new Date(0)); 
    	Log.d(MyApp.MY_TAG, "MainActivity.onStart() event");
    	}
    
    /** Called when the activity has become visible. */ 
    @Override 
    protected void onResume() { 
    	super.onResume(); 
    	Log.d(MyApp.MY_TAG, "MainActivity.onResume() event");
    	}

    protected void onPause() { 
    	super.onPause(); 
    	Log.d(MyApp.MY_TAG, "MainActivity.onPause() event");
    	} /** Called when the activity is no longer visible. */
    
    @Override 
    protected void onStop() { 
    	super.onStop(); 
    	Log.d(MyApp.MY_TAG, "MainActivity.onStop() event");
    	}  /** Called just before the activity is destroyed. */
    
    @Override public void onDestroy() { 
       	Log.d(MyApp.MY_TAG, "MainActivity.onDestroy() event");
    	super.onDestroy(); 
 
    	}
    
    @Override
    public void onSaveInstanceState(Bundle outState)
    {
    	outState.putInt (keyPressCount, this.pressCount);
    	super.onSaveInstanceState(outState);
    	Log.d(MyApp.MY_TAG, "MainActivity.onSaveInstanceState() event");

    }
    
    @Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	if (savedInstanceState != null)
    		this.pressCount = savedInstanceState.getInt(keyPressCount, 0);
   	 	Log.d(MyApp.MY_TAG, "MainActivity.onRestoreInstanceState() event");
		super.onRestoreInstanceState(savedInstanceState);
	}
  
    public void displayWelcomeMessage(View v){
    	pressCount++;
    	String text = "["+ pressCount + "] ";
    	EditText edName = (EditText) findViewById(R.id.edit_lastname);
    	String name = edName.getText().toString();
    	if (name.isEmpty())
        	Toast.makeText(this, text +"Wait! You should first enter your name above" , Toast.LENGTH_SHORT).show();
    	else{
    	   	Resources res = getResources();

        	text += String.format(res.getString(R.string.welcome), name);
        	Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    	}
 
    }
    
    private class HandleFieldContent implements TextWatcher{

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void afterTextChanged(Editable s) {
			
			Button c = (Button)findViewById(R.id.button1);
			c.setEnabled(!s.toString().isEmpty());;
			
		}
    	
    }
}
