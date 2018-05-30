package com.cwp.alice.rs.request.dto;

public class Message
{
  private int type;

  public int getType() { return this.type; }

  public void setType(int type) { this.type = type; }

  private String speech;

  public String getSpeech() { return this.speech; }

  public void setSpeech(String speech) { this.speech = speech; }
}
