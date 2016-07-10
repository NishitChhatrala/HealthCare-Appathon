package com.neha.appathon2.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.neha.appathon2.MainActivity;
import com.neha.appathon2.NatureItem;
import com.neha.appathon2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edwin on 18/01/2015.
 */

public class Govt extends RecyclerView.Adapter<Govt.ViewHolder> {

    List<NatureItem> mItems;
    Context context;
    Button call;
    Button msg;
    //SharedPreferences sharedPreferences;
    public Govt(Context context) {
        super();

        this.context = context;
        mItems = new ArrayList<NatureItem>();
        NatureItem nature = new NatureItem();
        nature.setName("Polio Camp will be organized on coming sunday at DA-IICT from 9am to 12 pm.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum in eros ac libero fermentum tincidunt. Duis quis nibh quis dolor posuere consectetur. ");
        nature.setThumbnail(R.drawable.blood);
        mItems.add(nature);

        nature = new NatureItem();
        nature.setName("Blood donation camp took place last week at Ahmedabad. Nearly 150 people donated blood and was successfull camp.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum in eros ac libero fermentum tincidunt. Duis quis nibh quis dolor posuere consectetur. ");
        nature.setThumbnail(R.drawable.aurora_borealis);
        mItems.add(nature);

        nature = new NatureItem();
        nature.setName("Swatch Bharat Abhiyan was taken to new stage by intiative of government to give prizes to whom win the compition.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum in eros ac libero fermentum tincidunt. Duis quis nibh quis dolor posuere consectetur.  ");
        mItems.add(nature);


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {



        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view_govt, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);


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

            CardView cardView = (CardView) itemView.findViewById(R.id.card_view_govt);
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
            tvDesNature = (TextView) itemView.findViewById(R.id.text_govt);

        }

    }

}
