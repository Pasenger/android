package com.pasenger.recyclerviewtest.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pasenger.recyclerviewtest.R;
import com.pasenger.recyclerviewtest.model.Fruit;

import java.util.List;

/**
 * Created by pasenger on 2017/1/10.
 */

public class FruitVerticalAdapter extends RecyclerView.Adapter<FruitVerticalAdapter.ViewHolder>{

    private List<Fruit> mFruitList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item_vertical, parent, false);

        ViewHolder holder = new ViewHolder(view);

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

    public FruitVerticalAdapter(List<Fruit> mFruitList) {
        this.mFruitList = mFruitList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View itemView) {
            super(itemView);

            fruitImage = (ImageView) itemView.findViewById(R.id.fruit_iamge);
            fruitName = (TextView) itemView.findViewById(R.id.fruit_name);
        }
    }


}
