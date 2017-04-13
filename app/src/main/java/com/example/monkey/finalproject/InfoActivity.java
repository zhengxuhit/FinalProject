package com.example.monkey.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoActivity extends BaseActivity implements View.OnTouchListener {

    private GestureDetector mGestureDetector;

    @BindView(R.id.fl)
    FrameLayout fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);

        mGestureDetector = new GestureDetector(this, new simpleGestureListener());
        fl.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    public class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{
        public boolean onDown(MotionEvent e){
            toastShort("onDown");
            return true;
        }

        public void onShowPress(MotionEvent e){
            toastShort("onShowPress");
        }

        public void onLongPress(MotionEvent e){
            toastShort("onLongPress");
        }

        public boolean onSingleTapUp(MotionEvent e){
            toastShort("onSingleTapUp");
            return true;
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
            toastShort((e2.getX()-e1.getX()) + "   " + distanceX);
            return true;
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            toastShort("onFLing");
            return true;
        }

        public boolean onDoubleTap(MotionEvent e){
            toastShort("onDoubleTap");
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent e){
            toastShort("onDoubleTapEvent");
            return true;
        }
    }
}
