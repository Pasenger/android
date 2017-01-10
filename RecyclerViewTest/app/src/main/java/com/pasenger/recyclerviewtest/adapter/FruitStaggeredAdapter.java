package com.pasenger.recyclerviewtest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pasenger.recyclerviewtest.R;
import com.pasenger.recyclerviewtest.model.Fruit;

import java.util.List;

/**
 * Created by pasenger on 2017/1/10.
 */

public class FruitStaggeredAdapter extends RecyclerView.Adapter<FruitStaggeredAdapter.ViewHolder> {

    private List<Fruit> mFruitList;

    public FruitStaggeredAdapter(List<Fruit> mFruitList) {
        this.mFruitList = mFruitList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View itemView) {
            super(itemView);

            fruitView = itemView;
            fruitImage = (ImageView) itemView.findViewById(R.id.fruit_s_iamge);
            fruitName = (TextView) itemView.findViewById(R.id.fruit_s_name);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item_staggered, parent, false);

        final ViewHolder holder = new ViewHolder(view);

        holder.fruitView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();

                Fruit fruit = mFruitList.get(position);

                Toast.makeText(v.getContext(), "Clickd view: " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();

                Fruit fruit = mFruitList.get(position);

                Toast.makeText(v.getContext(), "Clicked Image: " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);

        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
