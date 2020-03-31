package eu.upce.livescore.common.viewmodel;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.inject.Inject;

public abstract class MockViewModel<T> extends ViewModel {

  private final ObjectMapper objectMapper;

  private MutableLiveData<List<T>> data;

  public MockViewModel(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  abstract protected TypeReference<List<T>> getListTypeReference();

  abstract protected int getMockCode();

  public void init(Context context) {
    if (data == null) {
      InputStream content = context.getResources().openRawResource(getMockCode());
      List<T> data = readData(content, getListTypeReference());
      this.data = new MutableLiveData<>(data);
    }
  }

  private List<T> readData(InputStream inputStream, TypeReference<List<T>> listTypeReference) {
    ObjectReader objectReader = objectMapper.readerFor(listTypeReference);
    List<T> data = null;
    try {
      data = objectReader.readValue(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return data;
  }

  public LiveData<List<T>> getData() {
    return data;
  }

  public static class Factory implements ViewModelProvider.Factory {

    private final ObjectMapper objectMapper;

    @Inject
    public Factory(ObjectMapper objectMapper) {
      this.objectMapper = objectMapper;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
      try {
        return modelClass.getConstructor(ObjectMapper.class).newInstance(objectMapper);
      } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
        throw new RuntimeException("Error during " + modelClass.getName() + " creation.", e);
      }
    }
  }
}
