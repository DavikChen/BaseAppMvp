package com.davik.baseapp.model.retrofit;

import com.davik.baseapp.model.retrofit.converter.RequestConverter;
import com.davik.baseapp.model.retrofit.converter.ResponseConverter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * @name trunk
 * @class name：com.davik.baseapp.model.retrofit
 * @class describe
 * @anthor davikchen
 * @time 2017/8/2 18:44
 */
public class FastJsonConvertFactory extends Converter.Factory{
    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new RequestConverter<>();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new ResponseConverter<>(type);
    }
}