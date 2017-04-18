package com.ts.partner.partnerAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ts.partner.R;
import com.ts.partner.partnerBean.netBean.LoginBean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/15.
 * 展示银行卡的信息的listview的adapter
 */

public class CardListviewAdatper extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    List<LoginBean.DataBean.PartnerBankCardBean> datas;

    public CardListviewAdatper(Context context, List<LoginBean.DataBean.PartnerBankCardBean> datas) {
        this.context = context;
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);

    }
    public void setDatas(List<LoginBean.DataBean.PartnerBankCardBean> datas){
        this.datas=datas;
//        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if(datas!=null){
            return datas.size();
        }else {
         return 0;
        }
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
        TViewHolder holder = null;
        if (convertView == null) {
            holder = new TViewHolder();
            convertView = inflater.inflate(R.layout.item_mybanks, parent, false);
            holder.back = (ImageView) convertView.findViewById(R.id.item_yinhang_bankback);
            holder.cardBankName = (TextView) convertView.findViewById(R.id.item_yinhang_name);
            holder.cardnum = (TextView) convertView.findViewById(R.id.item_yinhang_cardnum);
            holder.headImg = (ImageView) convertView.findViewById(R.id.item_yinhang_head);
            convertView.setTag(holder);
        } else {
            holder = (TViewHolder) convertView.getTag();
        }
        if(datas!=null&&datas.size()!=0){
            LoginBean.DataBean.PartnerBankCardBean data = datas.get(position);
            String bankname = data.getBank_name();
            StringBuffer cardnum=new StringBuffer(data.getCard_num());
            String str=null;
            if(cardnum.length()>4){
              str=cardnum.substring(cardnum.length()-4,cardnum.length());
            }else {
                str=cardnum.toString();
            }
            holder.cardnum.setText("**** **** **** "+str);
            holder.cardBankName.setText(bankname);
            if (bankname.contains("中国银行")) {
                holder.headImg.setImageResource(R.mipmap.bank_zhonghang);
                holder.back.setImageResource(R.mipmap.bank_zhonggonghang);
            } else if (bankname.contains("农业")) {
                holder.headImg.setImageResource(R.mipmap.bank_nonghang);
                holder.back.setImageResource(R.mipmap.bank_nonghangback);

            } else if (bankname.contains("建设")) {
                holder.headImg.setImageResource(R.mipmap.bank_jianhang);
                holder.back.setImageResource(R.mipmap.bank_jianhangbeijing);

            } else if (bankname.contains("工商银行")) {
                holder.headImg.setImageResource(R.mipmap.bank_gonghang);
                holder.back.setImageResource(R.mipmap.bank_jianhangbeijing);

            } else {
                holder.headImg.setImageResource(R.mipmap.bank_nonghang);
                holder.back.setImageResource(R.mipmap.bank_nonghangback);
            }
        }

        return convertView;
    }

    class TViewHolder {
        ImageView back;
        ImageView headImg;
        TextView cardBankName;
        TextView cardnum;
    }
}
