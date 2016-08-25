package com.bwf.tuanche.xaingqing.View;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bwf.framwork.Constants;
import com.bwf.tuanche.R;

/**
 * Created by Lizhangfeng on 2016/7/21 0021.
 * Description: 自定义的ListVIew
 */
public class RefreshListView extends ListView implements AbsListView.OnScrollListener, Handler.Callback {

    public static final int LOADING_MORE = 1;//正在加载更多
    public static final int DONE = 2;//加载完成
    public static final int PULL_TO_REFRESH = 3;//下拉状态
    public static final int RELASE_TO_REFRE = 4;//释放状态
    public static final int LOAD_REFRESH = 5;//下拉加载刷新

    private View headerView;//添加头部加载更多布局

    private OnLoadMoreListener onLoadMoreListener;

    public int state;

    /* -------------------headerView--------------------- */
    private View footerView;//添加底部加载更多布局
    private int headerViewHeight;//headerView的高度

    private ImageView img_arrow;//箭头
    private TextView tv_refresh;//下拉刷新字
    private ProgressBar progressbar;//进度条

    private RotateAnimation animation;//下拉动画
    private RotateAnimation relase_animation;//释放动画

    private Handler handler;

    public RefreshListView(Context context) {
        this(context, null);
    }

    public RefreshListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RefreshListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 初始化view
     *
     * @param context
     */
    public void init(Context context) {
        //添加footerView
        footerView = View.inflate(context, R.layout.footerview_listview, null);
        addFooterView(footerView);
        ImageView img_progressbar = (ImageView) footerView.findViewById(R.id.img_progressbar);
        AnimationDrawable animationDrawable = (AnimationDrawable) img_progressbar.getDrawable();
        animationDrawable.start();

        //添加headerView
        headerView = View.inflate(context, R.layout.headview_listview, null);
        //addHeaderView(headerView); 最后一个boolean 默认是true
        addHeaderView(headerView, null, true);
        img_arrow = (ImageView) headerView.findViewById(R.id.img_arrow);
        tv_refresh = (TextView) headerView.findViewById(R.id.tv_refresh);
        progressbar = (ProgressBar) headerView.findViewById(R.id.progressbar);
        AnimationDrawable animationDrawable1 = (AnimationDrawable) img_arrow.getDrawable();
        animationDrawable1.start();
//        animation = new RotateAnimation(0, -180, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
//        animation.setDuration(250);
//        animation.setFillAfter(true);//停留在动画最后状态
//        relase_animation = new RotateAnimation(-180, 0, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
//        relase_animation.setDuration(250);
//        relase_animation.setFillAfter(true);//停留在动画最后状态

        //计算出headerView的高度
        measureView(headerView);
        headerViewHeight = headerView.getMeasuredHeight();

        //一开始隐藏headerView
        headerView.setPadding(0, -headerViewHeight, 0, 0);

        //footerView也隐藏
        footerView.setVisibility(INVISIBLE);

        setOnScrollListener(this);
        state = DONE;
        handler = new Handler(this);
    }

    public void measureView(View child) {
        ViewGroup.LayoutParams p = child.getLayoutParams();
        if (p == null) {
            p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0, p.width);
        int lpHeight = p.height;
        int childHeightSpec;
        if (lpHeight > 0) {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
        } else {
            childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState != SCROLL_STATE_IDLE)
            return;

        if (state == LOADING_MORE || state == LOAD_REFRESH)
            return;

        if (getLastVisiblePosition() == getCount() - 1) {
            if ((getCount() - 2) % Constants.PANG_NUM == 0) {//服务器返回一次数据是10 的倍数证明可以加载更多如果<10 则不用加载更多
                if (onLoadMoreListener != null) {
                    onLoadMoreListener.loadMore();
                    footerView.setVisibility(VISIBLE);
                    state = LOADING_MORE;
                }
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    private int startY, endY;

    /**
     * 触摸事件  1,按下事件  2，滑动事件  3，抬起事件
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        //判断ListView当前是否滑动在顶部
        if (getFirstVisiblePosition() != 0 || state == LOADING_MORE)
            return super.onTouchEvent(ev);

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN://按下事件

                if (state == DONE) {
                    state = PULL_TO_REFRESH;
                }
                startY = (int) ev.getY();
                break;
            case MotionEvent.ACTION_MOVE://滑动事件
                endY = (int) ev.getY();//相对于当前View的Y轴距离
                int moveY = endY - startY;
                if (moveY > 0 & state != LOAD_REFRESH) {
                    setSelection(0);
                    headerView.setPadding(0, -headerViewHeight + moveY, 0, 0);
                    if (moveY / 2 > headerViewHeight) {//箭头动画
                        if (state == PULL_TO_REFRESH) {
                            state = RELASE_TO_REFRE;
                            img_arrow.clearAnimation();//移除动画
//                            img_arrow.startAnimation(animation);
                            tv_refresh.setText("松开刷新数据");
                        }

                    }

                    if (moveY / 2 < headerViewHeight) {
                        if (state == RELASE_TO_REFRE) {
                            state = PULL_TO_REFRESH;
                            img_arrow.clearAnimation();
                            img_arrow.startAnimation(relase_animation);
                            tv_refresh.setText("下拉刷新");
                        }

                    }

                }

                break;
            case MotionEvent.ACTION_UP://抬起事件
                if (state == PULL_TO_REFRESH)//下拉
                    headerView.setPadding(0, -headerViewHeight, 0, 0);
                if (state == RELASE_TO_REFRE) {//可以加载网络数据了

                    headerView.setPadding(0, 0, 0, 0);

                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onRefresh();
                        progressbar.setVisibility(VISIBLE);
                        img_arrow.setVisibility(GONE);
                        handler.sendEmptyMessage(1);
                    }
                    state = LOAD_REFRESH;
                }

                if (state == LOAD_REFRESH) {//正在下拉刷新
                    headerView.setPadding(0, 0, 0, 0);
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    /**
     * 加载完成
     */
    public void setOnComplete() {
        progressbar.setVisibility(GONE);
        img_arrow.setVisibility(VISIBLE);
        footerView.setVisibility(INVISIBLE);
        tv_refresh.setText("下拉刷新");
        state = DONE;
        setSelection(0);
        headerView.setPadding(0, -headerViewHeight, 0, 0);
    }


    /**
     * 设置加载更多监听
     *
     * @param onLoadMoreListener
     */
    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    @Override
    public boolean handleMessage(Message msg) {

        if (state != LOAD_REFRESH)
            return false;

        switch (msg.what) {
            case 1:
                tv_refresh.setText("正在加载.");
                handler.sendEmptyMessageDelayed(2, 500);
                break;
            case 2:
                tv_refresh.setText("正在加载..");
                handler.sendEmptyMessageDelayed(3, 500);
                break;
            case 3:
                tv_refresh.setText("正在加载...");
                handler.sendEmptyMessageDelayed(1, 500);
                break;
        }
        return false;
    }

    /**
     * 加载更多
     */
    public interface OnLoadMoreListener {
        void loadMore();//加载更多

        void onRefresh();//下拉刷新
    }

}
