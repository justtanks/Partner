package com.ts.partner.partnerUtils;

import android.os.Environment;

import org.xutils.DbManager;
import org.xutils.db.table.TableEntity;
import org.xutils.x;

import java.io.File;

/**
 * Created by Administrator on 2017/1/4.
 *
 */

public class DButils {
    static DbManager.DaoConfig daoConfig;
  public static DbManager DB=getDBmanager();
    public static DbManager.DaoConfig getDaoConfig(){
        File file=new File(Environment.getExternalStorageDirectory().getPath());
        if(daoConfig==null){
            daoConfig=new DbManager.DaoConfig()
                    .setDbName("partner.db")//设置数据库名称
                    .setDbDir(file)
                    .setDbVersion(1)
                    .setAllowTransaction(true)
                    .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                        @Override
                        public void onUpgrade(DbManager db, int oldVersion, int newVersion) {

                        }
                    }).setTableCreateListener(new DbManager.TableCreateListener() {
                        @Override
                        public void onTableCreated(DbManager db, TableEntity<?> table) {
                            //blablablalalalal
                        }
                    });
        }
        return daoConfig;
    }

     static DbManager getDBmanager(){
        DbManager manager= x.getDb(getDaoConfig());
           return  manager;
    }

    //插入操作
//    private void addUser(){
//
//        Testuser user=new Testuser();
//        user.setAge(1);
//        user.setBorn(true);
//        user.setName("xiaming");
//        try {
//            manager.save(user);
//        } catch (DbException e) {
//            e.printStackTrace();
//        }
//
//    }
//    /*
//    查找
//     */
//    private void search(){
//        try {
//            List<Testuser> users=manager.findAll(Testuser.class);
//            List<Testuser> users2=manager.selector(Testuser.class).where("age",">",20).and("name","=","xiaoming").findAll();
//
//        } catch (DbException e) {
//            e.printStackTrace();
//        }
//    }
//    /*
//    修改 一段
//     */
//    private  void updateOne(){
//        try {
//            Testuser user=manager.findById(Testuser.class,1);
//            user.setName("sjhaoweo9");
//            manager.update(user,"age");
//        } catch (DbException e) {
//            e.printStackTrace();
//        }
//    }
//    private  void updateAll(){
//        try {
//            //将所有的name 是hh 和age 》11d的name 和isborn修改
//            manager.update(Testuser.class,WhereBuilder.b("name","=","hh").and("age",">",11),new KeyValue("name","baichi"),new KeyValue("isborn",false));
//        } catch (DbException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void delete(){
//        try {
//            Testuser uyser=manager.selector(Testuser.class).where("age",">",11).findFirst();
//            manager.delete(uyser);//删除一条数据
//            manager.delete(Testuser.class);//清空一个表
//            manager.dropTable(Testuser.class);//删除一个表
//            manager.dropDb();//删除数据库
//
//        } catch (DbException e) {
//            e.printStackTrace();
//        }
//    }
}
