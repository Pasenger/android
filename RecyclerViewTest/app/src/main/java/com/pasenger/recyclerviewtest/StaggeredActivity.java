package com.pasenger.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.pasenger.recyclerviewtest.adapter.FruitStaggeredAdapter;
import com.pasenger.recyclerviewtest.adapter.FruitVerticalAdapter;
import com.pasenger.recyclerviewtest.model.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StaggeredActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.staggered_recycler_view);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        initFruits();

        FruitStaggeredAdapter adapter = new FruitStaggeredAdapter(fruitList);

        recyclerView.setAdapter(adapter);

    }

    private void initFruits(){
        Fruit apple = new Fruit(getRandomLengthName("Apple"), R.drawable.apple_pic);
        fruitList.add(apple);

        Fruit banana = new Fruit(getRandomLengthName("Banana"), R.drawable.banana_pic);
        fruitList.add(banana);

        Fruit cherry = new Fruit(getRandomLengthName("Cherry"), R.drawable.cherry_pic);
        fruitList.add(cherry);

        Fruit grape = new Fruit(getRandomLengthName("Grape"), R.drawable.grape_pic);
        fruitList.add(grape);

        Fruit mango = new Fruit(getRandomLengthName("Mango"), R.drawable.mango_pic);
        fruitList.add(mango);

        Fruit orange = new Fruit(getRandomLengthName("Orange"), R.drawable.orange_pic);
        fruitList.add(orange);

        Fruit pear = new Fruit(getRandomLengthName("Pear"), R.drawable.pear_pic);
        fruitList.add(pear);

        Fruit pineapple = new Fruit(getRandomLengthName("Pineapple"), R.drawable.pineapple_pic);
        fruitList.add(pineapple);

        Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"), R.drawable.strawberry_pic);
        fruitList.add(strawberry);

        Fruit watermelon = new Fruit(getRandomLengthName("Watermelon"), R.drawable.watermelon_pic);
        fruitList.add(watermelon);

        Fruit apple1 = new Fruit(getRandomLengthName("Apple"), R.drawable.apple_pic);
        fruitList.add(apple1);

        Fruit banana1 = new Fruit(getRandomLengthName("Banana"), R.drawable.banana_pic);
        fruitList.add(banana1);

        Fruit cherry1 = new Fruit(getRandomLengthName("Cherry"), R.drawable.cherry_pic);
        fruitList.add(cherry1);

        Fruit grape1 = new Fruit(getRandomLengthName("Grape"), R.drawable.grape_pic);
        fruitList.add(grape1);

        Fruit mango1 = new Fruit(getRandomLengthName("Mango"), R.drawable.mango_pic);
        fruitList.add(mango1);

        Fruit orange1 = new Fruit(getRandomLengthName("Orange"), R.drawable.orange_pic);
        fruitList.add(orange1);

        Fruit pear1 = new Fruit(getRandomLengthName("Pear"), R.drawable.pear_pic);
        fruitList.add(pear1);

        Fruit pineapple1 = new Fruit(getRandomLengthName("Pineapple"), R.drawable.pineapple_pic);
        fruitList.add(pineapple1);

        Fruit strawberry1 = new Fruit(getRandomLengthName("Strawberry"), R.drawable.strawberry_pic);
        fruitList.add(strawberry1);

        Fruit watermelon1 = new Fruit(getRandomLengthName("Watermelon"), R.drawable.watermelon_pic);
        fruitList.add(watermelon1);
    }

    private String getRandomLengthName(String name){
        Random random = new Random();
        int len = random.nextInt(20) + 1;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++){
            builder.append(name);
        }

        return builder.toString();
    }
}
