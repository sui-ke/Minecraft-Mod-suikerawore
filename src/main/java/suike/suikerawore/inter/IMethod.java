package suike.suikerawore.inter;

import java.util.Map;
import java.util.HashMap;

import org.objectweb.asm.*;

public interface IMethod {

    default Map<String, String[]> getMethods() {
        return new HashMap<>();
    }

    MethodVisitor setMethodType(String type);

    default String[] getInterfaces(String[] interfaces) {
        return interfaces;
    }

    default void addValue(ClassVisitor visitor) {}
}