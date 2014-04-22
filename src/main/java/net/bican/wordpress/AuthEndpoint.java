package net.bican.wordpress;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Objects;

class AuthEndpoint {
  static Set<AuthEndpoint> authEndpointInstances = new HashSet<>();

  public static AuthEndpoint getInstance(Authentication authentication,
      Endpoint endpoint) {
    for (AuthEndpoint s : authEndpointInstances) {
      if ((s.authentication.equals(authentication))
          && (s.endpoint.equals(endpoint)))
        return s;
    }
    AuthEndpoint result = new AuthEndpoint();
    result.authentication = authentication;
    result.endpoint = endpoint;
    authEndpointInstances.add(result);
    return result;
  }

  private Authentication authentication;

  private Endpoint       endpoint;

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof AuthEndpoint)) {
      return false;
    }
    AuthEndpoint other = (AuthEndpoint) o;
    return Objects.equal(this.authentication, other.authentication)
        && Objects.equal(this.endpoint, other.endpoint);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.authentication, this.endpoint);
  }
}