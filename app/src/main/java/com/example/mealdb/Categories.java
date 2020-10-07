package com.example.mealdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class Categories extends AppCompatActivity {
    AsyncHttpClient asyncHttpClient;
    RequestParams requestParams;
    ArrayList<String> id_list;
    ArrayList<String> name_list;
    ArrayList<String> description_list;
    ArrayList<String> image_list;
    RecyclerView recyclerView;

    String TAG="categories";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        asyncHttpClient=new AsyncHttpClient();
        requestParams=new RequestParams();
        id_list=new ArrayList<>();
        name_list=new ArrayList<>();
        description_list=new ArrayList<>();
        image_list=new ArrayList<>();
        recyclerView=findViewById(R.id.categ_r_v);

        asyncHttpClient.get(Api.categoryurl,requestParams,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                JSONObject jsonObject=response;
                try {
                    JSONArray array=jsonObject.getJSONArray("categories");
                    for(int i=0;i<array.length();i++){
                        JSONObject object=array.getJSONObject(i);
                        String id=object.getString("idCategory");
                        //id_list.add(id);
                        String name=object.getString("strCategory");
                        name_list.add(name);
                        String description=object.getString("strCategoryDescription");
                        //description_list.add(description);
                        String image=object.getString("strCategoryThumb");
                        image_list.add(image);



                    }
                    LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(new Adapter(name_list,image_list,id_list,Categories.this,TAG));

                }catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        });

    }
}
