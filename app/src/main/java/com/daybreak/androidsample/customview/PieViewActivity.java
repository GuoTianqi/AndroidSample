package com.daybreak.androidsample.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daybreak.androidsample.R;
import com.daybreak.androidsample.customview.data.PieData;
import com.daybreak.androidsample.customview.view.PieView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PieViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_view);
        setTitle("Pie View");

        PieView pieView = (PieView) findViewById(R.id.pie_view);
        ArrayList<PieData> pieDatas = new ArrayList<>();
        PieData pieData = new PieData("饼1", 20);
        pieDatas.add(pieData);

        pieData = new PieData("饼2", 40);
        pieDatas.add(pieData);

        pieData = new PieData("饼3", 80);
        pieDatas.add(pieData);

        pieData = new PieData("饼4", 160);
        pieDatas.add(pieData);

        pieView.setData(pieDatas);
    }
}
