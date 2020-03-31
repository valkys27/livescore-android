package eu.upce.livescore.common.model;

import java.util.Arrays;
import java.util.Optional;

public enum Country {

  UNKNOWN("Unknown", "https://upload.wikimedia.org/wikipedia/commons/5/55/Question_Mark.svg"),
  INTERNATIONAL("International", "https://upload.wikimedia.org/wikipedia/commons/e/ef/International_Flag_of_Planet_Earth.svg"),
  EUROPE("Europe", "https://upload.wikimedia.org/wikipedia/commons/b/b7/Flag_of_Europe.svg"),
  ENGLAND("England", "https://upload.wikimedia.org/wikipedia/commons/b/be/Flag_of_England.svg"),
  NORTHERN_IRELAND("Northern Ireland", "https://upload.wikimedia.org/wikipedia/commons/d/d0/Ulster_Banner.svg"),
  SCOTLAND("Scotland", "https://upload.wikimedia.org/wikipedia/commons/0/05/Flag_of_Scotland_%281542-2003%29.svg"),
  GERMANY("Germany", "https://restcountries.eu/data/deu.svg"),
  ITALY("Italy", "https://restcountries.eu/data/ita.svg"),
  FRANCE("France", "https://restcountries.eu/data/fra.svg"),
  SPAIN("Spain", "https://restcountries.eu/data/esp.svg"),
  GREECE("Greece", "https://restcountries.eu/data/grc.svg"),
  HOLLAND("Holland", "https://restcountries.eu/data/nld.svg"),
  BELGIUM("Belgium", "https://restcountries.eu/data/bel.svg"),
  TURKEY("Turkey", "https://restcountries.eu/data/tur.svg"),
  DENMARK("Denmark", "https://restcountries.eu/data/dnk.svg"),
  PORTUGAL("Portugal", "https://restcountries.eu/data/prt.svg"),
  USA("USA", "https://restcountries.eu/data/usa.svg"),
  SWEDEN("Sweden", "https://restcountries.eu/data/swe.svg"),
  MEXICO("Mexico", "https://restcountries.eu/data/mex.svg"),
  BRAZIL("Brazil", "https://restcountries.eu/data/bra.svg"),
  UKRAINE("Ukraine", "https://restcountries.eu/data/ukr.svg"),
  RUSSIA("Russia", "https://restcountries.eu/data/rus.svg"),
  AUSTRALIA("Australia", "https://restcountries.eu/data/aus.svg"),
  NORWAY("Norway", "https://restcountries.eu/data/nor.svg"),
  CHINA("China", "https://restcountries.eu/data/chn.svg"),
  POLAND("Poland", "https://restcountries.eu/data/pol.svg"),
  ARGENTINA("Argentina", "https://restcountries.eu/data/arg.svg"),
  ISRAEL("Israel", "https://restcountries.eu/data/isr.svg"),
  SAUDI_ARABIA("Saudi Arabia", "https://restcountries.eu/data/sau.svg"),
  CZECH_REPUBLIC("Czech Republic", "https://restcountries.eu/data/cze.svg"),
  FINLAND("Finland", "https://restcountries.eu/data/fin.svg");

  private final String name;
  private String svgFlagUrl;

  Country(String name, String svgFlagUrl) {
    this.name = name;
    this.svgFlagUrl = svgFlagUrl;
  }

  public static Optional<Country> getByName(String countryName) {
    return Arrays.stream(Country.values())
        .filter(country -> country.getName().equals(countryName))
        .findAny();
  }

  public String getName() {
    return name;
  }

  public String getSvgFlagUrl() {
    return svgFlagUrl;
  }

  public void setSvgFlagUrl(String svgFlagUrl) {
    this.svgFlagUrl = svgFlagUrl;
  }
}
