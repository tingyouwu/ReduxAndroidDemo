package com.wty.app.reduxandroiddemo.reduce;

import com.wty.app.reduxandroiddemo.state.ChangeTextState;
import com.wty.app.reduxandroiddemo.state.SecondState;
import com.wty.app.reduxlib.action.ReduxAction;
import com.wty.app.reduxlib.reduce.ReduxReduce;
import com.wty.app.reduxlib.state.ReduxState;

/**
 * @Desc 状态2
 **/
public class SecondReduce implements ReduxReduce {

    public static final int ACTION_SECOND_SHOWLOADING = 3;
    public static final int ACTION_SECOND_SHOWTEXT = 4;

    @Override
    public ReduxState handleAction(ReduxAction action) {
        switch (action.getType()) {
            case ACTION_SECOND_SHOWLOADING:
                return new SecondState(true, null);
            case ACTION_SECOND_SHOWTEXT:
                return new SecondState(false, action.getHashMap().get("text").toString());
            default:
                return null;
        }
    }
}
