package com.rs.dragscrolldetialdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;

import com.rs.dragscrolldetialdemo.dragdetial.DragDetailFragmentPagerAdapter;


public class SlideFragmentPagerAdapter extends DragDetailFragmentPagerAdapter {
    public SlideFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position % 2 == 0)
            return new FragmentItem2();
        return new FragmentItem1();
    }

    @Override
    public int getCount() {
        return 3;
    }

    private View mCurrentView;

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (object instanceof View) {
            mCurrentView = (View) object;
        } else if (object instanceof Fragment) {
            Fragment fragment = (Fragment) object;
            mCurrentView = fragment.getView();
        }
    }

    public View getPrimaryItem() {
        return mCurrentView;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Tab"+position;
    }
}