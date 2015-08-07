package com.wangyal.memory;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/**
 * 
 * 
 * @author wangyaL 2015年8月7日 下午4:15:30
 *
 */
public class MainActivity extends FragmentActivity implements OnClickListener {

	// 定义3个Fragment的对象
	private Fragment1 fg1;
	private Fragment2 fg2;
	private Fragment3 fg3;
	// 帧布局对象,就是用来存放Fragment的容器
	private FrameLayout flayout;
	// 定义底部导航栏的三个布局
	private RelativeLayout course_layout;
	private RelativeLayout found_layout;
	private RelativeLayout settings_layout;
	// 定义底部导航栏中的ImageView与TextView
	private ImageView course_image;
	private ImageView found_image;
	private ImageView settings_image;
	private TextView course_text;
	private TextView settings_text;
	private TextView found_text;
	// 定义要用的颜色值
	private int whirt = 0xFFFFFFFF;
	private int gray = 0xFF7597B3;
	private int blue = 0xFF0AB2FB;
	// 定义FragmentManager对象
	FragmentManager fManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		fManager = getSupportFragmentManager();
		initViews();
	}

	// 完成组件的初始化
	public void initViews() {
		course_image = (ImageView) findViewById(R.id.course_image);
		found_image = (ImageView) findViewById(R.id.found_image);
		settings_image = (ImageView) findViewById(R.id.setting_image);
		course_text = (TextView) findViewById(R.id.course_text);
		found_text = (TextView) findViewById(R.id.found_text);
		settings_text = (TextView) findViewById(R.id.setting_text);
		course_layout = (RelativeLayout) findViewById(R.id.course_layout);
		found_layout = (RelativeLayout) findViewById(R.id.found_layout);
		settings_layout = (RelativeLayout) findViewById(R.id.setting_layout);
		course_layout.setOnClickListener(this);
		found_layout.setOnClickListener(this);
		settings_layout.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.course_layout:
			setChioceItem(0);
			break;
		case R.id.found_layout:
			setChioceItem(1);
			break;
		case R.id.setting_layout:
			setChioceItem(2);
			break;
		default:
			break;
		}
	}

	// 定义一个选中一个item后的处理
	public void setChioceItem(int index) {
		// 重置选项+隐藏所有Fragment
		FragmentTransaction transaction = fManager.beginTransaction();
		clearChioce();
		hideFragments(transaction);
		switch (index) {
		case 0:
			course_image.setImageResource(R.drawable.ic_launcher);
			course_text.setTextColor(blue);
//			course_layout.setBackgroundResource(R.drawable.ic_launcher);
			if (fg1 == null) {
				// 如果fg1为空，则创建一个并添加到界面上
				fg1 = new Fragment1();
				transaction.add(R.id.content, fg1);
			} else {
				// 如果MessageFragment不为空，则直接将它显示出来
				transaction.show(fg1);
			}
			break;

		case 1:
			found_image.setImageResource(R.drawable.ic_launcher);
			found_text.setTextColor(blue);
//			found_layout.setBackgroundResource(R.drawable.ic_launcher);
			if (fg2 == null) {
				// 如果fg1为空，则创建一个并添加到界面上
				fg2 = new Fragment2();
				transaction.add(R.id.content, fg2);
			} else {
				// 如果MessageFragment不为空，则直接将它显示出来
				transaction.show(fg2);
			}
			break;

		case 2:
			settings_image.setImageResource(R.drawable.ic_launcher);
			settings_text.setTextColor(blue);
//			settings_layout.setBackgroundResource(R.drawable.ic_launcher);
			if (fg3 == null) {
				// 如果fg1为空，则创建一个并添加到界面上
				fg3 = new Fragment3();
				transaction.add(R.id.content, fg3);
			} else {
				// 如果MessageFragment不为空，则直接将它显示出来
				transaction.show(fg3);
			}
			break;
		}
		transaction.commit();
	}

	// 隐藏所有的Fragment,避免fragment混乱
	private void hideFragments(FragmentTransaction transaction) {
		if (fg1 != null) {
			transaction.hide(fg1);
		}
		if (fg2 != null) {
			transaction.hide(fg2);
		}
		if (fg3 != null) {
			transaction.hide(fg3);
		}
	}

	// 定义一个重置所有选项的方法
	public void clearChioce() {
		course_image.setImageResource(R.drawable.ic_launcher);
		course_layout.setBackgroundColor(whirt);
		course_text.setTextColor(gray);
		found_image.setImageResource(R.drawable.ic_launcher);
		found_layout.setBackgroundColor(whirt);
		found_text.setTextColor(gray);
		settings_image.setImageResource(R.drawable.ic_launcher);
		settings_layout.setBackgroundColor(whirt);
		settings_text.setTextColor(gray);
	}
}
