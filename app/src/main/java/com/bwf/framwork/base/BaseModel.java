package com.bwf.framwork.base;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

import com.bwf.framwork.db.DBHelper;

import java.util.List;
import java.util.Map;


/**
 * Created by Lizhangfeng on 2016/8/8 0008.
 * Description: 基类model
 */
public abstract class BaseModel implements BaseColumns {

    private DBHelper dbHelper;

    public BaseModel() {
        dbHelper = DBHelper.getInstence();
    }

    /**
     * 插入数据库语句
     *
     * @return
     */
    public String getCreateTableSql() {
        return getCreateTable(getTableName(), getParamsMap());
    }

    public String getCreateTable(String tableName, Map<String, String> map) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table ").append(tableName).append(" (");

        for (Map.Entry<String, String> entity : map.entrySet()) {
            stringBuilder.append(entity.getKey()).append(" ").append(entity.getValue());
            stringBuilder.append(",");
        }
        String sql = stringBuilder.substring(0, stringBuilder.length() - 1);
        sql = sql + ")";
        return sql;
    }

    /**
     * 插入一条
     */
    public void insert(String tableName, ContentValues values) {
        dbHelper.getWritableDatabase().insert(tableName, null, values);
    }

    /**
     * 插入多条数据（没插入一条数据，数据库会默认开启一个事务）
     *
     * @param tableName
     * @param values
     */
    public void insertMore(String tableName, List<ContentValues> values) {
        //事务的开启
        dbHelper.getWritableDatabase().beginTransaction();
        for (int i = 0; i < values.size(); i++) {
            insert(tableName, values.get(i));
        }
        dbHelper.getWritableDatabase().endTransaction();//事务的结束

    }

    /**
     * 更新
     */
    public void update(String tableName, ContentValues values, String where, String[] whereArgs) {
        dbHelper.getWritableDatabase().update(tableName, values, where, whereArgs);
    }

    /**
     * 删除数据
     */
    public void delete(String tableName, String where, String[] whereArgs) {
        dbHelper.getWritableDatabase().delete(tableName, where, whereArgs);
    }

    /**
     * 查询
     *
     * @param sql
     */
    public Cursor select(String sql) {
        return dbHelper.getReadableDatabase().rawQuery(sql, null);
    }

    /**
     * 清空表
     *
     * @param tableName
     */
    public void clear(String tableName) {
        dbHelper.getWritableDatabase().execSQL("delete from " + tableName);
    }

    /**
     * 删除更个表
     *
     * @param tableName
     */
    public void deleteTable(String tableName) {
        dbHelper.getWritableDatabase().execSQL("drop table " + tableName);
    }

    protected abstract String getTableName();

    protected abstract Map<String, String> getParamsMap();


}
