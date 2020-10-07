package com.example.mealdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.harishpadmanabh.apppreferences.AppPreferences;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class Description extends AppCompatActivity {
    TextView des_name;
    ImageView des_img;
    ArrayList<String> name_list;
    ArrayList<String> img_list;
    ArrayList<String> id_list;
    RecyclerView recyclerView;

    AsyncHttpClient asyncHttpClient;
    RequestParams requestParams;
    String TAG="description";


    AppPreferences appPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        name_list=new ArrayList<>();
        img_list=new ArrayList<>();
        id_list=new ArrayList<>();
        recyclerView=findViewById(R.id.des_rv);
        appPreferences = AppPreferences.getInstance(this, getResources().getString(R.string.app_name));

        String selectedCat=appPreferences.getData("catname");
        String selectedId=appPreferences.getData("selectedid");
       // String selected_img=appPreferences.getData("cat_img");

        asyncHttpClient=new AsyncHttpClient();
        requestParams=new RequestParams();

        requestParams.put("c",selectedCat);

        asyncHttpClient.get(Api.item_url,requestParams,new JsonHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                JSONObject jsonObject=response;
                try {

                    JSONArray array=jsonObject.getJSONArray("meals");
                    for(int i=0;i<array.length();i++)
                    {
                        JSONObject object = array.getJSONObject(i);
                        String name=object.getString("strMeal");
                        Log.e("nameee",name);
                        name_list.add(name);
                        String thumb_img=object.getString("strMealThumb");
                        img_list.add(thumb_img);
                        String id=object.getString("idMeal");
                        id_list.add(id);

                    }

                  GridLayoutManager LayoutManager=new GridLayoutManager(getApplicationContext(),2);
                    recyclerView.setLayoutManager(LayoutManager);
                    recyclerView.setAdapter(new Adapter(name_list,img_list,id_list,Description.this,TAG));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });



    }
}
