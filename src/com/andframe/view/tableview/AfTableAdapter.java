package com.andframe.view.tableview;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.andframe.adapter.AfListAdapter;
import com.andframe.application.AfExceptionHandler;

public class AfTableAdapter extends AfListAdapter<Object> {

	protected AfTable mTable = null;

	public AfTableAdapter(Context context, AfTable table, List<?> ltdata) {
		super(context, new ArrayList<Object>(ltdata));
		// TODO Auto-generated constructor stub
		mTable = table;
	}

//	@Override
//	public int getCount() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	/**
	 * @deprecated
	 */
	@Override
	protected final IAfLayoutItem<Object> getItemLayout(Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub // �б���ͼ��ȡ������ view �Ƿ�Ϊ�� ����ÿ�ζ� inflate
		// �����ֻ��ڴ渺�ز���
		AfTableRow row = null;
		try {
			if (view == null) {
				row = new AfTableRow(mInflater.getContext(), mTable);
				view = row;
			} else {
				row = (AfTableRow) view;
			}
			row.Binding(mTable, mltArray, position);
		} catch (Throwable e) {
			// TODO: handle exception
			String remark = "AfTableAdapter.getView �����쳣\r\n";
			remark += "class = " + getClass().toString();
			AfExceptionHandler.handler(e, remark);
		}
		return view;
	}

	public AfTable getTable() {
		// TODO Auto-generated method stub
		return mTable;
	}
}