package com.example.my0702;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.my0702.ChatFragment;
import com.example.my0702.StatusFragment;
//跳轉用程式碼
public class PagerAdaptermessage extends FragmentPagerAdapter {
    private  int numOfTabs;

    public PagerAdaptermessage(FragmentManager fm, int numOfTabs){
        super(fm);
        this.numOfTabs = numOfTabs;
    }



    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return  new message1Fragment();
            case 1:
                return new message2Fragment();
            default:
                return  null;
        }

    }

    @Override
    public int getCount() {
        return numOfTabs;

    }
}
