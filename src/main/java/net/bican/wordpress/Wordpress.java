package net.bican.wordpress;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import redstone.xmlrpc.XmlRpcArray;
import redstone.xmlrpc.XmlRpcFault;
import redstone.xmlrpc.XmlRpcProxy;
import redstone.xmlrpc.XmlRpcStruct;

public class Wordpress {
  private interface WordpressBridge {
    XmlRpcArray getPosts(Integer blog_id, String username, String password)
        throws XmlRpcFault;

    XmlRpcArray getPosts(Integer blog_id, String username, String password,
        XmlRpcStruct filter, XmlRpcArray fields) throws XmlRpcFault;

    XmlRpcArray getPosts(Integer blog_id, String username, String password,
        XmlRpcStruct filter) throws XmlRpcFault;

    XmlRpcArray getPosts(Integer blog_id, String username, String password,
        String filter, XmlRpcArray fields) throws XmlRpcFault;

    Boolean deletePost(Integer blogid, String username, String password,
        Integer post_id) throws XmlRpcFault;

    String newPost(Integer blog_id, String username, String password,
        XmlRpcStruct content) throws XmlRpcFault;
  }

  private static final String                 WP_XMLRPC_PREFIX   = "wp";           //$NON-NLS-1$
  private static final Integer                INT_ZERO           = Integer
                                                                     .valueOf(0);

  private static Map<AuthEndpoint, Wordpress> wordpressInstances = new HashMap<>();

  public static Wordpress getInstance(Authentication authentication,
      Endpoint endpoint) throws MalformedURLException {
    AuthEndpoint ae = AuthEndpoint.getInstance(authentication, endpoint);
    if (wordpressInstances.containsKey(ae))
      return wordpressInstances.get(ae);
    Wordpress result = new Wordpress(authentication, endpoint);
    wordpressInstances.put(ae, result);
    return result;
  }

  private Authentication  authentication;

  private Endpoint        endpoint;

  private WordpressBridge wp;

  private Wordpress(Authentication authentication, Endpoint endpoint)
      throws MalformedURLException {
    this.authentication = authentication;
    this.endpoint = endpoint;
    this.wp = (WordpressBridge) XmlRpcProxy.createProxy(
        this.endpoint.getXmlRpc(), WP_XMLRPC_PREFIX,
        new Class[] { WordpressBridge.class }, false);
  }

  public Set<Post> getPosts() throws WordpressException {
    return this.getPosts(null, null);
  }

  public Set<Post> getPosts(PostFilter filter) throws WordpressException {
    return this.getPosts(filter, null);
  }

  public Set<Post> getPosts(Set<String> fields) throws WordpressException {
    return this.getPosts(null, fields);
  }

  public void deletePost(Integer postId) throws WordpressException {
    try {
      this.wp.deletePost(INT_ZERO, this.authentication.getUser(),
          this.authentication.getPassword(), postId);
    } catch (XmlRpcFault e) {
      throw new WordpressException(e.errorCode);
    }
  }

  public Set<Post> getPosts(PostFilter filter, Set<String> fields)
      throws WordpressException {
    try {
      XmlRpcArray result;
      XmlRpcStruct postFilter = null;
      XmlRpcArray postFields = null;
      if (filter != null) {
        postFilter = filter.toXmlRpcStruct();
      }
      if (fields != null) {
        postFields = XmlRpcArrays.fromSet(fields);
      }
      if ((filter != null) && (fields != null)) {
        result = this.wp.getPosts(INT_ZERO, this.authentication.getUser(),
            this.authentication.getPassword(), postFilter, postFields);
      } else if ((filter == null) && (fields == null)) {
        result = this.wp.getPosts(INT_ZERO, this.authentication.getUser(),
            this.authentication.getPassword());
      } else if ((filter == null) && (fields != null)) {
        result = this.wp.getPosts(INT_ZERO, this.authentication.getUser(),
            this.authentication.getPassword(), "", postFields); //$NON-NLS-1$
      } else {
        result = this.wp.getPosts(INT_ZERO, this.authentication.getUser(),
            this.authentication.getPassword(), postFilter);
      }
      Set<Post> lst = new HashSet<>();
      for (Object s : result.toArray()) {
        Post post = new Post();
        post.fromXmlRpcStruct((XmlRpcStruct) s);
        lst.add(post);
      }
      return lst;
    } catch (XmlRpcFault e) {
      throw new WordpressException(e.errorCode);
    }
  }
}
