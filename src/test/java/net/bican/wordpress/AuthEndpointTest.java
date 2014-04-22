package net.bican.wordpress;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

@SuppressWarnings({ "nls", "static-method" })
public class AuthEndpointTest {
  @Test
  public void test() {
    Authentication authentication1 = new Authentication("test1", "pass1");
    Authentication authentication2 = new Authentication("test2", "pass2");
    Authentication authentication3 = new Authentication("test1", "pass1");
    Endpoint endpoint1 = new Endpoint("http://xxx");
    Endpoint endpoint2 = new Endpoint("http://xxxabc");
    Endpoint endpoint3 = new Endpoint("http://xxx");
    AuthEndpoint.getInstance(authentication1, endpoint1);
    assertEquals(1, AuthEndpoint.authEndpointInstances.size());
    AuthEndpoint.getInstance(authentication2, endpoint1);
    assertEquals(2, AuthEndpoint.authEndpointInstances.size());
    AuthEndpoint.getInstance(authentication3, endpoint1);
    assertEquals(2, AuthEndpoint.authEndpointInstances.size());
    AuthEndpoint.getInstance(authentication3, endpoint2);
    assertEquals(3, AuthEndpoint.authEndpointInstances.size());
    AuthEndpoint.getInstance(authentication3, endpoint3);
    assertEquals(3, AuthEndpoint.authEndpointInstances.size());
  }
}
