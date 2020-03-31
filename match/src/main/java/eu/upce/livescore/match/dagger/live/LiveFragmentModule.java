package eu.upce.livescore.match.dagger.live;

import androidx.lifecycle.ViewModelProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.Module;
import dagger.Provides;
import eu.upce.livescore.match.viewmodel.LiveViewModel;

@Module
public class LiveFragmentModule {

  @Provides
  ViewModelProvider.Factory provideViewModelFactory(ObjectMapper objectMapper) {
    return new LiveViewModel.Factory(objectMapper);
  }
}
