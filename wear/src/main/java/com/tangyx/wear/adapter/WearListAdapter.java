package com.tangyx.wear.adapter;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tangyx.wear.R;

import java.util.List;

/**
 * Created by tangyx on 2016/12/10.
 *
 */
public class WearListAdapter extends WearableListView.Adapter {
    /**
     * 全局上下文
     */
    private Context mContext;
    /**
     * 模拟数据
     */
    private List<String> mData;

    public WearListAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mData = datas;
    }

    @Override
    public WearableListView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.adapter_wear_list,null));
    }

    @Override
    public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
        String s = mData.get(position);
        viewHolder.mContent.setText(s);
        viewHolder.itemView.setTag(s);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    /**
     * 自定义item
     */
    static class ItemViewHolder extends WearableListView.ViewHolder{
        TextView mContent;
        ItemViewHolder(View itemView) {
            super(itemView);
            mContent = (TextView) itemView.findViewById(R.id.content);
        }
    }
}
