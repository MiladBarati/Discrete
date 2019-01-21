package com.example.milad.discrete;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private int numOfTabs;

    PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;

        switch (position) {
            case 0:
                fragment = new R1Fragment();

                return fragment;

            case 1:
                fragment = new R2Fragment();

                return fragment;

            case 2:
                fragment = new RRFragment();

                return fragment;

            default:
                return null;
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
