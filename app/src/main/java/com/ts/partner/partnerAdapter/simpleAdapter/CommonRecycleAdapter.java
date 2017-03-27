package com.ts.partner.partnerAdapter.simpleAdapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * Created by Administrator on 2017/1/19
 * 通用的通过databinding 建立的recycleview的adapter 直接传入数据和布局 就可以直接将数据展示
 * 相当于工具类，直接如果没有其他需求可以直接使用
 */

public class CommonRecycleAdapter <T>extends RecyclerView.Adapter <CommonRecycleAdapter.DataViewHolder>{

    private List<T> mDatas;

    private int layoutId;

    private int brId;  //databinding 的BR的id

    public CommonRecycleAdapter(List<T> mDatas, int layoutId, int brId) {
        this.mDatas = mDatas;
        this.layoutId = layoutId;
        this.brId = brId;
    }

    public void setmDatas(List<T> mDatas){
        this.mDatas=mDatas;
    }

    @Override
    public CommonRecycleAdapter.DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ViewDataBinding bling= DataBindingUtil.inflate(inflater,layoutId,parent,false);
         DataViewHolder holder=new DataViewHolder(bling.getRoot());
         holder.setBling(bling);
        return holder;
    }

    @Override
    public void onBindViewHolder(CommonRecycleAdapter.DataViewHolder holder, int position) {
        holder.getBling().setVariable(brId ,mDatas.get(position));
        holder.getBling().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mDatas==null?0:mDatas.size();
    }
    class  DataViewHolder extends RecyclerView.ViewHolder{
         private ViewDataBinding bling;

        public ViewDataBinding getBling() {
            return bling;
        }

        public void setBling(ViewDataBinding bling) {
            this.bling = bling;
        }

        public DataViewHolder(View itemView) {
            super(itemView);
        }
    }
}
