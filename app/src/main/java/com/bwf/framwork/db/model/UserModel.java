package com.bwf.framwork.db.model;

import android.content.ContentValues;
import android.database.Cursor;

import com.bwf.framwork.base.BaseModel;
import com.bwf.framwork.bean.UserBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Lizhangfeng on 2016/8/8 0008.
 * Description:
 */
public class UserModel extends BaseModel {

    public static final String TABLE_NAME = "search_table";//表名

    private static Map<String, String> paramsMap = new HashMap<>();

    static {
        paramsMap.put(_ID, "integer primary key autoincrement");//
        paramsMap.put("info", "TEXT NOT NULL");  //搜索的内容
        paramsMap.put("dateTime", "TEXT NOT NULL");  //搜索的时间

    }

    /**
     * 插入一个用户
     * @param userBean
     */
    public void insertUser(UserBean userBean) {
        if (userBean == null)
            return;
        ContentValues values = new ContentValues();
        values.put("info", userBean.info);
        values.put("dateTime", userBean.dateTime);
        insert(TABLE_NAME, values);

    }
    /**
     * 查询所有用户
     */
    public List<UserBean> queryAllUsearBean() {

        Cursor cursor = queryAll();
        List<UserBean> userBeens = new ArrayList<>();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                UserBean userBean = new UserBean();
                userBean.info = cursor.getString(cursor.getColumnIndex("info"));
                userBean.dateTime = cursor.getString(cursor.getColumnIndex("dateTime"));
                userBeens.add(userBean);
            }
            cursor.close();
        }

        return userBeens;
    }

    /**
     * 查询对象
     *
     * @param id
     * @return
     */
    public UserBean getUserBeanById(String id) {
        UserBean userBean = new UserBean();
//        String sql = "select * from userinfo where userid=" + id;
        String sql = "select * from tab order by datetime desc";
        Cursor cursor = select(sql);

        if (cursor != null) {
            if (cursor.moveToNext()) {//找到userid为123的数据了
                userBean.info = cursor.getString(cursor.getColumnIndex("info"));
            }
        }
        return userBean;
    }
    //更新数据
    public void updataUser(UserBean userBean) {
        if (userBean == null)
            return;
        ContentValues values = new ContentValues();
        values.put("info", userBean.info);
        values.put("dateTime", userBean.dateTime);
        update(TABLE_NAME,values, "info=?", new String[]{userBean.info});
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected Map<String, String> getParamsMap() {
        return paramsMap;
    }
}
