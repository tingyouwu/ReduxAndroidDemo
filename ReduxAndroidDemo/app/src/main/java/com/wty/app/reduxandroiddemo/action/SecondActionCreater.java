package com.wty.app.reduxandroiddemo.action;

import android.os.Handler;

import com.wty.app.reduxandroiddemo.reduce.SecondReduce;
import com.wty.app.reduxlib.action.ReduxAction;
import com.wty.app.reduxlib.action.ReduxActionCreater;

import java.util.Random;

/**
 * @Desc 负责分发Action
 **/
public class SecondActionCreater extends ReduxActionCreater{
    public void changeText() {
        dispatch(new ReduxAction(SecondReduce.ACTION_SECOND_SHOWLOADING));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showText();
            }
        }, 3000);
    }

    private void showText() {
        ReduxAction action = new ReduxAction(SecondReduce.ACTION_SECOND_SHOWTEXT);
        action.appendHashParam("text", new Random().nextInt(10) + "文本");
        dispatch(action);
    }
}
