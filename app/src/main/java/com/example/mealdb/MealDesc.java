package com.example.mealdb;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.harishpadmanabh.apppreferences.AppPreferences;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MealDesc extends AppCompatActivity {
    AsyncHttpClient asyncHttpClient;
    RequestParams requestParams;
    AppPreferences appPreferences;
    ImageView strmealthumb;
    TextView strmeal,strcat,strarea,strinst,strtag,stryoutube,str_ing1,str_ing2,str_ing3,str_ing4,str_ing5,str_ing6,str_ing7,str_ing8,str_ing9,str_ing10,str_ing11,str_ing12,str_ing13,str_ing14,str_ing15,str_ing16,str_ing17,str_ing18,str_ing19,str_ing20,str_measure1,str_measure2,str_measure3,str_measure4,str_measure5,str_measure6,str_measure7,str_measure8,str_measure9,str_measure10,str_measure11,str_measure12,str_measure13,str_measure14,str_measure15,str_measure16,str_measure17,str_measure18,str_measure19,str_measure20,strsource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_desc);
        asyncHttpClient=new AsyncHttpClient();
        requestParams=new RequestParams();
        strmealthumb=findViewById(R.id.meal_img);
        //str_id=findViewById(R.id.strid);
        strmeal=findViewById(R.id.strmeal);
        strcat=findViewById(R.id.strcat);
        strarea=findViewById(R.id.strarea);
        strinst=findViewById(R.id.strinst);
        stryoutube=findViewById(R.id.stryoutube);
        strtag=findViewById(R.id.strtag);
        str_ing1=findViewById(R.id.ing1);
        str_ing2=findViewById(R.id.ing2);
        str_ing3=findViewById(R.id.ing3);
        str_ing4=findViewById(R.id.ing4);
        str_ing5=findViewById(R.id.ing5);
        str_ing6=findViewById(R.id.ing6);
        str_ing7=findViewById(R.id.ing7);
        str_ing8=findViewById(R.id.ing8);
        str_ing9=findViewById(R.id.ing9);
        str_ing10=findViewById(R.id.ing10);
        str_ing11=findViewById(R.id.ing11);
        str_ing12=findViewById(R.id.ing12);
        str_ing13=findViewById(R.id.ing13);
        str_ing14=findViewById(R.id.ing14);
        str_ing15=findViewById(R.id.ing15);
        str_ing16=findViewById(R.id.ing16);
        str_ing17=findViewById(R.id.ing17);
        str_ing18=findViewById(R.id.ing18);
        str_ing19=findViewById(R.id.ing19);
        str_ing20=findViewById(R.id.ing20);
        str_measure1=findViewById(R.id.meas1);
        str_measure2=findViewById(R.id.meas2);
        str_measure3=findViewById(R.id.meas3);
        str_measure4=findViewById(R.id.meas4);
        str_measure5=findViewById(R.id.meas5);
        str_measure6=findViewById(R.id.meas6);
        str_measure7=findViewById(R.id.meas7);
        str_measure8=findViewById(R.id.meas8);
        str_measure9=findViewById(R.id.meas9);
        str_measure10=findViewById(R.id.meas10);
        str_measure11=findViewById(R.id.meas11);
        str_measure12=findViewById(R.id.meas12);
        str_measure13=findViewById(R.id.meas13);
        str_measure14=findViewById(R.id.meas14);
        str_measure15=findViewById(R.id.meas15);
        str_measure16=findViewById(R.id.meas16);
        str_measure17=findViewById(R.id.meas17);
        str_measure18=findViewById(R.id.meas18);
        str_measure19=findViewById(R.id.meas19);
        str_measure20=findViewById(R.id.meas20);
        strsource=findViewById(R.id.strsource);




        appPreferences = AppPreferences.getInstance(this, getResources().getString(R.string.app_name));
        String selectedId=appPreferences.getData("selectedid");
        requestParams.put("i", selectedId);

         asyncHttpClient.get(Api.mealdesc_url,requestParams,new JsonHttpResponseHandler(){
             @Override
             public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                 super.onSuccess(statusCode, headers, response);

                 Toast.makeText(MealDesc.this,"response", Toast.LENGTH_SHORT).show();
                 JSONObject jsonObject=response;
                 try {
                     JSONArray array=jsonObject.getJSONArray("meals");
                     //for(int i=0;i<array.length();i++) {
                         JSONObject object = array.getJSONObject(0);


                         String mealstr = object.getString("strMeal");
                         strmeal.setText(mealstr);
                         String str_categ=object.getString("strCategory");
                         strcat.setText(str_categ);
                         String area=object.getString("strArea");
                         strarea.setText(area);
                         String inst=object.getString("strInstructions");
                         strinst.setText(inst);
                         String image=object.getString("strMealThumb");
                         Glide.with(MealDesc.this).load(image).placeholder(R.drawable.ic_launcher_background).into(strmealthumb);
                         String tag=object.getString("strTags");
                         strtag.setText(tag);
                         String youtube=object.getString("strYoutube");
                         stryoutube.setText(youtube);
                         String ing1=object.getString("strIngredient1");
                         str_ing1.setText(ing1);
                         String ing2=object.getString("strIngredient2");
                         str_ing2.setText(ing2);
                         String ing3=object.getString("strIngredient3");
                         str_ing3.setText(ing3);
                         String ing4=object.getString("strIngredient4");
                         str_ing4.setText(ing4);
                         String ing5=object.getString("strIngredient5");
                         str_ing5.setText(ing5);
                         String ing6=object.getString("strIngredient6");
                         str_ing6.setText(ing6);
                         String ing7=object.getString("strIngredient7");
                         str_ing7.setText(ing7);
                         String ing8=object.getString("strIngredient8");
                         str_ing8.setText(ing8);
                         String ing9=object.getString("strIngredient9");
                         str_ing9.setText(ing9);
                         String ing10=object.getString("strIngredient10");
                         str_ing10.setText(ing10);
                         String ing11=object.getString("strIngredient11");
                         str_ing11.setText(ing11);
                         String ing12=object.getString("strIngredient12");
                         str_ing12.setText(ing12);
                         String ing13=object.getString("strIngredient13");
                         str_ing13.setText(ing13);
                         String ing14=object.getString("strIngredient14");
                         str_ing14.setText(ing14);
                         String ing15=object.getString("strIngredient15");
                         str_ing15.setText(ing15);
                         String ing16=object.getString("strIngredient16");
                         str_ing16.setText(ing16);
                         String ing17=object.getString("strIngredient17");
                         str_ing17.setText(ing17);
                         String ing18=object.getString("strIngredient18");
                         str_ing18.setText(ing18);
                         String ing19=object.getString("strIngredient19");
                         str_ing19.setText(ing19);
                         String ing20=object.getString("strIngredient20");
                         str_ing20.setText(ing20);
                         String measure1=object.getString("strMeasure1");
                         str_measure1.setText(measure1);
                         String measure2=object.getString("strMeasure2");
                         str_measure2.setText(measure2);
                         String measure3=object.getString("strMeasure3");
                         str_measure3.setText(measure3);
                         String measure4=object.getString("strMeasure4");
                         str_measure4.setText(measure4);
                         String measure5=object.getString("strMeasure5");
                         str_measure5.setText(measure5);
                         String measure6=object.getString("strMeasure6");
                         str_measure6.setText(measure6);
                         String measure7=object.getString("strMeasure7");
                         str_measure7.setText(measure7);
                         String measure8=object.getString("strMeasure8");
                         str_measure8.setText(measure8);
                         String measure9=object.getString("strMeasure9");
                         str_measure9.setText(measure9);
                         String measure10=object.getString("strMeasure10");
                         str_measure10.setText(measure10);
                         String measure11=object.getString("strMeasure11");
                         str_measure11.setText(measure11);
                         String measure12=object.getString("strMeasure12");
                         str_measure12.setText(measure12);
                         String measure13=object.getString("strMeasure13");
                         str_measure13.setText(measure13);
                         String measure14=object.getString("strMeasure14");
                         str_measure14.setText(measure14);
                         String measure15=object.getString("strMeasure15");
                         str_measure15.setText(measure15);
                         String measure16=object.getString("strMeasure16");
                         str_measure16.setText(measure16);
                         String measure17=object.getString("strMeasure17");
                         str_measure17.setText(measure17);
                         String measure18=object.getString("strMeasure18");
                         str_measure18.setText(measure18);
                         String measure19=object.getString("strMeasure19");
                         str_measure19.setText(measure19);
                         String measure20=object.getString("strMeasure20");
                         str_measure20.setText(measure20);
                         String source=object.getString("strSource");
                         strsource.setText(source);














                 } catch (JSONException e) {
                     e.printStackTrace();
                 }
             }

             @Override
             public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                 super.onFailure(statusCode, headers, responseString, throwable);

                 Toast.makeText(MealDesc.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
             }
         });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
