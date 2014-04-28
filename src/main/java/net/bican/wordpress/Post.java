package net.bican.wordpress;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import redstone.xmlrpc.XmlRpcArray;
import redstone.xmlrpc.XmlRpcStruct;

public class Post extends XmlRpcMapped {
  @Override
  public String toString() {
    return WordpressString.toString(this, false);
  }

  Integer      post_id;
  String       post_title;
  Date         post_date;
  Date         post_date_gmt;
  Date         post_modified;
  Date         post_modified_gmt;
  String       post_status;
  String       post_type;
  String       post_format;
  String       post_name;
  String       post_author;
  String       post_password;
  String       post_excerpt;
  String       post_content;
  String       post_parent;
  String       post_mime_type;
  String       link;
  String       guid;
  Integer      menu_order;
  String       comment_status;
  String       ping_status;
  Boolean      sticky;
  XmlRpcStruct post_thumbnail;
  XmlRpcArray  terms;
  XmlRpcArray  custom_fields;
  XmlRpcStruct enclosure;

  public Integer getPost_id() {
    return this.post_id;
  }

  public void setPost_id(Integer post_id) {
    this.post_id = post_id;
  }

  public String getPost_title() {
    return this.post_title;
  }

  public void setPost_title(String post_title) {
    this.post_title = post_title;
  }

  public Date getPost_date() {
    return this.post_date;
  }

  public void setPost_date(Date post_date) {
    this.post_date = post_date;
  }

  public Date getPost_date_gmt() {
    return this.post_date_gmt;
  }

  public void setPost_date_gmt(Date post_date_gmt) {
    this.post_date_gmt = post_date_gmt;
  }

  public Date getPost_modified() {
    return this.post_modified;
  }

  public void setPost_modified(Date post_modified) {
    this.post_modified = post_modified;
  }

  public Date getPost_modified_gmt() {
    return this.post_modified_gmt;
  }

  public void setPost_modified_gmt(Date post_modified_gmt) {
    this.post_modified_gmt = post_modified_gmt;
  }

  public String getPost_status() {
    return this.post_status;
  }

  public void setPost_status(String post_status) {
    this.post_status = post_status;
  }

  public String getPost_type() {
    return this.post_type;
  }

  public void setPost_type(String post_type) {
    this.post_type = post_type;
  }

  public String getPost_format() {
    return this.post_format;
  }

  public void setPost_format(String post_format) {
    this.post_format = post_format;
  }

  public String getPost_name() {
    return this.post_name;
  }

  public void setPost_name(String post_name) {
    this.post_name = post_name;
  }

  public String getPost_author() {
    return this.post_author;
  }

  public void setPost_author(String post_author) {
    this.post_author = post_author;
  }

  public String getPost_password() {
    return this.post_password;
  }

  public void setPost_password(String post_password) {
    this.post_password = post_password;
  }

  public String getPost_excerpt() {
    return this.post_excerpt;
  }

  public void setPost_excerpt(String post_excerpt) {
    this.post_excerpt = post_excerpt;
  }

  public String getPost_content() {
    return this.post_content;
  }

  public void setPost_content(String post_content) {
    this.post_content = post_content;
  }

  public String getPost_parent() {
    return this.post_parent;
  }

  public void setPost_parent(String post_parent) {
    this.post_parent = post_parent;
  }

  public String getPost_mime_type() {
    return this.post_mime_type;
  }

  public void setPost_mime_type(String post_mime_type) {
    this.post_mime_type = post_mime_type;
  }

  public String getLink() {
    return this.link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getGuid() {
    return this.guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  public Integer getMenu_order() {
    return this.menu_order;
  }

  public void setMenu_order(Integer menu_order) {
    this.menu_order = menu_order;
  }

  public String getComment_status() {
    return this.comment_status;
  }

  public void setComment_status(String comment_status) {
    this.comment_status = comment_status;
  }

  public String getPing_status() {
    return this.ping_status;
  }

  public void setPing_status(String ping_status) {
    this.ping_status = ping_status;
  }

  public Boolean getSticky() {
    return this.sticky;
  }

  public void setSticky(Boolean sticky) {
    this.sticky = sticky;
  }

  public MediaItem getPost_thumbnail() {
    MediaItem pt = new MediaItem();
    pt.fromXmlRpcStruct(this.post_thumbnail);
    return pt;
  }

  public void setPost_thumbnail(MediaItem post_thumbnail) {
    MediaItem pt = new MediaItem();
    this.post_thumbnail = pt.toXmlRpcStruct();
  }

  public Set<Term> getTerms() {
    Set<Term> result = new HashSet<>();
    for (Object o : this.terms) {
      Term term = new Term();
      term.fromXmlRpcStruct((XmlRpcStruct) o);
      result.add(term);
    }
    return result;
  }

  @SuppressWarnings("unchecked")
  public void setTerms(Set<Term> terms) {
    XmlRpcArray result = new XmlRpcArray();
    for (Term t : terms) {
      result.add(t.toXmlRpcStruct());
    }
    this.terms = result;
  }

  public Set<CustomField> getCustom_fields() {
    Set<CustomField> result = new HashSet<>();
    for (Object o : this.custom_fields) {
      CustomField cf = new CustomField();
      cf.fromXmlRpcStruct((XmlRpcStruct) o);
      result.add(cf);
    }
    return result;
  }

  @SuppressWarnings("unchecked")
  public void setCustom_fields(Set<CustomField> custom_fields) {
    XmlRpcArray result = new XmlRpcArray();
    for (CustomField t : custom_fields) {
      result.add(t.toXmlRpcStruct());
    }
    this.terms = result;
  }

  public Enclosure getEnclosure() {
    Enclosure result = new Enclosure();
    result.fromXmlRpcStruct(this.enclosure);
    return result;
  }

  public void setEnclosure(Enclosure enclosure) {
    this.enclosure = enclosure.toXmlRpcStruct();
  }
}
