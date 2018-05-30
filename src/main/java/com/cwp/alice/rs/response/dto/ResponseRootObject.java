package com.cwp.alice.rs.response.dto;

import java.util.ArrayList;

public class ResponseRootObject
{
  private String speech;

  public String getSpeech() { return this.speech; }

  public void setSpeech(String speech) { this.speech = speech; }

  private String displayText;

  public String getDisplayText() { return this.displayText; }

  public void setDisplayText(String displayText) { this.displayText = displayText; }

  private Messages messages;

  public Messages getMessages() { return this.messages; }

  public void setMessages(Messages messages) { this.messages = messages; }

  private Data data;

  public Data getData() { return this.data; }

  public void setData(Data data) { this.data = data; }

  private ArrayList<ContextOut> contextOut;

  public ArrayList<ContextOut> getContextOut() { return this.contextOut; }

  public void setContextOut(ArrayList<ContextOut> contextOut) { this.contextOut = contextOut; }

  private String source;

  public String getSource() { return this.source; }

  public void setSource(String source) { this.source = source; }

  private FollowupEvent followupEvent;

  public FollowupEvent getFollowupEvent() { return this.followupEvent; }

  public void setFollowupEvent(FollowupEvent followupEvent) { this.followupEvent = followupEvent; }
}
