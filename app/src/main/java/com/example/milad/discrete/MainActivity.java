package com.example.milad.discrete;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public String collection, xy;
    EditText a, r1, r2, xyText;
    Button btn;
    List<String> xr1, xr2, yr1, yr2, coll;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.a);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        btn = findViewById(R.id.button);
        xyText = findViewById(R.id.xy);
        xr1 = new ArrayList<>();
        xr2 = new ArrayList<>();
        yr1 = new ArrayList<>();
        yr2 = new ArrayList<>();
        coll = new ArrayList<>();

        final Intent intent = new Intent(this, SecondActivity.class);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Build A collection
                collection = a.getText().toString();

                Collection collection1 = new Collection(collection);

                collection1.buildCollection();

                // Build R1 relation
                String s1;

                collection = r1.getText().toString();
                xy = xyText.getText().toString();

                RelationOne one = new RelationOne(collection, xy);

                one.buildROne();
                xr1 = one.getX();
                yr1 = one.getY();
                s1 = "";

                // Build R2 relation
                collection = r2.getText().toString();

                RelationTwo two = new RelationTwo(collection, xy);

                two.buildRTwo();
                xr2 = two.getX();
                yr2 = two.getY();

                // Go to next activity
                startActivity(intent);

                // Build relations interaction
                Relations relations = new Relations();

                relations.buildRelations();
            }
        });
    }

    public List<String> getA() {
        return coll;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
