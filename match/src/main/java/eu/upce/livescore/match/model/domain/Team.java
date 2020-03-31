package eu.upce.livescore.match.model.domain;

public class Team {

  private String id;
  private String name;
  private Integer goals;
  private Integer halfTimeGoals;
  private TeamStats teamStats;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getGoals() {
    return goals;
  }

  public void setGoals(Integer goals) {
    this.goals = goals;
  }

  public Integer getHalfTimeGoals() {
    return halfTimeGoals;
  }

  public void setHalfTimeGoals(Integer halfTimeGoals) {
    this.halfTimeGoals = halfTimeGoals;
  }

  public TeamStats getTeamStats() {
    return teamStats;
  }

  public void setTeamStats(TeamStats teamStats) {
    this.teamStats = teamStats;
  }
}
