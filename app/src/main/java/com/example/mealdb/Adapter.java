package com.example.mealdb;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.harishpadmanabh.apppreferences.AppPreferences;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.My_vh>{
    ArrayList<String> name_list;
    ArrayList<String> img_list;
    ArrayList<String> id_list;
    Context context;

    public Adapter(ArrayList<String> name_list, ArrayList<String> img_list,ArrayList<String> id_list, Context context, String TAG) {
        this.name_list = name_list;
        this.img_list = img_list;
        this.id_list= id_list;
        this.context = context;
        this.TAG = TAG;
    }

    String TAG;

    AppPreferences appPreferences;


    public Adapter(ArrayList<String> name_list, ArrayList<String> img_list,ArrayList<String> id_list, Context context) {
        this.name_list = name_list;
        this.img_list = img_list;
        this.id_list=id_list;
        this.context = context;
    }


    @NonNull
    @Override
    public My_vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View my_view = null;
       if(TAG.equals("categories")) {
          my_view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.shape, viewGroup, false);
       }
       else if(TAG.equals("description")) {
           my_view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.spare, viewGroup, false);
       }
           appPreferences = AppPreferences.getInstance(context, context.getResources().getString(R.string.app_name));

           return new My_vh(my_view);


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(@NonNull My_vh holder, final int position) {

        holder.itemView.setBackgroundResource(R.drawable.background);
        holder.name.setText(name_list.get(position));

        Glide.with(context).load(img_list.get(position)).placeholder(R.drawable.ic_launcher_background).into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TAG.equals("categories")) {

                    String selectedCat = name_list.get(position);
                    appPreferences.saveData("catname", selectedCat);
                    ///ppPreferences.saveData("cat_img",selected_img);


                    Intent intent = new Intent(context, Description.class);
                    //to pass intent
                    context.startActivity(intent);

                }
                else
                {
                    String selectedId= id_list.get(position);
                    appPreferences.saveData("selectedid", selectedId);
                    Intent intent=new Intent(context,MealDesc.class);
                    context.startActivity(intent);
                }




            }
        });



    }

    @Override
    public int getItemCount() {
        return name_list.size();
    }

    class My_vh extends RecyclerView.ViewHolder{
        TextView name;
        ImageView image;


        public My_vh(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.categ_name);
            image=itemView.findViewById(R.id.categ_img);
        }
    }

}
