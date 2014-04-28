package net.bican.wordpress;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("nls")
public class PostTest {

  private Wordpress wp;

  @Before
  public void setUp() throws Exception {
    Authentication authentication = new Authentication("admin", "vagrant");
    Endpoint endpoint = new Endpoint("http://localhost:8080");
    this.wp = Wordpress.getInstance(authentication, endpoint);
    deleteAllPosts();
  }

  private void deleteAllPosts() throws WordpressException {
    for (Post p : this.wp.getPosts()) {
      this.wp.deletePost(p.getPost_id());
    }
  }

  @After
  public void tearDown() throws Exception {
    deleteAllPosts();
  }

  @Test
  public void test() {
    fail("Not yet implemented");
  }

}
