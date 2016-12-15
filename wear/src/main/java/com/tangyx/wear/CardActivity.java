package com.tangyx.wear;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.CardFragment;

/**
 * Created by tangyx on 2016/12/12.
 *
 */

public class CardActivity extends WearableActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        //fragment管理器
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //初始化卡片容器
        CardFragment cardFragment = CardFragment.create("title","content",R.mipmap.ic_launcher);
        cardFragment.setExpansionDirection(2000);
        cardFragment.setExpansionEnabled(true);
        cardFragment.setExpansionFactor(10f);
        transaction.add(R.id.card_layout,cardFragment);
        transaction.commit();
    }
}
