package com.example.my0702;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
//跳轉用程式碼
public class PagerAdapter extends FragmentPagerAdapter {
    private  int numOfTabs;

    public PagerAdapter(FragmentManager fm,int numOfTabs){
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return  new ChatFragment();
            case 1:
                return new StatusFragment();
            default:
                return  null;
        }

    }

    @Override
    public int getCount() {
        return numOfTabs;

    }
}
