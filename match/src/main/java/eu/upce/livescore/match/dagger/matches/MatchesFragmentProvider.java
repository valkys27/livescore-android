package eu.upce.livescore.match.dagger.matches;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import eu.upce.livescore.match.view.fragments.list.MatchesFragment;

@Module
public abstract class MatchesFragmentProvider {

  @ContributesAndroidInjector(modules = MatchesFragmentModule.class)
  abstract MatchesFragment provideMatchesFragmentFactory();
}
