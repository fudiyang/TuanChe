package com.bwf.framwork.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Created by Lizhangfeng on 2016/7/25 0025.
 * Description:
 */
public class ListUtils {

    /**
     * 深层次复制集合
     * 序列化过程
     *
     * @param src
     * @return
     */
    public static <T extends Object> List<T> deepCopy(List<T> src) {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        List<T> dest = null;
        try {
            out = new ObjectOutputStream(byteOut);
            out.writeObject(src);
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            dest = (List<T>) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dest;
    }

}
