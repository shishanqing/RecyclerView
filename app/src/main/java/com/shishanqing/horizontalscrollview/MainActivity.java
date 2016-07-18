package com.shishanqing.horizontalscrollview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity
{

    private CopyOfMyRecyclerView mRecyclerView;
    private GalleryAdapter mAdapter;
    private List<Integer> mDatas;
    private ImageView mImg ;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mImg = (ImageView) findViewById(R.id.id_content);

        initDatas();
        //得到控件
        mRecyclerView = (CopyOfMyRecyclerView) findViewById(R.id.id_recyclerview_horizontal);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //设置适配器
        mAdapter = new GalleryAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);

        /*mRecyclerView.setOnItemScrollChangeListener(new CopyOfMyRecyclerView.OnItemScrollChangeListener() {
            @Override
            public void onChange(View view, int position) {
                mImg.setImageResource(mDatas.get(position));
            }

            ;
        });*/

        mAdapter.setOnItemClickLitener(new GalleryAdapter.OnItemClickLitener()
        {
            @Override
            public void onItemClick(View view, int position)
            {
                //Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();
                Log.d("ssq","position=====" + position + "get(position)===" + mDatas.get(position));
                mImg.setImageResource(mDatas.get(position));

            }
        });
        mRecyclerView.setAdapter(mAdapter);


    }


    private void initDatas()
    {
        mDatas = new ArrayList<Integer>(Arrays.asList(R.drawable.a,
                R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
                R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.l));
    }

}
