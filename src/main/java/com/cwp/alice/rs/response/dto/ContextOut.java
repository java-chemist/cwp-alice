package com.cwp.alice.rs.response.dto;

public class ContextOut
{
  private String name;

  public String getName() { return this.name; }

  public void setName(String name) { this.name = name; }

  private int lifespan;

  public int getLifespan() { return this.lifespan; }

  public void setLifespan(int lifespan) { this.lifespan = lifespan; }

  private Parameters parameters;

  public Parameters getParameters() { return this.parameters; }

  public void setParameters(Parameters parameters) { this.parameters = parameters; }
}
