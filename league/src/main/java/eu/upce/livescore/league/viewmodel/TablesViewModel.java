package eu.upce.livescore.league.viewmodel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.upce.livescore.common.viewmodel.MockViewModel;
import eu.upce.livescore.league.R;
import eu.upce.livescore.league.model.Competition;
import java.util.List;

public class TablesViewModel extends MockViewModel<Competition> {

  public TablesViewModel(ObjectMapper objectMapper) {
    super(objectMapper);
  }

  @Override
  protected TypeReference<List<Competition>> getListTypeReference() {
    return new TypeReference<List<Competition>>() {};
  }

  @Override
  protected int getMockCode() {
    return R.raw.competition_list;
  }
}