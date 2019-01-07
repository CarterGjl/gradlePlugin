package cmd;

import cmd.http.RequestBody;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * process Annotations
 */
class RequestFactory {

    static RequestBody parseAnnotations(final Class<?> service, Method method, Object[] objects){

        String type = service.getSimpleName();
        String call = method.getName();

        RequestBody requestBody = new RequestBody();
        requestBody.setType(type);
        requestBody.setCall(call);
        requestBody.setArgs(Arrays.asList(objects));
        return requestBody;

    }

}
