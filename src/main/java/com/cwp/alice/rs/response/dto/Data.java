package com.cwp.alice.rs.response.dto;

public class Data
{
  private Google google;

  public Google getGoogle() { return this.google; }

  public void setGoogle(Google google) { this.google = google; }

  private Facebook facebook;

  public Facebook getFacebook() { return this.facebook; }

  public void setFacebook(Facebook facebook) { this.facebook = facebook; }

  private Slack slack;

  public Slack getSlack() { return this.slack; }

  public void setSlack(Slack slack) { this.slack = slack; }
}
