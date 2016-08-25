package com.bwf.framwork.CompareTo;

import com.bwf.framwork.bean.UserBean;

import java.util.Comparator;

/**
 * Created by admin on 2016/8/19.
 */
public class CompareUserBean implements Comparator<UserBean>{

    @Override
    public int compare(UserBean o, UserBean t1) {
        String time1 =o.dateTime;
        String time2 =t1.dateTime;
        if(time1.compareTo(time2)>0){
            return -1;
        }else if(time1.compareTo(time2)<0){
            return 1;
        }
        return 0;
    }
}
