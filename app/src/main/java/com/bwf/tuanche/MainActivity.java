package com.bwf.tuanche;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.Search.Activity.SearchActivity;
import com.bwf.tuanche.VersionUpdate.UpdateResultBean;

public class MainActivity extends BaseActivity {
    private int oldVersionCode;
    private String oldVersionName;
    private String description,newVersionCode;
    private TextView dialog_text,text_version;
    private ImageView image_close;
    private Button button_update,text_intentsearch;
    private View view;
    private PopupWindow popupWindow;
    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }
    @Override
    public void beforeInitView() {
    }
    @Override
    public void initView() {
        PackageManager manager;
        PackageInfo info = null;
        manager = this.getPackageManager();
        try {
            info = manager.getPackageInfo(this.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        oldVersionCode= info.versionCode;
        oldVersionName=info.versionName;
        LogUtils.e("======================",oldVersionCode+"------"+oldVersionName);
        text_intentsearch= (Button) findViewById(R.id.text_intentsearch);
        text_intentsearch.setOnClickListener(this);

    }
    @Override
    public void initData() {
        getdata();
    }
    public void getdata(){
        String url= UrlUtils.VERSION_UPDATA;
        HttpHelper.getUpdate(url, new HttpCallBack<UpdateResultBean>() {
            @Override
            public void onSuccess(UpdateResultBean result) {
                LogUtils.e("------------------",result.versionCode+"----"+result.versionName);
                if(oldVersionCode<result.versionCode){
                    if(result != null){
                        description=result.description;
                        newVersionCode= String.valueOf(result.versionName);
                        initShow();
                        show();
                    }
                }
            }

            @Override
            public void onFail(String errMsg) {
                LogUtils.e("123123",errMsg);
            }
        });


    }
    private void initShow(){
        view=View.inflate(this,R.layout.updata,null);
        dialog_text= (TextView) view.findViewById(R.id.dialog_text);
        button_update= (Button) view.findViewById(R.id.button_update);
        image_close= (ImageView) view.findViewById(R.id.image_close);
        text_version= (TextView) view.findViewById(R.id.text_version);
        dialog_text.setText(description);
        text_version.setText("V"+newVersionCode);
        LogUtils.e("dialog的文字","description"+description);
        popupWindow =new PopupWindow(view,WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        image_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image_close.setImageResource(R.mipmap.icon_close_click);
                popupWindow.dismiss();
            }
        });

    }
    private void show(){
        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.text_intentsearch:
                IntentUtils.openActivity(MainActivity.this,SearchActivity.class);
            break;
        }
    }
}

