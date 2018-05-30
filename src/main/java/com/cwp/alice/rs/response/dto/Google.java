package com.cwp.alice.rs.response.dto;

public class Google
{
  private boolean expectUserResponse;

  public boolean getExpectUserResponse() { return this.expectUserResponse; }

  public void setExpectUserResponse(boolean expectUserResponse) { this.expectUserResponse = expectUserResponse; }

  private RichResponse richResponse;

  public RichResponse getRichResponse() { return this.richResponse; }

  public void setRichResponse(RichResponse richResponse) { this.richResponse = richResponse; }
}