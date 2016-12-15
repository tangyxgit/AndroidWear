package com.tangyx.wear.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.FragmentGridPagerAdapter;

import com.tangyx.wear.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangyx on 2016/12/14.
 *
 */

public class SampleGridPagerAdapter extends FragmentGridPagerAdapter {
    /**o
     * 一共有多少行（上下滑动的页面）
     */
    private List<Row> mRows;

    /**
     *上下滑动的页面
     */
    private static class Row{
        /**
         * 每一个上下滑动页面里面又有多少个其他页面内容
         * （左右滑动的页面）
         */
        List<Page> pages;
        Row(){
            pages = new ArrayList<>();
        }

        /**
         * 添加页面
         * @param page
         */
        void addPages(Page page){
            pages.add(page);
        }

        /**
         * 每一行左右页面的总数
         * @return
         */
        int size(){
            return pages.size();
        }

        /**
         * 获取左右滑动的页面
         * @param i
         * @return
         */
        Page getPage(int i){
            return pages.get(i);
        }
    }

    /**
     * 每一行左右滑动页面的内容
     */
    private static class Page {
        String title;
        String text;
        int iconRes;

        Page(String title, String text, int iconRes) {
            this.title = title;
            this.text = text;
            this.iconRes = iconRes;
        }
    }



    public SampleGridPagerAdapter(FragmentManager fm) {
        super(fm);
        mRows = new ArrayList<>();
        initData();
    }

    /**
     * 初始化模拟数据
     */
    private void initData(){
        Row row1 = new Row();
        row1.addPages(new Page("标题1","内容1",0));
        row1.addPages(new Page("标题2","内容2",R.mipmap.ic_launcher));
        row1.addPages(new Page("标题3","内容3",R.mipmap.ic_launcher));

        Row row2 = new Row();
        row2.addPages(new Page("标题4","内容5",R.mipmap.ic_launcher));
        row2.addPages(new Page("标题6","内容6",0));

        Row row3 = new Row();
        row3.addPages(new Page("标题7","内容5",R.mipmap.ic_launcher));

        mRows.add(row1);
        mRows.add(row2);
        mRows.add(row3);
    }


    @Override
    public Fragment getFragment(int i, int i1) {
        Page page = mRows.get(i).getPage(i1);
        String title = page.title;
        String text = page.text;
        int icon = page.iconRes;
        if(icon==0){
            return CardFragment.create(title,text);
        }
        return CardFragment.create(title,text,icon);
    }

    /**
     * 上下页面的数量
     * @return
     */
    @Override
    public int getRowCount() {
        return mRows.size();
    }

    /**
     * 每一个上下滑动页面的左右滑动页面
     * @param i
     * @return
     */
    @Override
    public int getColumnCount(int i) {
        return mRows.get(i).size();
    }
}
