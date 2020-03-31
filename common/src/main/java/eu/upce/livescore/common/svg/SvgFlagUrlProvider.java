package eu.upce.livescore.common.svg;

import eu.upce.livescore.common.model.Country;
import java.util.Optional;

public class SvgFlagUrlProvider {

  public String getSvgFlagUrl(String countryName) {
    Optional<Country> country = Country.getByName(countryName);
    if (country.isPresent() && country.get().getSvgFlagUrl() != null) {
      return country.get().getSvgFlagUrl();
    }
    return Country.UNKNOWN.getSvgFlagUrl();
  }
}
