package com.bwf.tuanche.entiy.PJ;

import com.bwf.framwork.base.BaseBean;

import java.util.List;

/**
 * Created by admin on 2016/8/18.
 */
public class CommentList extends BaseBean {
    public String userName;

    public String commentDate;

    public String  score;

    public String content;

    public String memberPic;

    public List<CommentPicList> commentPicList ;

    public boolean fine;

    @Override
    public String toString() {
        return "CommentList{" +
                "userName='" + userName + '\'' +
                ", commentDate='" + commentDate + '\'' +
                ", score='" + score + '\'' +
                ", content='" + content + '\'' +
                ", memberPic='" + memberPic + '\'' +
                ", commentPicList=" + commentPicList +
                ", fine=" + fine +
                '}';
    }
}
