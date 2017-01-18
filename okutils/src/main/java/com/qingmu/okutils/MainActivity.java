package com.qingmu.okutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.qingmu.okutils.module.Data;
import com.qingmu.okutils.utils.OKCallBack;
import com.qingmu.okutils.utils.OKUtils;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String url = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mBtnOk = (Button) findViewById(R.id.id_btn_ok);
        mBtnOk.setOnClickListener(this);
        Button mbtnCancel = (Button) findViewById(R.id.id_btn_cancel);
        mbtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OKUtils.cancelNet();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
//
//        OKUtils.Get(this, "http://publicobject.com/helloworld.txt", map, null, new OKCallBack<>() {
//            @Override
//            public void onSuccessBody(String data) {
//                System.out.println(data);
//            }
//
//            @Override
//            public void onSuccessHeaders(Map<String, List<String>> headers) {
//                for (Map.Entry<String, List<String>> header : headers.entrySet()) {
//                    for (String content : header.getValue()) {
//
//                        System.out.println(header.getKey() + ":" + content);
//                    }
//                }
//            }
//
//            @Override
//            public void onFail(Exception e) {
//
//            }
//        });

        OKUtils.Get(this, url, null, null, new OKCallBack<Data>() {
            @Override
            public void onSuccessBody(Data data) {
                if (null != data) {
                    List<Data.ResultsBean> results = data.results;
                    ListIterator<Data.ResultsBean> iterator = results.listIterator();
                    while (iterator.hasNext()) {
                        Data.ResultsBean next = iterator.next();
                        Toast.makeText(MainActivity.this, next.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onSuccessBody(List<Data> list) {

            }

            @Override
            public void onSuccessHeaders(Map<String, List<String>> headers) {

            }

            @Override
            public void onFail(Exception e) {

            }
        }, false, Data.class);

    }

    @Override
    protected void onStop() {
        super.onStop();
        OKUtils.cancelNet();
    }
}
