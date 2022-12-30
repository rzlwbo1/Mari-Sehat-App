package com.example.marisehat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class KaloriFood extends AppCompatActivity {

    EditText etFoodDrink;
    TextView itemFood1, energy1, prot1, fat1, carb1;
    TextView itemFood2, energy2, prot2, fat2, carb2;
    Button btnProses;
    String temqty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalori_food);

        // get id
        etFoodDrink = findViewById(R.id.etFood);
        itemFood1 = findViewById(R.id.itemFood1);
        energy1 = findViewById(R.id.tvEnergy);
        prot1 = findViewById(R.id.tvProtein);
        fat1 = findViewById(R.id.tvFat);
        carb1 = findViewById(R.id.tvCarbo);

        itemFood2 = findViewById(R.id.itemFood2);
        energy2 = findViewById(R.id.tvEnergy2);
        prot2 = findViewById(R.id.tvProtein2);
        fat2 = findViewById(R.id.tvFat2);
        carb2 = findViewById(R.id.tvCarbo2);

        btnProses = findViewById(R.id.btnProses);

        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // request
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

                // url
                String url = "https://api.edamam.com/api/food-database/v2/parser?app_id=90ff0aee&app_key=98d51cf499d49f89f55e7148703b361e&ingr=" + etFoodDrink.getText().toString();
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONObject foodObj1 = jsonObject.getJSONArray("parsed").getJSONObject(0); // parsed

                            String foodName = foodObj1.getJSONObject("food").getString("label");
                            String energy = foodObj1.getJSONObject("food").getJSONObject("nutrients").getString("ENERC_KCAL");
                            String prot = foodObj1.getJSONObject("food").getJSONObject("nutrients").getString("PROCNT");
                            String fat = foodObj1.getJSONObject("food").getJSONObject("nutrients").getString("FAT");
                            String carbo = foodObj1.getJSONObject("food").getJSONObject("nutrients").getString("CHOCDF");


                            itemFood1.setText(foodName);
                            energy1.setText("Energy : " + energy + " kcal" );
                            prot1.setText("Protein : " + prot + " g");
                            fat1.setText("Fat : " + fat + " g");
                            carb1.setText("Carbo : " + carbo + " g");

                            JSONObject foodObj2 = jsonObject.getJSONArray("parsed").getJSONObject(1); // parsed

                            foodName = foodObj2.getJSONObject("food").getString("label");
                            energy = foodObj2.getJSONObject("food").getJSONObject("nutrients").getString("ENERC_KCAL");
                            prot = foodObj2.getJSONObject("food").getJSONObject("nutrients").getString("PROCNT");
                            fat = foodObj2.getJSONObject("food").getJSONObject("nutrients").getString("FAT");
                            carbo = foodObj2.getJSONObject("food").getJSONObject("nutrients").getString("CHOCDF");


                            itemFood2.setText(foodName);
                            energy2.setText("Energy : " + energy + " kcal" );
                            prot2.setText("Protein : " + prot + " g");
                            fat2.setText("Fat : " + fat + " g");
                            carb2.setText("Carbo : " + carbo + " g");

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                queue.add(stringRequest);
            }
        });
    }

}