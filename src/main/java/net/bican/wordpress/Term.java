package net.bican.wordpress;

public class Term extends XmlRpcMapped {
  Integer term_id;
  String  name;
  String  slug;
  Integer term_group;
  Integer term_taxonomy_id;
  String  taxonomy;
  String  description;
  Integer parent;
  Integer count;

  @Override
  public String toString() {
    return WordpressString.toString(this);
  }

  public Integer getTerm_id() {
    return this.term_id;
  }

  public void setTerm_id(Integer term_id) {
    this.term_id = term_id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSlug() {
    return this.slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public Integer getTerm_group() {
    return this.term_group;
  }

  public void setTerm_group(Integer term_group) {
    this.term_group = term_group;
  }

  public Integer getTerm_taxonomy_id() {
    return this.term_taxonomy_id;
  }

  public void setTerm_taxonomy_id(Integer term_taxonomy_id) {
    this.term_taxonomy_id = term_taxonomy_id;
  }

  public String getTaxonomy() {
    return this.taxonomy;
  }

  public void setTaxonomy(String taxonomy) {
    this.taxonomy = taxonomy;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getParent() {
    return this.parent;
  }

  public void setParent(Integer parent) {
    this.parent = parent;
  }

  public Integer getCount() {
    return this.count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }
}
