package com.cwp.alice.rs.request.dto;

public class Context
{
  private String name;

  public String getName() { return this.name; }

  public void setName(String name) { this.name = name; }

  private Parameters2 parameters;

  public Parameters2 getParameters() { return this.parameters; }

  public void setParameters(Parameters2 parameters) { this.parameters = parameters; }

  private int lifespan;

  public int getLifespan() { return this.lifespan; }

  public void setLifespan(int lifespan) { this.lifespan = lifespan; }
}

