package com.tangyx.wear;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.GridViewPager;

import com.tangyx.wear.adapter.SampleGridPagerAdapter;

/**
 * Created by tangyx on 2016/12/12.
 *
 */

public class GridViewPagerActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        GridViewPager mGridViewPager = (GridViewPager) findViewById(R.id.pager);
        mGridViewPager.setAdapter(new SampleGridPagerAdapter(getFragmentManager()));
    }
}
