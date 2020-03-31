package eu.upce.livescore.ui.components;

import com.jakewharton.threetenabp.AndroidThreeTen;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import eu.upce.livescore.ui.dagger.DaggerMainComponent;

public class LiveScoreApplication extends DaggerApplication {

  @Override
  public void onCreate() {
    super.onCreate();
    AndroidThreeTen.init(this);
  }

  @Override
  protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    return DaggerMainComponent.builder().create(this);
  }
}
