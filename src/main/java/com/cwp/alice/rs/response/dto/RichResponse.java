package com.cwp.alice.rs.response.dto;

import java.util.ArrayList;

public class RichResponse
{
  private ArrayList<Item> items;

  public ArrayList<Item> getItems() { return this.items; }

  public void setItems(ArrayList<Item> items) { this.items = items; }
}