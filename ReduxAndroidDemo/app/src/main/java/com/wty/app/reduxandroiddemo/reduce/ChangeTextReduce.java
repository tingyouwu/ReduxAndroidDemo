package com.wty.app.reduxandroiddemo.reduce;

import com.wty.app.reduxandroiddemo.state.ChangeTextState;
import com.wty.app.reduxlib.action.ReduxAction;
import com.wty.app.reduxlib.reduce.ReduxReduce;
import com.wty.app.reduxlib.state.ReduxState;

/**
 * @Desc 状态1
 **/
public class ChangeTextReduce implements ReduxReduce {

    public static final String ACTION_SHOWLOADING = "ACTION_SHOWLOADING";
    public static final String ACTION_SHOWTEXT = "ACTION_SHOWTEXT";

    @Override
    public ReduxState handleAction(ReduxAction action) {
        switch (action.getType()) {
            case ACTION_SHOWLOADING:
                return new ChangeTextState(true, null);
            case ACTION_SHOWTEXT:
                return new ChangeTextState(false, action.getHashMap().get("text").toString());
            default:
                return null;
        }
    }
}
