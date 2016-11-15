package com.wty.app.reduxlib.store;

import com.wty.app.reduxlib.action.ReduxAction;
import com.wty.app.reduxlib.reduce.ReduxReduce;
import com.wty.app.reduxlib.state.ReduxState;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * @Desc  Store 根据传进来的Action去遍历reducer列表去处理
 **/
public class ReduxStore {

    private static ReduxStore defaultInstance;
    private EventBus eventBus;

    private List<ReduxReduce> reducers;

    public static ReduxStore getInstance() {
        if (defaultInstance == null) {
            synchronized (EventBus.class) {
                if (defaultInstance == null) {
                    defaultInstance = new ReduxStore();
                }
            }
        }
        return defaultInstance;
    }

    private ReduxStore() {
        eventBus = EventBus.getDefault();
        reducers = new ArrayList<>();
    }

    /**
     * 合并reduce
     * @param reduceList
     */
    public void combineReducers(ReduxReduce... reduceList) {
        for (ReduxReduce reduce : reduceList) {
            reducers.add(reduce);
        }
    }

    /**
     * 添加单个reduce
     * @param reduce
     */
    public void addReduce(ReduxReduce reduce) {
        reducers.add(reduce);
    }

    /**
     * 移除单个Reduce
     *
     * @param reduce
     */
    public void removeReduce(ReduxReduce reduce) {
        reducers.remove(reduce);
    }

    /**
     * 清空reducers
     */
    public void clearAllReduce() {
        reducers.clear();
    }

    /**
     * 分发一个Action
     * @param action
     */
    public void dispatch(ReduxAction action) {
        for (ReduxReduce reduce : reducers) {
            ReduxState localState = reduce.handleAction(action);
            if (localState != null) {
                eventBus.post(localState);
            }

        }
    }
}
