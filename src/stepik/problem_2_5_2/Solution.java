package stepik.problem_2_5_2;

import java.lang.reflect.ParameterizedType;

public class Solution {


}

abstract class Factory<T> {
    public Factory() {

    }

    public T generateInstance() throws Exception {
        // enter you code
        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        Class<T> type = (Class<T>) superClass.getActualTypeArguments()[0];
        return type.getDeclaredConstructor().newInstance();
    }
}
