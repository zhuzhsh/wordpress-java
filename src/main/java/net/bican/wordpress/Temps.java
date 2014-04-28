package net.bican.wordpress;

import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Set;

public class Temps {
  @SuppressWarnings("nls")
  public static void main(String[] args) throws WordpressException,
      MalformedURLException {
    Authentication authentication = new Authentication("admin", "vagrant");
    Endpoint endpoint = new Endpoint("http://localhost:8080");
    Wordpress wordpress = Wordpress.getInstance(authentication, endpoint);
    Set<String> fields = new HashSet<>();
    fields.add("post_title");
    Set<Post> result = wordpress.getPosts();
    for (Post p : result) {
      System.err.println(p);
      System.err.println(p.custom_fields);
    }
  }
}
