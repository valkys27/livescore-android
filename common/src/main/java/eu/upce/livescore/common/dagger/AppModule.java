package eu.upce.livescore.common.dagger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.threetenbp.ThreeTenModule;
import dagger.Module;
import dagger.Provides;
import eu.upce.livescore.common.model.Country;
import eu.upce.livescore.common.svg.SvgFlagUrlProvider;
import eu.upce.livescore.common.web.CountryDeserializer;

@Module
public class AppModule {

  @Provides
  ObjectMapper provideObjectMapper(CountryDeserializer countryDeserializer) {
    ObjectMapper objectMapper = new ObjectMapper();
    SimpleModule simpleModule = new SimpleModule();
    simpleModule.addDeserializer(Country.class, countryDeserializer);
    objectMapper.registerModule(simpleModule)
        .registerModule(new ThreeTenModule());
    return objectMapper;
  }

  @Provides
  CountryDeserializer provideCountryDeserializer(SvgFlagUrlProvider svgFlagUrlProvider) {
    return new CountryDeserializer(svgFlagUrlProvider);
  }

  @Provides
  SvgFlagUrlProvider provideFlagSvgUrlProvider() {
    return new SvgFlagUrlProvider();
  }
}
