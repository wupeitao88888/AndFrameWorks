package com.andframe.layoutbind;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.andframe.activity.framework.AfViewable;
import com.andframe.layoutbind.AfLayoutModule;
import com.andframe.layoutbind.framework.IAfLayoutModule;

public abstract class AfModuleNodata extends AfLayoutModule implements IAfLayoutModule{
	
	protected View mButton = null;
	protected TextView mTvButton = null;
	protected TextView mTvDescription = null;
	
	public AfModuleNodata(AfViewable view) {
		super(view);
		if(isValid()){
			mButton = findRefreshButton(view);
			mTvDescription = findDescription(view);
			if (mButton instanceof TextView) {
				mTvButton = TextView.class.cast(mButton);
				setButtonText("点击刷新");
			}
//			mTvButton.setVisibility(View.GONE);
		}
	}

	/**
	 * 获取刷新按钮 建议是 TextView
	 * @param view
	 * @return
	 */
	protected abstract View findRefreshButton(AfViewable view);
	/**
	 * 获取信息提示 TextView
	 * @param view
	 * @return
	 */
	protected abstract TextView findDescription(AfViewable view);

	public void setDescription(String description) {
		if (isValid()) {
			mTvDescription.setText(description);
		}
	}

	public void setDescription(int id) {
		if (isValid()) {
			mTvDescription.setText(id);
		}
	}

	public void setButtonText(String text) {
		if (isValid()) {
			if (mTvButton != null) {
				mTvButton.setText(text);
			}
		}
	}

	public void setButtonText(int id) {
		if (isValid()) {
			mButton.setId(id);
			if (mTvButton != null) {
				mTvButton.setText(id);
			}
		}
	}

	public void setOnRefreshListener(OnClickListener listener) {
		if (isValid()) {
			mButton.setOnClickListener(listener);
			if(listener != null){
				mButton.setVisibility(View.VISIBLE);
			}else{
				mButton.setVisibility(View.GONE);
			}
		}
	}
	
	public int getButtonId(){
		if (!isValid()) {
			return 0;
		}
		return mButton.getId();
	}

	public View getButton() {
		return mButton;
	}
}