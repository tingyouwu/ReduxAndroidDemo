package com.wty.app.reduxlib.action;

import com.wty.app.reduxlib.store.ReduxStore;

/**
 * @Desc 负责分发Action
 **/
public class ReduxActionCreater {
    public void dispatch(ReduxAction action) {
        ReduxStore.getInstance().dispatch(action);
    }
}
