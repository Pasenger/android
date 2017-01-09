package com.pasenger.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.pasenger.listviewtest.adapter.FruitAdapter;
import com.pasenger.listviewtest.model.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruits();

        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    private void initFruits(){
        Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
        fruitList.add(apple);

        Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
        fruitList.add(banana);

        Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
        fruitList.add(cherry);

        Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
        fruitList.add(grape);

        Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
        fruitList.add(mango);

        Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
        fruitList.add(orange);

        Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
        fruitList.add(pear);

        Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
        fruitList.add(pineapple);

        Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
        fruitList.add(strawberry);

        Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
        fruitList.add(watermelon);

        Fruit apple1 = new Fruit("Apple", R.drawable.apple_pic);
        fruitList.add(apple1);

        Fruit banana1 = new Fruit("Banana", R.drawable.banana_pic);
        fruitList.add(banana1);

        Fruit cherry1 = new Fruit("Cherry", R.drawable.cherry_pic);
        fruitList.add(cherry1);

        Fruit grape1 = new Fruit("Grape", R.drawable.grape_pic);
        fruitList.add(grape1);

        Fruit mango1 = new Fruit("Mango", R.drawable.mango_pic);
        fruitList.add(mango1);

        Fruit orange1 = new Fruit("Orange", R.drawable.orange_pic);
        fruitList.add(orange1);

        Fruit pear1 = new Fruit("Pear", R.drawable.pear_pic);
        fruitList.add(pear1);

        Fruit pineapple1 = new Fruit("Pineapple", R.drawable.pineapple_pic);
        fruitList.add(pineapple1);

        Fruit strawberry1 = new Fruit("Strawberry", R.drawable.strawberry_pic);
        fruitList.add(strawberry1);

        Fruit watermelon1 = new Fruit("Watermelon", R.drawable.watermelon_pic);
        fruitList.add(watermelon1);
    }
}
