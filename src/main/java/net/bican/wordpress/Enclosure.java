package net.bican.wordpress;

public class Enclosure extends XmlRpcMapped {
  Integer length;
  String  type;
  String  url;

  public Integer getLength() {
    return this.length;
  }

  public String getType() {
    return this.type;
  }

  public String getUrl() {
    return this.url;
  }

  public void setLength(final Integer length) {
    this.length = length;
  }

  public void setType(final String type) {
    this.type = type;
  }

  public void setUrl(final String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return WordpressString.toString(this);
  }
}
