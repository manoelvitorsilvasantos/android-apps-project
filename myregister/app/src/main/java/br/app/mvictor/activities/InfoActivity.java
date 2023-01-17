package br.app.mvictor.activities;

import android.os.*;
import android.support.v7.app.*;
import android.widget.*;
import br.app.mvictor.*;
import com.android.volley.*;
import com.android.volley.toolbox.*;
import com.squareup.picasso.*;
import org.json.*;

import com.android.volley.Request;

public class InfoActivity extends AppCompatActivity {
	
	private TextView txtnomecompleto, txtidade, txtprofissao, txtsexo, txtdn;
	private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
		
		txtnomecompleto = findViewById(R.id.nomecompleto);
		txtidade = findViewById(R.id.idade);
		txtsexo = findViewById(R.id.sexo);
		txtprofissao = findViewById(R.id.profissao);
		txtdn  = findViewById(R.id.aniversario);
		img = findViewById(R.id.profile_picture);
	
		final String texto = getIntent().getStringExtra("nome");
		Picasso.get().load(R.drawable.logo).into(img);
		RequestQueue queue = Volley.newRequestQueue(this);
		String url = "https://mvictor10.github.io/lista.json";

		JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null,
			new Response.Listener<JSONArray>() {
				@Override
				public void onResponse(JSONArray response) {
					try {
						
						
						
						for(int i = 0; i < response.length(); i++){
						    
			                JSONObject objecto = response.getJSONObject(i);
							
							String nome = objecto.getString("nome");
							
							
							if(nome.equals(texto)){
								Dados dd = new Dados();
						    	
								
								
								dd.setNome(nome);
								dd.setSobrenome(objecto.getString("sobrenome"));
								dd.setIdade(objecto.getInt("idade"));
								dd.setProfissao(objecto.getString("profissao"));
								dd.setDN(objecto.getString("dn"));
								dd.setSexo(objecto.getString("sexo"));
								
								txtnomecompleto.setText("Nome completo: " +dd.getNome() + " " + dd.getSobrenome());
								txtidade.setText("Idade "+String.valueOf(dd.getIdade()));
								txtsexo.setText("Sexo: " + dd.getSexo());
								txtprofissao.setText("Profissão: " +dd.getProfissao());
								txtdn.setText("DN: "+dd.getDN());
								break;
							
							}
						
						}
						
						
						
						
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
		
		
		
    }
	
}
