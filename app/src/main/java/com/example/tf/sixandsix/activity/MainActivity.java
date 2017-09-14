package com.example.tf.sixandsix.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.tf.sixandsix.R;
import com.example.tf.sixandsix.adapter.HomePagerViewPagerAdapter;
import com.example.tf.sixandsix.fragment.DrinkFragment;
import com.example.tf.sixandsix.fragment.EatFragment;
import com.example.tf.sixandsix.fragment.LaughFragment;
import com.example.tf.sixandsix.fragment.PlayFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] tabArr = new String[]{"吃", "喝", "玩", "乐"};
    private List<Fragment> fragmentList;
    private HomePagerViewPagerAdapter adapter;
    private String backgroundImageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505367897177&di=390eda1cd86340daf5e8bc9ae0923182&imgtype=0&src=http%3A%2F%2Fimg1.mydrivers.com%2Fimg%2F20141111%2Fe7c3c39dc12f458f9e6417215439a8cc.jpg";
    private String headerImageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505972513&di=66b12a097e4b465a4927cba19e4ab048&imgtype=jpg&er=1&src=http%3A%2F%2Ffile.popoho.com%2F2016-07-22%2Fa648063b73893b4b2940e124b97b3238.jpg";
    private NavigationView nv;
    private DrawerLayout drawerLayout;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_main);

        initViews();

        //给TabLayout添加标签
        tab();

        viewpager();

        navigationView();
    }

    private void navigationView() {
        View v = nv.getHeaderView(0);
        nv.setItemIconTintList(null);
        ImageView backgroundImage = v.findViewById(R.id.menu_homepager_iv);
        CircleImageView headerImage = v.findViewById(R.id.menu_homepager_headerImage);
        TextView nickname = v.findViewById(R.id.menu_homepager_nickname);
        Glide.with(this).load(R.drawable.header_layout_background).into(backgroundImage);
        Glide.with(this).load(headerImageUrl).into(headerImage);
        nickname.setText("aaa");

        nv.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.homepager_menu_collection:
                    break;
                case R.id.homepager_menu_love:
                    break;
                case R.id.homepager_menu_history:
                    break;
                case R.id.homepager_menu_news:
                    break;
                case R.id.homepager_menu_setting:
                    break;
                case R.id.homepager_menu_clearCache:

                    //清理缓存
                    Observable.create((ObservableOnSubscribe<String>) e -> {
                        Toast.makeText(MainActivity.this, "正在清理，请稍后", Toast.LENGTH_SHORT).show();
                        e.onNext("1");
                    }).sample(5, TimeUnit.SECONDS)
                            .subscribeOn(AndroidSchedulers.mainThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(s -> {
                                if (s.equals("1"))
                                    Toast.makeText(MainActivity.this, "清理成功", Toast.LENGTH_SHORT).show();
                            });
                    break;
            }
            Log.e(TAG, "onNavigationItemSelected: " + item.getItemId());
            return true;
        });

    }


    private void viewpager() {
        fragmentList.add(new EatFragment());
        fragmentList.add(new DrinkFragment());
        fragmentList.add(new PlayFragment());
        fragmentList.add(new LaughFragment());
        adapter = new HomePagerViewPagerAdapter(getFragmentManager(), fragmentList, this);

        //viewpager

        viewPager.setAdapter(adapter);

    }

    private void tab() {
        int i = 0;
        for (; i < tabArr.length; ) {
            tabLayout.addTab(tabLayout.newTab().setText(tabArr[i]));
            i++;
        }
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.lightseagreen));
        tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.white), ContextCompat.getColor(this, R.color.red));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.red));
        tabLayout.setupWithViewPager(viewPager);

        toolbar.setNavigationOnClickListener(view -> {
            drawerLayout.openDrawer(Gravity.START);
        });
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
    }

    private void initViews() {
        toolbar = findViewById(R.id.homepager_toolabr);
        tabLayout = findViewById(R.id.homepager_tab);
        viewPager = findViewById(R.id.homepager_vp);
        fragmentList = new ArrayList<>();
        nv = findViewById(R.id.nv);
        drawerLayout = findViewById(R.id.homepager_drawerLayout);
    }

}

