package br.app.mvictor.activities;
import android.content.Context;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import com.android.volley.toolbox.*;
import com.android.volley.*;
import org.json.*;

public class MyAPI
{
	private static final String API_URL = "https://mvictor10.github.io/lista.json";
	
	public static void getData(final Context contexto, final ListView listView, final ArrayAdapter<String> adapter){
	
		JsonObjectRequest JsonObjectRequest = new JsonObjectRequest(Request.Method.GET, API_URL, null, new Response.Listener<JSONObject>(){
			@Override
			public void onResponse(JSONObject response){
				
			}
		}, new Response.ErrorListener(){
			@Override
			public void onErrorResponse(VolleyError error){
				
			}
		});
		
	}
}
