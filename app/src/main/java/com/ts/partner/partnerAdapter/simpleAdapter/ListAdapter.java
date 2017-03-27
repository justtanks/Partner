package com.ts.partner.partnerAdapter.simpleAdapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2017/2/4.
 * 通用的listview的adapter 如果只有看和跳转功能 不能实现复杂的操作  通过databinding结合使用
 */

public class ListAdapter<T> extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private int brID;
    private List<T> datas;
    private int layoutId ;
    public ListAdapter(Context context, List<T>datas, int brID, int layoutId){
        this.context=context;
        inflater=LayoutInflater.from(context);
        this.brID=brID;
        this.datas=datas;
        this.layoutId=layoutId;

    }
    public void  setDatas(List<T> datas){
        this.datas=datas;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return datas==null?0:datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding binding = null;
               if (convertView == null){
                         binding = DataBindingUtil.inflate(LayoutInflater.from(context),layoutId,parent,false);
                   } else {
                       binding = DataBindingUtil.getBinding(convertView);
                  }
               binding.setVariable(brID,datas.get(position));
             Log.e("listview","datachangge");
                return binding.getRoot();
           }
}
