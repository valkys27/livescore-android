package eu.upce.livescore.common.view.adapters.viewholders;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;

public abstract class ButterKnifeViewHolder extends RecyclerView.ViewHolder {

  public ButterKnifeViewHolder(@NonNull View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }
}
