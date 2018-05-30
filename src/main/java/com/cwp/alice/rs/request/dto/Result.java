package com.cwp.alice.rs.request.dto;

import java.util.ArrayList;

public class Result
{
  private String source;

  public String getSource() { return this.source; }

  public void setSource(String source) { this.source = source; }

  private String resolvedQuery;

  public String getResolvedQuery() { return this.resolvedQuery; }

  public void setResolvedQuery(String resolvedQuery) { this.resolvedQuery = resolvedQuery; }

  private String speech;

  public String getSpeech() { return this.speech; }

  public void setSpeech(String speech) { this.speech = speech; }

  private String action;

  public String getAction() { return this.action; }

  public void setAction(String action) { this.action = action; }

  private boolean actionIncomplete;

  public boolean getActionIncomplete() { return this.actionIncomplete; }

  public void setActionIncomplete(boolean actionIncomplete) { this.actionIncomplete = actionIncomplete; }

  private Parameters parameters;

  public Parameters getParameters() { return this.parameters; }

  public void setParameters(Parameters parameters) { this.parameters = parameters; }

  private ArrayList<Context> contexts;

  public ArrayList<Context> getContexts() { return this.contexts; }

  public void setContexts(ArrayList<Context> contexts) { this.contexts = contexts; }

  private Metadata metadata;

  public Metadata getMetadata() { return this.metadata; }

  public void setMetadata(Metadata metadata) { this.metadata = metadata; }

  private Fulfillment fulfillment;

  public Fulfillment getFulfillment() { return this.fulfillment; }

  public void setFulfillment(Fulfillment fulfillment) { this.fulfillment = fulfillment; }

  private int score;

  public int getScore() { return this.score; }

  public void setScore(int score) { this.score = score; }
}
