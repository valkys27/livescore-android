package eu.upce.livescore.common.view.fragments;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.android.support.DaggerFragment;
import java.lang.reflect.ParameterizedType;
import javax.inject.Inject;

public abstract class BaseFragment<T extends ViewModel> extends DaggerFragment {

  @Inject
  ViewModelProvider.Factory viewModelProviderFactory;

  private T viewModel;

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    attachViewModel();
  }

  @Override
  public void onDetach() {
    super.onDetach();
  }

  protected T getViewModel() {
    return viewModel;
  }

  private void attachViewModel() {
    Class<T> viewModelClass = getViewModelClass();
    viewModel = new ViewModelProvider(getViewModelStore(), viewModelProviderFactory).get(viewModelClass);
  }

  @SuppressWarnings("unchecked")
  private Class<T> getViewModelClass() {
    return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  }
}
