package cmd;

import cmd.http.HttpClient;
import cmd.http.RequestBody;
import cmd.json.Json;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@SuppressWarnings("unchecked")
public final class CMD {

    private static Enhancer enhancer = new Enhancer();
    public  static <T> T  create(final Class<T> service){
        enhancer.setInterfaces(new Class[]{service});
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println(service.getSimpleName());
            System.out.println(method.getName());

            Type returnType = method.getGenericReturnType();
            if (!(returnType instanceof ParameterizedType)){
                throw  new IllegalArgumentException(
                        "Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
            }

            Type responseValue = CUtil.getParameterUpperBound(0, (ParameterizedType) returnType);
            System.out.println(responseValue);
            RequestBody requestBody = RequestFactory.parseAnnotations(service, method, objects);
            System.out.println(requestBody);
            return HttpClient.create().postInfo(requestBody).map(responseBody -> Json.getInstance().fromJson(responseBody.getData(), responseValue));
        });

        return (T) enhancer.create();
    }

}
