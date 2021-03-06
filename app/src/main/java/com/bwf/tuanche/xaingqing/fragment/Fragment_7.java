package com.bwf.tuanche.xaingqing.fragment;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.tuanche.R;


public class Fragment_7 extends BaseFragment {
private WebView webView;
    @Override
    protected int getResource() {
        return R.layout.fragment_fragment_7;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        webView=findViewByIdNoCast(R.id.web_View);
    }

    @Override
    protected void initData() {
        webView.loadUrl("http://123.56.145.151:8080/TuanCheNetWork/bwf_TuanChe_BuyInfoQuestionServlet");
        webView.setWebViewClient(new MyWebViewClient());
    }
    public class MyWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            super.onPageStarted(view, url, favicon);
        }
        /**
         * 网页加载完成
         */
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }
    @Override
    public void onClick(View view) {

    }
}
