package com.davik.baseapp.model.retrofit.converter;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Converter;

/**
 * @name trunk
 * @class name：com.davik.baseapp.model.retrofit.Converter
 * @class describe
 * @anthor davikchen
 * @time 2017/8/2 18:37
 */
public class ResponseConverter<T> implements Converter<ResponseBody, T> {
    private final Type type;
    public ResponseConverter(Type type) {
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        BufferedSource buffer = Okio.buffer(value.source());
        String s = buffer.readUtf8();
        buffer.close();
        return JSON.parseObject(s, type);
    }
}
