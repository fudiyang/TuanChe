package com.bwf.tuanche.xaingqing.fragment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.tuanche.R;
import com.bwf.tuanche.xaingqing.entiy.qichexiangqing.Result;


public class Fragment_2 extends BaseFragment {
    public Result result;
    private TextView tuanche_time,tuanche_didian,tuanche_pric;
    private TextView edi_pop;

    private Popcallbock popcallbock;

    public void setPopcallbock(Popcallbock popcallbock) {
        this.popcallbock = popcallbock;
    }

    public void setResult(Result result) {
        this.result = result;
        initData();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_fragment_2;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        tuanche_time=findViewByIdNoCast(R.id.tuanche_time);
        tuanche_didian=findViewByIdNoCast(R.id.tuanche_didian);
        tuanche_pric=findViewByIdNoCast(R.id.tuanche_pric);
        edi_pop=findViewByIdNoCast(R.id.edi_pop);
        edi_pop.setOnClickListener(this);
    }

    @Override
    protected void initData() {
       if(result !=null){
           tuanche_time.setText(result.groupbuyDate+"("+result.groupbuyWeek+")");
           tuanche_didian.setText(result.regular4sShop);
       }
    }

    @Override
    public void onClick(View view) {
      switch (view.getId()){
          case R.id.edi_pop:
              if(popcallbock !=null){
                  popcallbock.popcallbock();
              }
              break;

      }
    }

    public interface Popcallbock{
        void popcallbock();
    }

}
