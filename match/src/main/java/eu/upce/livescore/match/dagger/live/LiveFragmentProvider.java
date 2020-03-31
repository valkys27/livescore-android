package eu.upce.livescore.match.dagger.live;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import eu.upce.livescore.match.view.fragments.list.LiveFragment;

@Module
public abstract class LiveFragmentProvider {

  @ContributesAndroidInjector(modules = LiveFragmentModule.class)
  abstract LiveFragment provideLiveFragmentFactory();
}
