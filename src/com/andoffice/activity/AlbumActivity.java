package com.andoffice.activity;

import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.andoffice.R;
import com.andframe.activity.albumn.AfAlbumActivity;
import com.andframe.activity.framework.AfViewable;

public class AlbumActivity extends AfAlbumActivity{

	@Override
	protected int getAlbumLayoutId() {
		// TODO Auto-generated method stub
		return (R.layout.album_main);
	}

	@Override
	protected TextView getTextViewName(AfViewable view) {
		// TODO Auto-generated method stub
		return view.findViewByID(R.id.album_name);
	}

	@Override
	protected TextView getTextViewSize(AfViewable view) {
		// TODO Auto-generated method stub
		return view.findViewByID(R.id.album_size);
	}

	@Override
	protected ViewPager getViewPager(AfViewable view) {
		// TODO Auto-generated method stub
		return view.findViewByID(R.id.pager);
	}

	@Override
	protected TextView getTextViewDetail(AfViewable view) {
		// TODO Auto-generated method stub
		return view.findViewByID(R.id.album_tip);
	}

}