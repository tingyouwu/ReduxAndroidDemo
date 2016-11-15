package com.wty.app.reduxlib.reduce;

import com.wty.app.reduxlib.action.ReduxAction;
import com.wty.app.reduxlib.state.ReduxState;

/**
 * @Desc  根据Action中的数据或者线索进行再处理，生成ViewModel(State)
 **/
public interface ReduxReduce {
    ReduxState handleAction(ReduxAction action);
}
