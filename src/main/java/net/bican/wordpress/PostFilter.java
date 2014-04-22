package net.bican.wordpress;

public class PostFilter extends XmlRpcMapped {
  private String  post_type;
  private String  post_status;
  private Integer number;
  private Integer offset;
  private String  orderby;
  private String  order;

  public Integer getNumber() {
    return this.number;
  }

  public Integer getOffset() {
    return this.offset;
  }

  public String getOrder() {
    return this.order;
  }

  public String getOrderby() {
    return this.orderby;
  }

  public String getPost_status() {
    return this.post_status;
  }

  public String getPost_type() {
    return this.post_type;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public void setOrder(String order) {
    this.order = order;
  }

  public void setOrderby(String orderby) {
    this.orderby = orderby;
  }

  public void setPost_status(String post_status) {
    this.post_status = post_status;
  }

  public void setPost_type(String post_type) {
    this.post_type = post_type;
  }
}
