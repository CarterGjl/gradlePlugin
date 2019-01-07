package cmd;

import io.reactivex.Observable;

import java.lang.reflect.Method;

abstract class ServiceMethod<T> {

    static <T> ServiceMethod<T> parseAnnotations(Class<?> retrofit, Method method) {
//        RequestFactory requestFactory = RequestFactory.parseAnnotations(retrofit, method);

//        Type returnType = method.getGenericReturnType();
//        if (Utils.hasUnresolvableType(returnType)) {
//            throw methodError(method,
//                    "Method return type must not include a type variable or wildcard: %s", returnType);
//        }
//        if (returnType == void.class) {
//            throw methodError(method, "Service methods cannot return void.");
//        }

//        return HttpServiceMethod.parseAnnotations(retrofit, method, requestFactory);
        return null;
    }

    abstract Observable<T> invoke(Object[] args);
}
