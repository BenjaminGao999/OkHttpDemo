package com.qingmu.okutils.utils;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/8.
 */

public interface OKCallBack<T> {

    void onSuccessBody(T data);

    void onSuccessBody(List<T> list);

    void onSuccessHeaders(Map<String, List<String>> headers);

    void onFail(Exception e);
}
