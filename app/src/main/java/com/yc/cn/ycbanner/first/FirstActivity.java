package com.yc.cn.ycbanner.first;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.yc.cn.ycbanner.R;
import com.yc.cn.ycbannerlib.first.BannerView;
import com.yc.cn.ycbannerlib.first.adapter.DynamicPagerAdapter;

/**
 * Created by PC on 2017/11/21.
 * 作者：PC
 * https://github.com/Jude95/RollViewPager/blob/master/README_ch.md
 */

public class FirstActivity extends AppCompatActivity {

    private int[] imgs = {
            R.drawable.bg_kites_min,
            R.drawable.bg_autumn_tree_min,
            R.drawable.bg_lake_min,
            R.drawable.bg_leaves_min,
            R.drawable.bg_magnolia_trees_min,
    };
    private BannerView banner;

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(banner!=null){
            banner.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(banner!=null){
            banner.resume();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        initBanner();
    }

    private void initBanner() {
        banner = (BannerView) findViewById(R.id.banner);
        banner.setPlayDelay(2000);
        banner.setAdapter(new ImageNormalAdapter());
        banner.setOnBannerClickListener(new BannerView.OnBannerClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(FirstActivity.this,position+"被点击呢",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class ImageNormalAdapter extends DynamicPagerAdapter {

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            view.setImageResource(imgs[position]);
            return view;
        }


        @Override
        public int getCount() {
            return imgs.length;
        }
    }

}
