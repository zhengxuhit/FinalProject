package com.example.monkey.finalproject;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClickDialogActivity extends Dialog {

    private int checkedID;

    @BindView(R.id.click_rg)
    RadioGroup radioGroup;
    @OnClick(R.id.bt_okay)
    public void okayClick(){
        switch (checkedID){
            case R.id.click_rg_bt1:
                dismiss();
                listener.onToFirst();
                break;
            case R.id.click_rg_bt2:
                dismiss();
                listener.onToSecond();
                break;
            case R.id.click_rg_bt3:
                dismiss();
                listener.onToThird();
                break;
            default:
                dismiss();
        }
    }

    @OnClick(R.id.bt_cancel)
    public void cancelClick(){
        switch (checkedID){
            case R.id.click_rg_bt1:
                dismiss();
                break;
            case R.id.click_rg_bt2:
                dismiss();
                break;
            case R.id.click_rg_bt3:
                dismiss();
                break;
            default:
                dismiss();
        }
    }

    private IClickDialogEventListenerClick listener;

    public interface IClickDialogEventListenerClick{
        public void onToFirst();
        public void onToSecond();
        public void onToThird();
    }


    public ClickDialogActivity(@NonNull Context context, ClickDialogActivity.IClickDialogEventListenerClick listener){
        super(context, R.style.dialog);
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_dialog);

        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId){
                checkedID = checkedId;
            }
        });
    }
}
