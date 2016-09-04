package com.francis.zhihudaily_android.ui.activity;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import com.francis.zhihudaily_android.R;
import com.francis.zhihudaily_android.constant.Constants;
import com.francis.zhihudaily_android.ui.activity.base.BaseActivity;
import com.francis.zhihudaily_android.ui.fragment.MainFragment;
import com.francis.zhihudaily_android.utils.ActivityUtils;

public class MainActivity extends AppCompatActivity {

	private DrawerLayout mDrawerLayout;

	private Toolbar mToolbar;

	private MainFragment mMainFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);



		mToolbar = (Toolbar) findViewById(R.id.layout_toolbar);
		setSupportActionBar(mToolbar);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
		actionBar.setDisplayHomeAsUpEnabled(true);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.layout_drawer);
		mToolbar = (Toolbar) findViewById(R.id.layout_toolbar);
		mDrawerLayout.setStatusBarBackground(R.color.colorPrimaryDark);

		NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
		if (navigationView != null) {
			navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

				@Override
				public boolean onNavigationItemSelected(MenuItem item) {
					return false;
				}
			});
		}

		addFragment();

	}

	private void addFragment(){
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		if(mMainFragment != null){
			fragmentTransaction.remove(mMainFragment);
		}

		mMainFragment = MainFragment.newInstance();
		fragmentTransaction.add(R.id.main_framelayout, mMainFragment);
		fragmentTransaction.commit();
	}

}
