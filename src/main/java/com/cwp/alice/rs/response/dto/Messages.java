package com.cwp.alice.rs.response.dto;

public class Messages
{
  private int type;

  public int getType() { return this.type; }

  public void setType(int type) { this.type = type; }

  private String title;

  public String getTitle() { return this.title; }

  public void setTitle(String title) { this.title = title; }

  private String subtitle;

  public String getSubtitle() { return this.subtitle; }

  public void setSubtitle(String subtitle) { this.subtitle = subtitle; }

  private String imageUrl;

  public String getImageUrl() { return this.imageUrl; }

  public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
