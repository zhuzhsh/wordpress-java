package net.bican.wordpress;

public class MediaItemSizeData extends XmlRpcMapped {
  Integer height;
  Integer width;
  String  file;
  String  mime_type;
  
  @Override
  public String toString() {
    return WordpressString.toString(this);
  }

  public String getFile() {
    return this.file;
  }

  public Integer getHeight() {
    return this.height;
  }

  public String getMime_type() {
    return this.mime_type;
  }

  public Integer getWidth() {
    return this.width;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public void setMime_type(String mime_type) {
    this.mime_type = mime_type;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }
}
