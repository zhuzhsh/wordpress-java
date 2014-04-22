package net.bican.wordpress;

import redstone.xmlrpc.XmlRpcArray;
import redstone.xmlrpc.XmlRpcFault;
import redstone.xmlrpc.XmlRpcStruct;

interface WordpressBridge {
  XmlRpcArray getPosts(Integer placeHolder, Integer blogid, String username,
      String password, XmlRpcStruct filter) throws XmlRpcFault;
}
