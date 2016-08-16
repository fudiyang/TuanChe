package com.bwf.framwork.db.model;

import android.content.ContentValues;
import android.database.Cursor;

import com.bwf.framwork.base.BaseModel;
import com.bwf.framwork.bean.UserBean;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Lizhangfeng on 2016/8/8 0008.
 * Description:
 */
public class UserModel extends BaseModel {

    public static final String TABLE_NAME = "userinfo";//表名

    private static Map<String, String> paramsMap = new HashMap<>();

    static {
        paramsMap.put(_ID, "integer primary key autoincrement");//
        paramsMap.put("name", "TEXT NOT NULL");//姓名
        paramsMap.put("userid", "TEXT NOT NULL");//
    }

    /**
     * 插入一个用户
     * @param userBean
     */
    public void insertUser(UserBean userBean) {
        if (userBean == null)
            return;
        ContentValues values = new ContentValues();
        values.put("userid", userBean.userId);
        values.put("name", userBean.userName);
        insert(TABLE_NAME, values);

    }

    /**
     * 查询对象
     *
     * @param id
     * @return
     */
    public UserBean getUserBeanById(String id) {
        UserBean userBean = new UserBean();
        String sql = "select * from userinfo where userid=" + id;
        Cursor cursor = select(sql);

        if (cursor != null) {
            if (cursor.moveToNext()) {//找到userid为123的数据了
                userBean.userName = cursor.getString(cursor.getColumnIndex("name"));
                userBean.userId = cursor.getString(cursor.getColumnIndex("userid"));
            }
        }
        return userBean;
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
