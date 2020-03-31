package eu.upce.livescore.match.view.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import eu.upce.livescore.common.view.adapters.AbstractAdapter;
import eu.upce.livescore.common.view.adapters.viewholders.SubscribedViewHolder;
import eu.upce.livescore.match.R;
import eu.upce.livescore.match.R2;
import eu.upce.livescore.match.model.domain.Match;
import eu.upce.livescore.match.model.domain.MatchState;
import eu.upce.livescore.match.view.adapters.MatchListAdapter.MatchViewHolder;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;

public class MatchListAdapter extends AbstractAdapter<Match, MatchViewHolder> {

  private static final String TIME_FORMAT_PATTERN = "HH:mm";
  private static final DateTimeFormatter LOCAL_TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT_PATTERN);

  private Context context;

  public MatchListAdapter(Context context, List<Match> matches) {
    super(matches);
    this.context = context;
  }

  @Override
  protected void setItemViewHolder(Match item, MatchViewHolder viewHolder) {
    viewHolder.tvHomeTeam.setText(item.getHomeTeam().getName());
    viewHolder.tvAwayTeam.setText(item.getAwayTeam().getName());
    viewHolder.setTimeTextView(context, item.getDateTime(), item.getTime());
    viewHolder.setSubscribeButtonImage(context, item.isSubscribed());
    viewHolder.setMatchGoals(context, item.getHomeTeam().getGoals(), item.getAwayTeam().getGoals(), item.getTime());
  }

  @Override
  protected int getLayoutCode() {
    return R.layout.match_list_item;
  }

  @Override
  protected MatchViewHolder createAdapterViewHolder(View view) {
    return new MatchViewHolder(view);
  }

  static class MatchViewHolder extends SubscribedViewHolder {

    @BindView(R2.id.tvTime)
    TextView tvTime;
    @BindView(R2.id.tvHomeTeam)
    TextView tvHomeTeam;
    @BindView(R2.id.tvAwayTeam)
    TextView tvAwayTeam;
    @BindView(R2.id.tvHomeTeamGoals)
    TextView tvHomeTeamGoals;
    @BindView(R2.id.tvAwayTeamGoals)
    TextView tvAwayTeamGoals;

    public MatchViewHolder(@NonNull View itemView) {
      super(itemView);
    }

    private void setTimeTextView(Context context, LocalDateTime dateTime, String time) {
      if (time == null || time.equals(MatchState.NOT_STARTED)) {
        tvTime.setText(dateTime.format(LOCAL_TIME_FORMATTER));
      } else if (time.equals(MatchState.FINISHED))  {
        tvTime.setText(context.getText(R.string.finished_match));
      } else if (time.equals(MatchState.POSTPONED)) {
        tvTime.setText(context.getText(R.string.postponed_match));
      } else {
        int color = context.getColor(android.R.color.holo_red_dark);
        tvTime.setTextColor(color);
        tvTime.setText(time);
      }
    }

    private void setMatchGoals(Context context, Integer homeGoals, Integer awayGoals, String time) {
      if (time != null && !Arrays.asList(MatchState.NOT_STARTED, MatchState.POSTPONED).contains(time)) {
        if (!time.equals(MatchState.FINISHED)) {
          int color = context.getColor(android.R.color.holo_red_dark);
          tvHomeTeamGoals.setTextColor(color);
          tvAwayTeamGoals.setTextColor(color);
        }
        tvHomeTeamGoals.setText(toString(homeGoals));
        tvAwayTeamGoals.setText(toString(awayGoals));
      }
    }

    private String toString(Integer number) {
      return String.format(Locale.getDefault(),"%d", number);
    }
  }
}