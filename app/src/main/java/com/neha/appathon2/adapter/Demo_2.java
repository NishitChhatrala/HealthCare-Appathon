package com.neha.appathon2.adapter;

/**
 * Created by DELL I5547 on 10-04-2016.
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.neha.appathon2.Booking;
import com.neha.appathon2.MainActivity;
import com.neha.appathon2.NatureItem;
import com.neha.appathon2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edwin on 18/01/2015.
 */

public class Demo_2 extends RecyclerView.Adapter<Demo_2.ViewHolder> {

    List<NatureItem> mItems;
    Context context;
    Button call;
    Button msg;
    //SharedPreferences sharedPreferences;
    public Demo_2(Context context) {
        super();

        this.context = context;
        mItems = new ArrayList<NatureItem>();
        NatureItem nature = new NatureItem();
        nature.setName("Dr 1");
        mItems.add(nature);

        nature = new NatureItem();
        nature.setName("Dr 2");
        mItems.add(nature);

        nature = new NatureItem();
        nature.setName("Dr 3");
        mItems.add(nature);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {



        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);

        msg = (Button)v.findViewById(R.id.msg);
        call = (Button)v.findViewById(R.id.call);



        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(), "Hi", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+91-990-950-2843"));
                try{
                    context.startActivity(i);
                }

                catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(v.getContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
                }
            }



        });


        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context.getApplicationContext(), Booking.class);
                context.startActivity(i);

            }
        });

        return viewHolder;




    }



    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        NatureItem nature = mItems.get(i);
        viewHolder.tvDesNature.setText(nature.getName());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvDesNature;

        public ViewHolder(final View itemView) {
            super(itemView);

            CardView cardView = (CardView) itemView.findViewById(R.id.card_view);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(context, MainActivity.class);
                    i.putExtra("code", mItems.get(getAdapterPosition()).getName());
                    Bundle bndlanimation =
                            null;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        // bndlanimation = ActivityOptions.makeCustomAnimation(context, R.anim.zoom_in, R.anim.zoom_in).toBundle();
                        context.startActivity(i, bndlanimation);
                    }
                    else{
                        context.startActivity(i);
                    }
                }
            });
            tvDesNature = (TextView) itemView.findViewById(R.id._name);

        }

    }

}
