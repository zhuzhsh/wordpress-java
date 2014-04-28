package net.bican.wordpress;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import redstone.xmlrpc.XmlRpcStruct;

public abstract class XmlRpcMapped {
  private static final SimpleDateFormat sdf = new SimpleDateFormat(
                                                "yyyyMMdd'T'HH:mm:ss"); //$NON-NLS-1$

  @SuppressWarnings("unchecked")
  public XmlRpcStruct toXmlRpcStruct() {
    XmlRpcStruct result = new XmlRpcStruct();
    Field[] f = this.getClass().getDeclaredFields();
    for (Field field : f) {
      try {
        Object o = field.get(this);
        if (o != null) {
          result.put(field.getName(), o);
        }
      } catch (IllegalArgumentException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
    return result;
  }

  public void fromXmlRpcStruct(XmlRpcStruct x) {
    Field[] f = this.getClass().getDeclaredFields();
    String k = null;
    Object v = null;
    for (Field field : f) {
      try {
        k = field.getName();
        v = x.get(k);
        Class<?> kType = field.getType();
        if (v != null) {
          if (kType == Integer.class) {
            if (v.getClass() != Integer.class) {
              Integer vInt = Integer.valueOf((String) v);
              field.set(this, vInt);
            } else {
              field.set(this, v);
            }
          } else if (kType == Date.class) {
            try {
              if (v.getClass() != Date.class) {
                Date vDate = sdf.parse((String) v);
                field.set(this, vDate);
              } else {
                field.set(this, v);
              }
            } catch (ParseException e) {
              throw new IllegalArgumentException(e);
            }
          } else {
            field.set(this, v);
          }
        }
      } catch (IllegalArgumentException e) {
        try {
          field.set(this, null);
        } catch (IllegalAccessException e1) {
          e1.printStackTrace();
        }
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
  }
}
