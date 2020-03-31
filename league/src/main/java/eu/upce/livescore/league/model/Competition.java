package eu.upce.livescore.league.model;

import eu.upce.livescore.common.model.ListItem;

public class Competition extends ListItem {

  private boolean isCup;

  public boolean isCup() {
    return isCup;
  }

  public void setCup(boolean cup) {
    isCup = cup;
  }
}
