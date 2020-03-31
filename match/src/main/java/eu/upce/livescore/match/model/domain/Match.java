package eu.upce.livescore.match.model.domain;

import org.threeten.bp.LocalDateTime;

public class Match {

  private String id;
  private String fixtureMatchId;
  private LocalDateTime dateTime;
  private String round;
  private String leagueId;
  private Team homeTeam;
  private Team awayTeam;
  private String time;
  private boolean subscribed;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFixtureMatchId() {
    return fixtureMatchId;
  }

  public void setFixtureMatchId(String fixtureMatchId) {
    this.fixtureMatchId = fixtureMatchId;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public String getRound() {
    return round;
  }

  public void setRound(String round) {
    this.round = round;
  }

  public String getLeagueId() {
    return leagueId;
  }

  public void setLeagueId(String leagueId) {
    this.leagueId = leagueId;
  }

  public Team getHomeTeam() {
    return homeTeam;
  }

  public void setHomeTeam(Team homeTeam) {
    this.homeTeam = homeTeam;
  }

  public Team getAwayTeam() {
    return awayTeam;
  }

  public void setAwayTeam(Team awayTeam) {
    this.awayTeam = awayTeam;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public boolean isSubscribed() {
    return subscribed;
  }

  public void setSubscribed(boolean subscribed) {
    this.subscribed = subscribed;
  }
}
