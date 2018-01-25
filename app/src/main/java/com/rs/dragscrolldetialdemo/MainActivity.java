package com.rs.dragscrolldetialdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.rs.dragscrolldetialdemo.dragdetial.service.BackGroundService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.sliding_tabhost)
    Button slidingTabhost;
    @BindView(R.id.sliding_viewpager)
    Button slidingViewpager;
    @BindView(R.id.sliding_webivew)
    Button slidingWebivew;
    @BindView(R.id.sliding_list)
    Button slidingList;
    @BindView(R.id.sliding_webview_list)
    Button slidingWebviewList;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
        Intent intent = new Intent(MainActivity.this, BackGroundService.class);
        startService(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    @OnClick({R.id.sliding_tabhost, R.id.sliding_viewpager, R.id.sliding_webivew, R.id.sliding_list, R.id.sliding_webview_list})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sliding_tabhost:

                startActivity( new Intent(MainActivity.this, FragmentTabHostSlidingLayoutActivity.class));
                break;
            case R.id.sliding_viewpager:
                startActivity(new Intent(MainActivity.this, ViewPagerlidingLayoutActivity.class));
                break;
            case R.id.sliding_webivew:
                startActivity( new Intent(MainActivity.this, DragWebViewActivity.class));
                break;
            case R.id.sliding_list:
                startActivity( new Intent(MainActivity.this, DragListViewActivity.class));
                break;
            case R.id.sliding_webview_list:
                Intent intent = new Intent(MainActivity.this, DragWebViewListActivity.class);
                startActivity(intent);
                break;
        }
    }
}
