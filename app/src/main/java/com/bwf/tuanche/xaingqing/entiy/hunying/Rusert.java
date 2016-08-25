package com.bwf.tuanche.xaingqing.entiy.hunying;

import com.bwf.framwork.base.BaseBean;

import java.util.List;

/**
 * Created by admin on 2016/8/19.
 */
public class Rusert extends BaseBean {
    public String  adpTitle;
    public String  adpLogo;
    public String  shareUrl;
    public String  sharePic;
    public String  shareCtx;
    public String  shareSlogan;
    public String  isShare;
    public String  cardTotal;
    public String  offset;
    public String  count;
    public List<HyRusert> carstyleList;

    @Override
    public String toString() {
        return "Rusert{" +
                "adpTitle='" + adpTitle + '\'' +
                ", adpLogo='" + adpLogo + '\'' +
                ", shareUrl='" + shareUrl + '\'' +
                ", sharePic='" + sharePic + '\'' +
                ", shareCtx='" + shareCtx + '\'' +
                ", shareSlogan='" + shareSlogan + '\'' +
                ", isShare='" + isShare + '\'' +
                ", cardTotal='" + cardTotal + '\'' +
                ", offset='" + offset + '\'' +
                ", count='" + count + '\'' +
                ", carstyleList=" + carstyleList +
                '}';
    }
}
