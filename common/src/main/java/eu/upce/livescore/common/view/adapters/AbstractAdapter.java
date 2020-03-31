package eu.upce.livescore.common.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import eu.upce.livescore.common.view.adapters.viewholders.ButterKnifeViewHolder;
import java.util.List;

public abstract class AbstractAdapter<T, VH extends ButterKnifeViewHolder> extends RecyclerView.Adapter<VH> {

  private List<T> items;

  protected AbstractAdapter(List<T> items) {
    this.items = items;
  }

  abstract protected void setItemViewHolder(T item, VH viewHolder);

  abstract protected int getLayoutCode();

  abstract protected VH createAdapterViewHolder(View view);

  @NonNull
  @Override
  public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutCode(), parent, false);
    return createAdapterViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull VH holder, int position) {
    T item = items.get(position);
    if (item != null) {
      setItemViewHolder(item, holder);
    }
  }

  @Override
  public int getItemCount() {
    return items.size();
  }
}