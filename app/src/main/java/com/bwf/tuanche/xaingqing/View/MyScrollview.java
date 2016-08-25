package com.bwf.tuanche.xaingqing.View;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * 自定义Scrollview
 * Created by admin on 2016/8/22.
 */
public class MyScrollview extends ScrollView {

    private ScrollCallback scrollCallback;
    //滑动过程中手指抬起，而Scrollview继续滑动的Y的距离
    private int lastScrollY;

    public MyScrollview(Context context) {
        this(context,null);
    }
    public MyScrollview(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }
    public MyScrollview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void setScrollCallback(ScrollCallback scrollCallback) {
        this.scrollCallback = scrollCallback;
    }
    /**
     * 用于用户手指离开MyScrollView的时候获取MyScrollView滚动的Y距离，然后回调给onScroll方法中
     */
    private Handler handler =new Handler(){
        @Override
        public void handleMessage(android.os.Message msg) {
            int scrollY = MyScrollview.this.getScrollY();
            //此时的距离和记录下的距离不相等，在隔5毫秒给handler发送消息
            if(lastScrollY!=scrollY){
                lastScrollY=scrollY;
                handler.sendMessageDelayed(handler.obtainMessage(),5);
            }
            if(scrollCallback !=null){
                scrollCallback.onScroll(scrollY);
            }
        };
    };
    /**
     * 重写onTouchEvent， 当用户的手在MyScrollView上面的时候，
     * 直接将MyScrollView滑动的Y方向距离回调给onScroll方法中，当用户抬起手的时候，
     * MyScrollView可能还在滑动，所以当用户抬起手我们隔5毫秒给handler发送消息，在handler处理
     * MyScrollView滑动的距离
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(scrollCallback!=null){
            scrollCallback.onScroll(lastScrollY=this.getScrollY());
        }
        switch (ev.getAction()){
            case MotionEvent.ACTION_UP:
                handler.sendMessageDelayed(handler.obtainMessage(),5);
                break;
        }
        return super.onTouchEvent(ev);
    }

    /**
     * Scrollview滚动回调接口
     */
    public interface ScrollCallback{
       void onScroll(int scrollY);
    }
}
