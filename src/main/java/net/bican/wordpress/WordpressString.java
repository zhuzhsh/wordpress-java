package net.bican.wordpress;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Joiner;

public class WordpressString {

  private static final String COMMA          = ","; //$NON-NLS-1$
  private static final String FIELDSEPARATOR = ":\""; //$NON-NLS-1$
  private static final String LISTENDER      = "]";  //$NON-NLS-1$
  private static final String LISTSTARTER    = ": ["; //$NON-NLS-1$
  private static final String QUOTE          = "\""; //$NON-NLS-1$

  public static String toString(Object object) {
    return toString(object, false);
  }

  public static String toString(Object object, boolean printNulls) {
    try {
      Class<?> cl = object.getClass();
      String result = cl.getSimpleName() + LISTSTARTER;
      List<String> fStr = new ArrayList<>();
      BeanInfo info = Introspector.getBeanInfo(cl, Object.class);
      for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
        Method getter = pd.getReadMethod();
        Object fieldValue;
        try {
          fieldValue = getter.invoke(object);
          if ((fieldValue != null) || printNulls) {
            fStr.add(pd.getName() + FIELDSEPARATOR + fieldValue + QUOTE);
          }
        } catch (IllegalAccessException | IllegalArgumentException
            | InvocationTargetException e) {
          // skip the field
        }
      }
      result += Joiner.on(COMMA).join(fStr) + LISTENDER;
      return result;
    } catch (IntrospectionException e) {
      e.printStackTrace();
      return null;
    }
  }
}
