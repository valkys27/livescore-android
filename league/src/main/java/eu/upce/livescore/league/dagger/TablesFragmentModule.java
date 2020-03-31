package eu.upce.livescore.league.dagger;

import androidx.lifecycle.ViewModelProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.Module;
import dagger.Provides;
import eu.upce.livescore.league.viewmodel.TablesViewModel;

@Module
public class TablesFragmentModule {

  @Provides
  ViewModelProvider.Factory provideViewModelFactory(ObjectMapper objectMapper) {
    return new TablesViewModel.Factory(objectMapper);
  }
}
