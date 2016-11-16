package com.wty.app.reduxlib.reduce;

import com.wty.app.reduxlib.action.ReduxAction;
import com.wty.app.reduxlib.state.ReduxState;

/**
 * @Desc  根据Action中的数据或者线索进行再处理，生成ViewModel(State)
 * Reducer是决定如何根据Action更新状态(state)，而这正是reducer要做的事情
 **/
public interface ReduxReduce {
    ReduxState handleAction(ReduxAction action);
}
