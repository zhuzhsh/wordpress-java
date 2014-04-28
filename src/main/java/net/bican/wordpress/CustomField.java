package net.bican.wordpress;

public class CustomField extends XmlRpcMapped {
  Integer id;
  String  key;
  String  value;

  public Integer getId() {
    return this.id;
  }

  public String getKey() {
    return this.key;
  }

  public String getValue() {
    return this.value;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return WordpressString.toString(this);
  }
}
