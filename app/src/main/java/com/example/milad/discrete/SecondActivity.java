package com.example.milad.discrete;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        viewPager = findViewById(R.id.simpleViewPager);
        tabLayout = findViewById(R.id.simpleTabLayout);

        TabLayout.Tab firstTab = tabLayout.newTab();

        firstTab.setText("R1");
        tabLayout.addTab(firstTab);

        TabLayout.Tab secondTab = tabLayout.newTab();

        secondTab.setText("R2");
        tabLayout.addTab(secondTab);

        TabLayout.Tab thirdTab = tabLayout.newTab();

        thirdTab.setText("R1 & R2");
        tabLayout.addTab(thirdTab);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
