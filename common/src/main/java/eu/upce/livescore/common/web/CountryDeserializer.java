package eu.upce.livescore.common.web;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import eu.upce.livescore.common.model.Country;
import eu.upce.livescore.common.svg.SvgFlagUrlProvider;
import java.io.IOException;
import java.util.Optional;
import javax.inject.Inject;

public class CountryDeserializer extends JsonDeserializer<Country> {

  private final SvgFlagUrlProvider svgFlagUrlProvider;

  @Inject
  public CountryDeserializer(SvgFlagUrlProvider svgFlagUrlProvider) {
    this.svgFlagUrlProvider = svgFlagUrlProvider;
  }

  @Override
  public Country deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    JsonNode node = p.getCodec().readTree(p);
    String name = node.get("name").asText();
    Optional<Country> country = Country.getByName(name);
    if (country.isPresent()) {
      if (country.get().getSvgFlagUrl() == null) {
        setFlagSvgUrl(country.get(), node);
      }
      return country.get();
    } else {
      return Country.UNKNOWN;
    }
  }

  private void setFlagSvgUrl(Country country, JsonNode node) {
    String flagSvgUrl;
    if (node.has("flag")) {
      flagSvgUrl = node.get("flag").textValue();
    } else {
      flagSvgUrl = svgFlagUrlProvider.getSvgFlagUrl(country.getName());
    }
    country.setSvgFlagUrl(flagSvgUrl);
  }
}
