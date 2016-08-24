package com.bwf.tuanche.xaingqing.entiy.PJ;

import com.bwf.framwork.base.BaseBean;

import java.util.List;

/**
 * Created by admin on 2016/8/18.
 */
public class CommentPicList extends BaseBean{
    public int count;

    public double commentTotal;

    public double priceScore;

    public double salerScore;

    public double shopScore;

    public int offset;

    public List<CommentList> commentList ;

    @Override
    public String toString() {
        return "CommentPicList{" +
                "count=" + count +
                ", commentTotal=" + commentTotal +
                ", priceScore=" + priceScore +
                ", salerScore=" + salerScore +
                ", shopScore=" + shopScore +
                ", offset=" + offset +
                ", commentList=" + commentList +
                '}';
    }
}
