package com.wty.app.reduxlib.action;


import java.util.HashMap;

/**
 * @Desc  Action 负责获取原生数据，或者只是描述一种状态
 *                是把数据传到 store 的有效载体。它是store的唯一数据来源
 **/
public class ReduxAction {

    private String type;
    private HashMap<String, Object> hashMap;

    public String getType() {
        return type;
    }


    public ReduxAction(String type) {
        this.type = type;
    }

    public ReduxAction(String type, HashMap<String, Object> hashMap) {
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
