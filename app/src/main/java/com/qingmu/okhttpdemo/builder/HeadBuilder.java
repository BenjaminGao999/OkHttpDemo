package com.qingmu.okhttpdemo.builder;


import com.qingmu.okhttpdemo.OkHttpUtils;
import com.qingmu.okhttpdemo.request.OtherRequest;
import com.qingmu.okhttpdemo.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
