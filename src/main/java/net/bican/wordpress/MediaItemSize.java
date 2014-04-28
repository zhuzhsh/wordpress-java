package net.bican.wordpress;

import redstone.xmlrpc.XmlRpcStruct;

public class MediaItemSize extends XmlRpcMapped {
  private static final String FIELD_MIME_TYPE = "mime-type"; //$NON-NLS-1$
  XmlRpcStruct                thumbnail;
  XmlRpcStruct                medium;
  XmlRpcStruct                large;
  XmlRpcStruct                full;

  @Override
  public String toString() {
    return WordpressString.toString(this);
  }

  public MediaItemSizeData getFull() {
    MediaItemSizeData result = new MediaItemSizeData();
    result.fromXmlRpcStruct(this.full);
    result.setMime_type(this.full.getString(FIELD_MIME_TYPE));
    return result;
  }

  @SuppressWarnings("unchecked")
  public void setFull(MediaItemSizeData full) {
    this.full = full.toXmlRpcStruct();
    this.full.put(FIELD_MIME_TYPE, full.getMime_type());
  }

  public MediaItemSizeData getLarge() {
    MediaItemSizeData result = new MediaItemSizeData();
    result.fromXmlRpcStruct(this.large);
    result.setMime_type(this.large.getString(FIELD_MIME_TYPE));
    return result;
  }

  @SuppressWarnings("unchecked")
  public void setLarge(MediaItemSizeData large) {
    this.large = large.toXmlRpcStruct();
    this.large.put(FIELD_MIME_TYPE, large.getMime_type());
  }

  public MediaItemSizeData getMedium() {
    MediaItemSizeData result = new MediaItemSizeData();
    result.fromXmlRpcStruct(this.medium);
    result.setMime_type(this.medium.getString(FIELD_MIME_TYPE));
    return result;
  }

  @SuppressWarnings("unchecked")
  public void setMedium(MediaItemSizeData medium) {
    this.medium = medium.toXmlRpcStruct();
    this.medium.put(FIELD_MIME_TYPE, medium.getMime_type());
  }

  public MediaItemSizeData getThumbnail() {
    MediaItemSizeData result = new MediaItemSizeData();
    result.fromXmlRpcStruct(this.thumbnail);
    result.setMime_type(this.thumbnail.getString(FIELD_MIME_TYPE));
    return result;
  }

  @SuppressWarnings("unchecked")
  public void setThumbnail(MediaItemSizeData thumbnail) {
    this.thumbnail = thumbnail.toXmlRpcStruct();
    this.thumbnail.put(FIELD_MIME_TYPE, thumbnail.getMime_type());
  }
}
