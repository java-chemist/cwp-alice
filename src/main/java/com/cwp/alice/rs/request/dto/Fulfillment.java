package com.cwp.alice.rs.request.dto;

import java.util.ArrayList;

public class Fulfillment
{
  private String speech;

  public String getSpeech() { return this.speech; }

  public void setSpeech(String speech) { this.speech = speech; }

  private ArrayList<Message> messages;

  public ArrayList<Message> getMessages() { return this.messages; }

  public void setMessages(ArrayList<Message> messages) { this.messages = messages; }
}

