package com.davik.baseapp.model.retrofit.converter;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;
import com.alibaba.fastjson.JSON;

/**
 * @name trunk
 * @class name：com.davik.baseapp.model.retrofit.Converter
 * @class describe
 * @anthor davikchen
 * @time 2017/8/2 18:37
 */


public class RequestConverter <T> implements Converter<T, RequestBody> {

    @Override
    public RequestBody convert(T value) throws IOException {
        return RequestBody.create(MediaType.parse("application/json; charset=UTF-8"), JSON.toJSONBytes(value));
    }
}