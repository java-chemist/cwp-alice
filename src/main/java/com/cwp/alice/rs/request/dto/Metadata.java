package com.cwp.alice.rs.request.dto;

public class Metadata
{
  private String intentId;

  public String getIntentId() { return this.intentId; }

  public void setIntentId(String intentId) { this.intentId = intentId; }

  private String webhookUsed;

  public String getWebhookUsed() { return this.webhookUsed; }

  public void setWebhookUsed(String webhookUsed) { this.webhookUsed = webhookUsed; }

  private String webhookForSlotFillingUsed;

  public String getWebhookForSlotFillingUsed() { return this.webhookForSlotFillingUsed; }

  public void setWebhookForSlotFillingUsed(String webhookForSlotFillingUsed) { this.webhookForSlotFillingUsed = webhookForSlotFillingUsed; }

  private int nluResponseTime;

  public int getNluResponseTime() { return this.nluResponseTime; }

  public void setNluResponseTime(int nluResponseTime) { this.nluResponseTime = nluResponseTime; }

  private String intentName;

  public String getIntentName() { return this.intentName; }

  public void setIntentName(String intentName) { this.intentName = intentName; }
}