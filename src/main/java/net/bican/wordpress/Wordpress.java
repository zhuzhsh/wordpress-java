package net.bican.wordpress;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

import redstone.xmlrpc.XmlRpcArray;
import redstone.xmlrpc.XmlRpcFault;
import redstone.xmlrpc.XmlRpcProxy;
import redstone.xmlrpc.XmlRpcStruct;

public class Wordpress {
  private static final String                 WP_XMLRPC_PREFIX   = "wp";              //$NON-NLS-1$
  private static final Integer                INT_ZERO           = Integer
                                                                     .valueOf(0);
  private Logger                              logger             = LoggerFactory
                                                                     .getLogger(this
                                                                         .getClass());

  private static Map<AuthEndpoint, Wordpress> wordpressInstances = new HashMap<>();

  public static Wordpress getInstance(Authentication authentication,
      Endpoint endpoint) {
    Preconditions.checkNotNull(authentication);
    Preconditions.checkNotNull(endpoint);
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

  private Wordpress(Authentication authentication, Endpoint endpoint) {
    this.authentication = authentication;
    this.endpoint = endpoint;
    this.wp = (WordpressBridge) XmlRpcProxy.createProxy(
        this.endpoint.getXmlRpc(), WP_XMLRPC_PREFIX,
        new Class[] { WordpressBridge.class }, true);
  }

  public Set<Post> getPosts(Optional<PostFilter> postFilter) {
    try {
      XmlRpcStruct filter = null;
      if (postFilter.isPresent()) {
        filter = postFilter.get().toXmlRpcStruct();
      }
      XmlRpcArray result = this.wp.getPosts(INT_ZERO, INT_ZERO,
          this.authentication.getUser(), this.authentication.getPassword(),
          filter);
      Set<Post> lst = new HashSet<>();
      for (Object s : result.toArray()) {
        Post post = new Post();
        post.fromXmlRpcStruct((XmlRpcStruct) s);
        lst.add(post);
      }
      return lst;
    } catch (XmlRpcFault e) {
      this.logger.error("getPosts() fails: " + e.getLocalizedMessage()); //$NON-NLS-1$
      return null;
    }
  }
}
