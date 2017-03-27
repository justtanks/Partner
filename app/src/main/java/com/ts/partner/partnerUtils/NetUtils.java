package com.ts.partner.partnerUtils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/4.
 * 封装xutils的网络功能
 */

public class NetUtils {


    public static  <T> Callback.Cancelable Get (String url, Map<String,String> keys, Callback.CommonCallback  <T>callback){
        RequestParams params=new RequestParams(url);
        if(null!=params){
            for(Map.Entry<String,String> entry:keys.entrySet()){
                params.addQueryStringParameter(entry.getKey(),entry.getValue());

            }
        }
        Callback.Cancelable cancelable= x.http().get(params,callback);
        return cancelable;


    }
    //post
    public static  <T>Callback.Cancelable Post(String url , Map<String,Object> maps, Callback.CommonCallback <T> callback){
        RequestParams params =new RequestParams(url);
        if(null!=maps){
            for(Map.Entry<String,Object> entry:maps.entrySet()){
                params.addParameter(entry.getKey(),entry.getValue());
            }
        }
        Callback.Cancelable cancelable= x.http().post(params,callback);
        return  cancelable;

    }
     //下载文件封装 待测试
    //  params.setSaveFilePath("/mnt/sdcard/demo.apk");
     public static  <T> Callback.Cancelable downFile(String  url, Map<String,Object> maps, String saveFilepass, Callback.CommonCallback  <T> callback){
         RequestParams params =new RequestParams(url);
         if(null!=maps) {
             for (Map.Entry<String, Object> entry : maps.entrySet()) {
                 params.addParameter(entry.getKey(), entry.getValue());
             }
         }
             params.setAutoRename(true);
             params.setSaveFilePath(saveFilepass);
             Callback.Cancelable cancelable = x.http().get(params, callback);
         //显示下载进度
//             cancelable=x.http().post(params, new Callback.ProgressCallback<Object>() {
//                 @Override
//                 public void onSuccess(Object result) {
//
//                 }
//
//                 @Override
//                 public void onError(Throwable ex, boolean isOnCallback) {
//
//                 }
//
//                 @Override
//                 public void onCancelled(CancelledException cex) {
//
//                 }
//
//                 @Override
//                 public void onFinished() {
//
//                 }
//
//                 @Override
//                 public void onWaiting() {
//
//                 }
//
//                 @Override
//                 public void onStarted() {
//
//                 }
//
//                 @Override
//                 public void onLoading(long total, long current, boolean isDownloading) {
//
//                 }
//             });
             return cancelable;

         }

    //上传文件封装 待测试
    //("/sdcard/test.txt");
    public static <T> Callback.Cancelable upFile(String url , Map<String ,Object> maps, String tag, String Filepath, Callback.CommonCallback<T> callback){
        RequestParams params =new RequestParams(url);
        params.setMultipart(true);
        if(null!=maps) {
            for (Map.Entry<String, Object> entry : maps.entrySet()) {
                params.addParameter(entry.getKey(), entry.getValue());
            }
        }
        params.addBodyParameter(tag, new File(Filepath));
        Callback.Cancelable cancelable= x.http().post(params,callback);
        return  cancelable;

    }




}
