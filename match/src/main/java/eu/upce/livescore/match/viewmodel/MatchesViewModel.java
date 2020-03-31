package eu.upce.livescore.match.viewmodel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.upce.livescore.common.viewmodel.MockViewModel;
import eu.upce.livescore.match.R;
import eu.upce.livescore.match.model.domain.Match;
import java.util.List;

public class MatchesViewModel extends MockViewModel<Match> {

  public MatchesViewModel(ObjectMapper objectMapper) {
    super(objectMapper);
  }

  protected TypeReference<List<Match>> getListTypeReference() {
    return new TypeReference<List<Match>>() {};
  }

  @Override
  protected int getMockCode() {
    return R.raw.match_list;
  }
}