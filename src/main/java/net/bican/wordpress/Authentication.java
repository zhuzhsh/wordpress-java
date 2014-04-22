package net.bican.wordpress;

import com.google.common.base.Objects;

public class Authentication {
  private String user;
  private String password;

  public String getPassword() {
    return this.password;
  }

  public String getUser() {
    return this.user;
  }

  @SuppressWarnings("unused")
  private Authentication() {
    // forbidden
  }

  public Authentication(String user, String password) {
    this.user = user;
    this.password = password;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.user, this.password);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Authentication)) {
      return false;
    }
    Authentication other = (Authentication) o;
    return Objects.equal(this.user, other.user)
        && Objects.equal(this.password, other.password);
  }
}
