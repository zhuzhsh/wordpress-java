package net.bican.wordpress;

import java.util.Date;

import redstone.xmlrpc.XmlRpcStruct;

public class MediaItem extends XmlRpcMapped {
  Integer      attachment_id;
  Date         date_created_gmt;
  Integer      parent;
  String       link;
  String       title;
  String       caption;
  String       description;
  XmlRpcStruct metadata;
  String       thumbnail;

  @Override
  public String toString() {
    return WordpressString.toString(this);
  }

  public Integer getAttachment_id() {
    return this.attachment_id;
  }

  public void setAttachment_id(Integer attachment_id) {
    this.attachment_id = attachment_id;
  }

  public Date getDate_created_gmt() {
    return this.date_created_gmt;
  }

  public void setDate_created_gmt(Date date_created_gmt) {
    this.date_created_gmt = date_created_gmt;
  }

  public Integer getParent() {
    return this.parent;
  }

  public void setParent(Integer parent) {
    this.parent = parent;
  }

  public String getLink() {
    return this.link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCaption() {
    return this.caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public MediaItemMetaData getMetadata() {
    MediaItemMetaData result = new MediaItemMetaData();
    result.fromXmlRpcStruct(this.metadata);
    return result;
  }

  public void setMetadata(MediaItemMetaData metadata) {
    this.metadata = metadata.toXmlRpcStruct();
  }

  public String getThumbnail() {
    return this.thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }
}
