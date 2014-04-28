package net.bican.wordpress;

public class MediaImageMeta extends XmlRpcMapped {
  Float  aperture;
  String credit;
  String camera;
  String caption;
  Long   created_timestamp;
  String copyright;
  Float  focal_length;
  Float  iso;
  Float  shutter_speed;
  String title;

  public Float getAperture() {
    return this.aperture;
  }

  public String getCamera() {
    return this.camera;
  }

  public String getCaption() {
    return this.caption;
  }

  public String getCopyright() {
    return this.copyright;
  }

  public Long getCreated_timestamp() {
    return this.created_timestamp;
  }

  public String getCredit() {
    return this.credit;
  }

  public Float getFocal_length() {
    return this.focal_length;
  }

  public Float getIso() {
    return this.iso;
  }

  public Float getShutter_speed() {
    return this.shutter_speed;
  }

  public String getTitle() {
    return this.title;
  }

  public void setAperture(Float aperture) {
    this.aperture = aperture;
  }

  public void setCamera(String camera) {
    this.camera = camera;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public void setCopyright(String copyright) {
    this.copyright = copyright;
  }

  public void setCreated_timestamp(Long created_timestamp) {
    this.created_timestamp = created_timestamp;
  }

  public void setCredit(String credit) {
    this.credit = credit;
  }

  public void setFocal_length(Float focal_length) {
    this.focal_length = focal_length;
  }

  public void setIso(Float iso) {
    this.iso = iso;
  }

  public void setShutter_speed(Float shutter_speed) {
    this.shutter_speed = shutter_speed;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return WordpressString.toString(this);
  }
}
