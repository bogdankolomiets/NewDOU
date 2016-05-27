package com.example.bogdan.newdou.data.api;


import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 26.05.16
 */
public class DouConverterFactory extends Converter.Factory {
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new DouConverter(type);
    }
}
