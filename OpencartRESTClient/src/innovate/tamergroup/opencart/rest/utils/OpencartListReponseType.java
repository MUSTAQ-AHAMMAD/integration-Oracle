package innovate.tamergroup.opencart.rest.utils;

import innovate.tamergroup.opencart.rest.model.shared.OpencartListResponse;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class OpencartListReponseType<X> implements ParameterizedType {
    
    private Class<?> wrapped;

    public OpencartListReponseType(Class<X> wrapped) {
        this.wrapped = wrapped;
    }

    public Type[] getActualTypeArguments() {
        return new Type[] { wrapped };
    }

    public Type getRawType() {
        return OpencartListResponse.class;
    }

    public Type getOwnerType() {
        return null;
    }
    
}
