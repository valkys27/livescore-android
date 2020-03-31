package eu.upce.livescore.common.view.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import eu.upce.livescore.common.R;
import eu.upce.livescore.common.R2;
import eu.upce.livescore.common.model.ListItem;
import eu.upce.livescore.common.svg.SvgLoader;
import eu.upce.livescore.common.view.adapters.ListAdapter.ListItemViewHolder;
import eu.upce.livescore.common.view.adapters.viewholders.SubscribedViewHolder;
import java.util.List;

public class ListAdapter<T extends ListItem> extends AbstractAdapter<T, ListItemViewHolder> {

  private final Context context;

  public ListAdapter(Context context, List<T> items) {
    super(items);
    this.context = context;
  }

  @Override
  protected void setItemViewHolder(ListItem item, ListItemViewHolder viewHolder) {
    viewHolder.loadCountryFlagImage(context, item.getCountry().getSvgFlagUrl());
    viewHolder.setSubscribeButtonImage(context, item.isSubscribed());
    viewHolder.tvName.setText(item.getName());
  }

  @Override
  protected int getLayoutCode() {
    return R.layout.list_item;
  }

  @Override
  protected ListItemViewHolder createAdapterViewHolder(View view) {
    return new ListItemViewHolder(view);
  }

  static class ListItemViewHolder extends SubscribedViewHolder {

    @BindView(R2.id.ivCountryFlag)
    ImageView ivCountryFlag;

    @BindView(R2.id.tvName)
    TextView tvName;

    public ListItemViewHolder(@NonNull View itemView) {
      super(itemView);
    }

    private void loadCountryFlagImage(Context context, String url) {
      Uri uri = Uri.parse(url);
      SvgLoader
          .with(context)
          .load(uri, ivCountryFlag);
    }
  }
}