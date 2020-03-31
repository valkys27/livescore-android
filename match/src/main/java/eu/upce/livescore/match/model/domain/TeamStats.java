package eu.upce.livescore.match.model.domain;

public class TeamStats {

  private Integer shots;
  private Integer targetShots;
  private Integer corners;
  private Integer fouls;

  public Integer getShots() {
    return shots;
  }

  public void setShots(Integer shots) {
    this.shots = shots;
  }

  public Integer getTargetShots() {
    return targetShots;
  }

  public void setTargetShots(Integer targetShots) {
    this.targetShots = targetShots;
  }

  public Integer getCorners() {
    return corners;
  }

  public void setCorners(Integer corners) {
    this.corners = corners;
  }

  public Integer getFouls() {
    return fouls;
  }

  public void setFouls(Integer fouls) {
    this.fouls = fouls;
  }
}
