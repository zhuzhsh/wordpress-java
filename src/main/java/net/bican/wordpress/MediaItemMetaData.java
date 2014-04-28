package net.bican.wordpress;

import redstone.xmlrpc.XmlRpcStruct;

public class MediaItemMetaData extends XmlRpcMapped {
  Integer      width;
  Integer      height;
  String       file;
  XmlRpcStruct sizes;
  XmlRpcStruct image_meta;

  public MediaImageMeta getImage_meta() {
    MediaImageMeta result = new MediaImageMeta();
    result.fromXmlRpcStruct(this.image_meta);
    return result;
  }

  public void setImage_meta(MediaImageMeta image_meta) {
    this.image_meta = image_meta.toXmlRpcStruct();
  }

  @Override
  public String toString() {
    return WordpressString.toString(this, false);
  }

  public String getFile() {
    return this.file;
  }

  public Integer getHeight() {
    return this.height;
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

  public void setWidth(Integer width) {
    this.width = width;
  }

  public MediaItemSize getSizes() {
    MediaItemSize result = new MediaItemSize();
    result.fromXmlRpcStruct(this.sizes);
    return result;
  }

  public void setSizes(MediaItemSize sizes) {
    this.sizes = sizes.toXmlRpcStruct();
  }
}
