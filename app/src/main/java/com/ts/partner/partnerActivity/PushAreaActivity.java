package com.ts.partner.partnerActivity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bigkoo.pickerview.OptionsPickerView;
import com.google.gson.Gson;
import com.ts.partner.R;
import com.ts.partner.databinding.ActivityPushAreaBinding;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerBase.BaseData;
import com.ts.partner.partnerBean.netBean.AreaSheng;
import com.ts.partner.partnerBean.netBean.AreaShi;
import com.ts.partner.partnerBean.netBean.AreaXian;
import com.ts.partner.partnerBean.netBean.NetError;
import com.ts.partner.partnerBean.netBean.Regist_phoneback;
import com.ts.partner.partnerUtils.NetUtils;
import com.ts.partner.partnerUtils.SystemUtil;

import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PushAreaActivity extends BaseActivity implements View.OnClickListener {
    ActivityPushAreaBinding b;
    HashMap<String, String> shengmap = new HashMap<>();
    HashMap<String, String> shimap = new HashMap<>();
    HashMap<String, String> qumap = new HashMap<>();
    String ShengId;
    String ShiId;
    String quId;
    Gson gson = new Gson();
    private OptionsPickerView pickerView; //选择框
    Callback.Cancelable cancel;
    SystemUtil su = new SystemUtil(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_push_area);
        init();
    }

    private void init() {
        b.areaBack.setOnClickListener(this);
        b.areaSheng.setOnClickListener(this);
        b.areaShi.setOnClickListener(this);
        b.areaQu.setOnClickListener(this);
        b.areaTijiao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.area_back:
                onBackPressed();
                break;
            case R.id.area_sheng:
                getsheng();
                break;
            case R.id.area_shi:
                clickCity();
                break;
            case R.id.area_qu:
                clickXian();
                break;
            case R.id.area_tijiao:
                tijiao();
                break;
        }

    }

    //提交到服务器
    private void tijiao() {
        if (quId == null) {
            toast("请先选择相应地区");
            return;
        }
        Map<String, Object> parma = new HashMap<>();
        parma.put("county", quId);
        parma.put("partner_id", su.showUid());
        NetUtils.Post(BaseData.PUSHAREA, parma, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (result.substring(0, 18).contains("Error")) {
                    NetError error = gson.fromJson(result, NetError.class);
                    toast(error.getMsg());

                } else {
                    toast(getString(R.string.tijiaodiqu));
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                toast(getString(R.string.net_error));
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    //每次访问网络之后在将所有信息展示出来 第一次进去之后在展示
    //获取省的信息
    private void getsheng() {
        if (quId != null || ShiId != null) {
            quId = null;
            ShiId = null;
            b.areaQutext.setText(null);
            b.areaShitext.setText(null);
        }
        AreaSheng area = gson.fromJson(areasheng, AreaSheng.class);
        for (AreaSheng.DataBean ar : area.getData()) {
            shengmap.put(ar.getProvice_name(), ar.getProvice_id());
        }
        showshengDialog(shengmap, 1);
    }

    private void clickCity() {
        if (ShengId == null) {
            toast("请先选择省份");
            return;
        }
        if (quId != null) {
            quId = null;
            b.areaQutext.setText(null);
        }
        getshi();
    }

    private void clickXian() {
        if (ShiId == null) {
            toast("请先选择城市");
            return;
        }
        getXianqu();
    }

    private void getshi() {
        Map<String, Object> parma = new HashMap<>();
        parma.put("provice_id", ShengId);
        cancel = NetUtils.Post(BaseData.CHENGXHI, parma, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (result.substring(0, 18).contains("Error")) {
                    return;
                }
                AreaShi shis = gson.fromJson(result, AreaShi.class);
                for (AreaShi.DataBean sh : shis.getData()) {
                    shimap.put(sh.getCity_name(), sh.getCity_id());
                }
                showshengDialog(shimap, 2);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                toast(getString(R.string.net_error));
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


    public void getXianqu() {
        Map<String, Object> parma = new HashMap<>();
        parma.put("city_id", ShiId);
        cancel = NetUtils.Post(BaseData.QUXIAN, parma, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (result.substring(0, 18).contains("Error")) {
                    return;
                }
                AreaXian shis = gson.fromJson(result, AreaXian.class);
                for (AreaXian.DataBean sh : shis.getData()) {
                    qumap.put(sh.getCounty_name(), sh.getCounty_id());
                }
                showshengDialog(qumap, 3);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                toast(getString(R.string.net_error));
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    //展示选择框 id 是展示的标识 1 省 2 市 3 县
    private void showshengDialog(final HashMap<String, String> areas, final int id) {
        if (pickerView != null && pickerView.isShowing()) {
            pickerView.dismiss();
        }
        final List<String> list = new ArrayList();
        list.addAll(areas.keySet());
        pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                if (id == 1) {
                    b.areaShengtext.setText(list.get(options1));
                    ShengId = areas.get(list.get(options1));
                } else if (id == 2) {
                    b.areaShitext.setText(list.get(options1));
                    ShiId = areas.get(list.get(options1));
                } else if (id == 3) {
                    b.areaQutext.setText(list.get(options1));
                    quId = areas.get(list.get(options1));
                }
            }
        }).build();

        pickerView.setNPicker(list, null, null);
        pickerView.show();
    }

    //最初的省的返回字符串 暂时不使用请求网络做
    String areasheng = "{\"flag\":\"Success\",\"msg\":\"\\u83b7\\u53d6\\u7701\\u4efd\\u6210\\u529f\",\"data\":[{\"provice_name\":\"\\u5317\\u4eac\\u5e02\",\"provice_id\":\"110\"},{\"provice_name\":\"\\u5929\\u6d25\\u5e02\",\"provice_id\":\"120\"},{\"provice_name\":\"\\u6cb3\\u5317\\u7701\",\"provice_id\":\"130\"},{\"provice_name\":\"\\u5c71\\u897f\\u7701\",\"provice_id\":\"140\"},{\"provice_name\":\"\\u5185\\u8499\\u53e4\\u81ea\\u6cbb\\u533a\",\"provice_id\":\"150\"},{\"provice_name\":\"\\u8fbd\\u5b81\\u7701\",\"provice_id\":\"210\"},{\"provice_name\":\"\\u5409\\u6797\\u7701\",\"provice_id\":\"220\"},{\"provice_name\":\"\\u9ed1\\u9f99\\u6c5f\\u7701\",\"provice_id\":\"230\"},{\"provice_name\":\"\\u4e0a\\u6d77\\u5e02\",\"provice_id\":\"310\"},{\"provice_name\":\"\\u6c5f\\u82cf\\u7701\",\"provice_id\":\"320\"},{\"provice_name\":\"\\u6d59\\u6c5f\\u7701\",\"provice_id\":\"330\"},{\"provice_name\":\"\\u5b89\\u5fbd\\u7701\",\"provice_id\":\"340\"},{\"provice_name\":\"\\u798f\\u5efa\\u7701\",\"provice_id\":\"350\"},{\"provice_name\":\"\\u6c5f\\u897f\\u7701\",\"provice_id\":\"360\"},{\"provice_name\":\"\\u5c71\\u4e1c\\u7701\",\"provice_id\":\"370\"},{\"provice_name\":\"\\u6cb3\\u5357\\u7701\",\"provice_id\":\"410\"},{\"provice_name\":\"\\u6e56\\u5317\\u7701\",\"provice_id\":\"420\"},{\"provice_name\":\"\\u6e56\\u5357\\u7701\",\"provice_id\":\"430\"},{\"provice_name\":\"\\u5e7f\\u4e1c\\u7701\",\"provice_id\":\"440\"},{\"provice_name\":\"\\u5e7f\\u897f\\u58ee\\u65cf\\u81ea\\u6cbb\\u533a\",\"provice_id\":\"450\"},{\"provice_name\":\"\\u6d77\\u5357\\u7701\",\"provice_id\":\"460\"},{\"provice_name\":\"\\u91cd\\u5e86\\u5e02\",\"provice_id\":\"500\"},{\"provice_name\":\"\\u56db\\u5ddd\\u7701\",\"provice_id\":\"510\"},{\"provice_name\":\"\\u8d35\\u5dde\\u7701\",\"provice_id\":\"520\"},{\"provice_name\":\"\\u4e91\\u5357\\u7701\",\"provice_id\":\"530\"},{\"provice_name\":\"\\u897f\\u85cf\\u81ea\\u6cbb\\u533a\",\"provice_id\":\"540\"},{\"provice_name\":\"\\u9655\\u897f\\u7701\",\"provice_id\":\"610\"},{\"provice_name\":\"\\u7518\\u8083\\u7701\",\"provice_id\":\"620\"},{\"provice_name\":\"\\u9752\\u6d77\\u7701\",\"provice_id\":\"630\"},{\"provice_name\":\"\\u5b81\\u590f\\u56de\\u65cf\\u81ea\\u6cbb\\u533a\",\"provice_id\":\"640\"},{\"provice_name\":\"\\u65b0\\u7586\\u7ef4\\u543e\\u5c14\\u81ea\\u6cbb\\u533a\",\"provice_id\":\"650\"}],\"num\":1}";

}
