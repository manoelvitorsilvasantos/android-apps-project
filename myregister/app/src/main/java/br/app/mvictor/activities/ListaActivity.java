package br.app.mvictor.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import br.app.mvictor.R;
import android.support.v7.widget.*;
import android.support.v7.widget.SearchView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.view.*;
import android.widget.*;
import android.content.*;
import com.android.volley.toolbox.*;
import com.android.volley.*;
import org.json.*;
import java.util.*;


public class ListaActivity extends AppCompatActivity implements SearchView.OnQueryTextListener
{

	SearchView searchView; 
    ListView listView; 
	ArrayAdapter<String> adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);
		
		searchView = findViewById(R.id.searchView); 
		listView = findViewById(R.id.listView); 
		
		
		Dados myData = new Dados();
		
		RequestQueue queue = Volley.newRequestQueue(this);
		String url = "https://mvictor10.github.io/lista.json";
		
		
		
		JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null,
			new Response.Listener<JSONArray>() {
				@Override
				public void onResponse(JSONArray response) {
					try {
						List<String> minha_lista = new ArrayList<>();
						
						for(int i = 0; i < response.length(); i++){
							Dados dd = new Dados();
						
							JSONObject objecto = response.getJSONObject(i);
							dd.setNome(objecto.getString("nome"));
							minha_lista.add(dd.getNome());
						}
						
						
						adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, minha_lista);
						listView.setAdapter(adapter);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			}, new Response.ErrorListener() {
				@Override
				public void onErrorResponse(VolleyError error) {
					// Aqui você pode tratar erros
				}
			});

		queue.add(jsonObjectRequest);
		
		
		
		listView.setOnItemClickListener(new ListView.OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> adp, View view, int position, long id)
				{
					// TODO: Implement this method
					Intent i = new Intent(getApplicationContext(), InfoActivity.class);
					String nome = adp.getItemAtPosition(position).toString();
					i.putExtra("nome", nome);
					startActivity(i);
				}
		});
		
		searchView.setOnQueryTextListener(this); 
		 
    }
	
	@Override
	public boolean onQueryTextSubmit(String p1)
	{
		// TODO: Implement this method
		return false;
	}

	@Override
	public boolean onQueryTextChange(String p1)
	{
		// TODO: Implement this method
		String text = p1; 
		adapter.getFilter().filter(text); 
		return false; 
	}
	
	private void myToast(String message, Context contexto){
		Toast.makeText(contexto, message, Toast.LENGTH_LONG).show();
	}
}
