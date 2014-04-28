/*
 * 
 * Wordpress-java
 * http://code.google.com/p/wordpress-java/
 * 
 * Copyright 2014 Can Bican <can@bican.net>
 * See the file 'COPYING' in the distribution for licensing terms.
 * 
 */
package net.bican.wordpress;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Objects;

class AuthEndpoint {
  static Set<AuthEndpoint> AUTHENDPOINTINSTANCES = new HashSet<>();

  static AuthEndpoint getInstance(final Authentication authentication,
      final Endpoint endpoint) {
    final AuthEndpoint result = new AuthEndpoint();
    for (final AuthEndpoint s : AUTHENDPOINTINSTANCES) {
      if (s.authentication.equals(authentication)
          && s.endpoint.equals(endpoint)) {
        return s;
      }
    }
    result.authentication = authentication;
    result.endpoint = endpoint;
    AUTHENDPOINTINSTANCES.add(result);
    return result;
  }

  private Authentication authentication;

  private Endpoint       endpoint;

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    final AuthEndpoint other = (AuthEndpoint) obj;
    return Objects.equal(this.authentication, other.authentication)
        && Objects.equal(this.endpoint, other.endpoint);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.authentication, this.endpoint);
  }
}