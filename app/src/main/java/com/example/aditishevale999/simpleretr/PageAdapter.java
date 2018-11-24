package com.example.aditishevale999.simpleretr;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PageAdapter(FragmentManager fm, int NumberofTabs) {
        super(fm);
        this.mNoOfTabs = NumberofTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Vegetablefragment tab1 = new Vegetablefragment();
                return tab1;
        }

        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
