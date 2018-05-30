package com.cwp.alice.rs.request.dto;

import java.util.Date;

public class RequestRootObject
{
  private OriginalRequest originalRequest;

  public OriginalRequest getOriginalRequest() { return this.originalRequest; }

  public void setOriginalRequest(OriginalRequest originalRequest) { this.originalRequest = originalRequest; }

  private String id;

  public String getId() { return this.id; }

  public void setId(String id) { this.id = id; }

  private String sessionId;

  public String getSessionId() { return this.sessionId; }

  public void setSessionId(String sessionId) { this.sessionId = sessionId; }

  private Date timestamp;

  public Date getTimestamp() { return this.timestamp; }

  public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }

  private String timezone;

  public String getTimezone() { return this.timezone; }

  public void setTimezone(String timezone) { this.timezone = timezone; }

  private String lang;

  public String getLang() { return this.lang; }

  public void setLang(String lang) { this.lang = lang; }

  private Result result;

  public Result getResult() { return this.result; }

  public void setResult(Result result) { this.result = result; }
}


