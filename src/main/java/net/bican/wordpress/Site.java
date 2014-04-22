package net.bican.wordpress;

public class Site {
  private Authentication authentication;
  private Endpoint       endpoint;

  @SuppressWarnings("unused")
  private Site() {
    // forbidden
  }

  public Site(Authentication authentication, Endpoint endpoint) {
    this.authentication = authentication;
    this.endpoint = endpoint;
  }

}
