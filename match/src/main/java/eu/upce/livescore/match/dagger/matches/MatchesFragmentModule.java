package eu.upce.livescore.match.dagger.matches;

import androidx.lifecycle.ViewModelProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.Module;
import dagger.Provides;
import eu.upce.livescore.match.viewmodel.MatchesViewModel;

@Module
public class MatchesFragmentModule {

  @Provides
  ViewModelProvider.Factory providesViewModelFactory(ObjectMapper objectMapper) {
    return new MatchesViewModel.Factory(objectMapper);
  }
}
