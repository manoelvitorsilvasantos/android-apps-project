package br.app.mvictor.activities;
import android.app.*;
import com.android.volley.*;
import com.android.volley.toolbox.*;

public class MyApplication extends Application
{
	private static RequestQueue queue;
	
	@Override
	public void onCreate(){
		super.onCreate();
		queue = Volley.newRequestQueue(this);
	}
	
	public static RequestQueue getQueue(){

		return queue;
	}
}
