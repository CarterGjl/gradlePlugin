package cmd.json;

import com.google.gson.JsonElement;

import java.lang.reflect.Type;

public interface IJson {

    <T> T fromJson(JsonElement json, Class<T> classOfT);

    <T> T fromJson(String json, Class<T> classOfT);
    <T> T fromJson(String json, Type typeOfT);
    <T> T fromJson(JsonElement json, Type typeOfT);
    <T > String toJson(T t);
}
