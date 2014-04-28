package net.bican.wordpress;

import java.util.Set;

import redstone.xmlrpc.XmlRpcArray;

public class XmlRpcArrays {
  @SuppressWarnings("unchecked")
  public static XmlRpcArray fromSet(Set<?> set) {
    XmlRpcArray result = new XmlRpcArray();
    if (set != null) {
      for (Object s : set) {
        result.add(s);
      }
    }
    return (result.size() > 0) ? result : null;
  }
}
