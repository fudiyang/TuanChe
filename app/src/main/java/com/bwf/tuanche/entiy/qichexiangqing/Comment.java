package com.bwf.tuanche.entiy.qichexiangqing;

import java.util.List;

/**
 * Created by admin on 2016/8/16.
 */
public class Comment {
    public String count;

    public double commentTotal;

    public List<CommentList> commentList ;

    @Override
    public String toString() {
        return "Comment{" +
                "count='" + count + '\'' +
                ", commentTotal=" + commentTotal +
                ", commentList=" + commentList +
                '}';
    }
}
