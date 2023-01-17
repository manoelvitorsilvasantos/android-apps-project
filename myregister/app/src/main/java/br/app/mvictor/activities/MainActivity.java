package br.app.mvictor.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import br.app.mvictor.R;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import android.content.*;
import com.android.volley.*;
import com.android.volley.toolbox.*;
import org.json.*;
import android.app.*;
import android.support.design.widget.*;

public class MainActivity extends AppCompatActivity {
	
	private TextInputEditText login, password;
	private Button botao_logar;

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		login = findViewById(R.id.login_input);
		password = findViewById(R.id.password_input);
	    botao_logar = findViewById(R.id.login_button);
		
		
		
		botao_logar.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View view)
				{
					// TODO: Implement this method
					final String usuario = login.getText().toString();
					final String senha = password.getText().toString();
					
					
					
					try{
						
							if(!usuario.isEmpty() && !senha.isEmpty()){
								RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
								String url = "http://127.0.0.1:3000/user.json";

								JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
									new Response.Listener<JSONObject>() {
										@Override
										public void onResponse(JSONObject response) {
											try {

												String user= response.getString("usuario");
												String pass = response.getString("senha");
												
												if(usuario.equals(user) && senha.equals(pass)){
													Intent i = new Intent(MainActivity.this, ListaActivity.class);
													startActivity(i);
												}
												else{
													myToast("Usuário ou Senha Incorreto", getApplicationContext());
												}


											} catch (JSONException e) {
												e.printStackTrace();
											}
										}
									}, new Response.ErrorListener() {
										@Override
										public void onErrorResponse(VolleyError error) {
											// Aqui você pode tratar erros
											myToast("Não foi possivel carregar o arquivo JSON", getApplicationContext());
										}
									});

								queue.add(jsonObjectRequest);
								
							}else{
								myToast("Você precisa fornecer o usuário e a senha", getApplicationContext());
							}

						
						
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
		});
    }
	
	
	private void myToast(String message, Context contexto){
		Toast.makeText(contexto, message, Toast.LENGTH_LONG).show();
	}
}
