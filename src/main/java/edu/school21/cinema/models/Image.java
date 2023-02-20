package edu.school21.cinema.models;

public class Image {
  private User owner;
  private String realName;
  private String uniqueName;
  private String mime;
  private Long size;

  public Image(User owner, String realName, String uniqueName, String mime, Long size) {
    this.owner = owner;
    this.realName = realName;
    this.uniqueName = uniqueName;
    this.mime = mime;
    this.size = size;
  }

  public Image() {}

  public Image(String realName, String uniqueName, String mime, long size) {
    this.realName = realName;
    this.uniqueName = uniqueName;
    this.mime = mime;
    this.size = size;
  }

  public User getOwner() {
    return owner;
  }

  public String getRealName() {
    return realName;
  }

  public String getUniqueName() {
    return uniqueName;
  }

  public String getMime() {
    return mime;
  }

  public Long getSize() {
    return size;
  }
}
