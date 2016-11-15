package com.wty.app.reduxlib.action;


import java.util.HashMap;

/**
 * @Desc  Action 负责获取原生数据，或者只是描述一种状态
 **/
public class ReduxAction {

    private int type;
    private HashMap<String, Object> hashMap;

    public int getType() {
        return type;
    }


    public ReduxAction(int type) {
        this.type = type;
    }

    public ReduxAction(int type, HashMap<String, Object> hashMap) {
        this.type = type;
        this.hashMap = hashMap;
    }

    public HashMap<String, Object> appendHashParam(String key, Object object) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put(key, object);
        return hashMap;
    }

    public HashMap<String, Object> getHashMap() {
        return hashMap;
    }
}
