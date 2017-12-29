package com.example.phucao.lab3_2_sql;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class ListContactAdapter extends BaseAdapter{
    private Context mcontext;
    private List<Contact> mContactList; // Danh sach sinh vien

    public ListContactAdapter(Context mcontext, List<Contact> mContactList) {
        this.mcontext = mcontext;
        this.mContactList = mContactList;
    }

    @Override
    public int getCount() {
        return mContactList.size();
    }

    @Override
    public Object getItem(int i) {
        return mContactList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mContactList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // View v hiển thị 1 student
        View v = View.inflate(mcontext,R.layout.a_contact,null);

        TextView tvID = (TextView) v.findViewById(R.id.tv_id);
        TextView tvHoTen = (TextView) v.findViewById(R.id.tv_name);
        TextView tvMSSV = (TextView) v.findViewById(R.id.tv_phone);

        // Gán giá trị để hiển thị
        tvID.setText("ID: " + String.valueOf(mContactList.get(i).getId()));
        tvHoTen.setText("Name : " + mContactList.get(i).getName());
        tvMSSV.setText("Phone : " + mContactList.get(i).getPhoneNumber());

        return v;
    }
}
