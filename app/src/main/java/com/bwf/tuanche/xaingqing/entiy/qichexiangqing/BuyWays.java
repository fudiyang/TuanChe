package com.bwf.tuanche.xaingqing.entiy.qichexiangqing;

import java.util.List;

/**
 * Created by admin on 2016/8/16.
 */
public class BuyWays {
    private List<BuyWayList> buyWayList ;
    private int showWhere;
    private int isMust;

    public void setBuyWayList(List<BuyWayList> buyWayList){
        this.buyWayList = buyWayList;
    }
    public List<BuyWayList> getBuyWayList(){
        return this.buyWayList;
    }
    public void setShowWhere(int showWhere){
        this.showWhere = showWhere;
    }
    public int getShowWhere(){
        return this.showWhere;
    }
    public void setIsMust(int isMust){
        this.isMust = isMust;
    }
    public int getIsMust(){
        return this.isMust;
    }

}
