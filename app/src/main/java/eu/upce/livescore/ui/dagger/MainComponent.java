package eu.upce.livescore.ui.dagger;

import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import eu.upce.livescore.common.dagger.AppModule;
import eu.upce.livescore.league.dagger.TablesFragmentProvider;
import eu.upce.livescore.match.dagger.live.LiveFragmentProvider;
import eu.upce.livescore.match.dagger.matches.MatchesFragmentProvider;
import eu.upce.livescore.ui.components.LiveScoreApplication;
import javax.inject.Singleton;

@Singleton
@Component(
    modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        LiveFragmentProvider.class,
        MatchesFragmentProvider.class,
        TablesFragmentProvider.class
    }
)
public interface MainComponent extends AndroidInjector<LiveScoreApplication> {

  @Component.Builder
  abstract class Builder extends AndroidInjector.Builder<LiveScoreApplication> {}

  ObjectMapper objectMapper();
}
