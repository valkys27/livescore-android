package eu.upce.livescore.league.dagger;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import eu.upce.livescore.league.view.TablesFragment;

@Module
public abstract class TablesFragmentProvider {

  @ContributesAndroidInjector(modules = TablesFragmentModule.class)
  abstract TablesFragment provideTablesFragmentFactory();
}
