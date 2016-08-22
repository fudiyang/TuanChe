package com.bwf.tuanche.entiy.qichexiangqing;

import java.util.List;

/**
 * Created by admin on 2016/8/16.
 */
public class CommentList {
    public String userName;
    public String commentDate;
    public String score;
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
