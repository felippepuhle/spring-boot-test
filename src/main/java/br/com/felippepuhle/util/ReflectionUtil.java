package br.com.felippepuhle.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectionUtil {

    @SuppressWarnings("unchecked")
    public static <T> Class<T> getGenericTypeArgument(final Class<?> clazz, final int idx) {
        final Type type = clazz.getGenericSuperclass();

        ParameterizedType paramType;
        try {
            paramType = (ParameterizedType) type;
        } catch (ClassCastException cause) {
            return getGenericTypeArgument((Class<T>) type, idx);
        }

        return (Class<T>) paramType.getActualTypeArguments()[idx];
    }

}
