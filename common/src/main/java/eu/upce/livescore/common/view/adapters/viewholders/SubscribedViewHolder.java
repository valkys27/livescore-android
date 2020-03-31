package eu.upce.livescore.common.view.adapters.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import butterknife.BindView;
import eu.upce.livescore.common.R2;

public class SubscribedViewHolder extends ButterKnifeViewHolder {

  @BindView(R2.id.ibSubscribe)
  ImageButton ibSubscribe;

  public SubscribedViewHolder(@NonNull View itemView) {
    super(itemView);
  }

  public void setSubscribeButtonImage(Context context, boolean isSubscribed) {
    int imageCode = isSubscribed ?
        android.R.drawable.btn_star_big_on :
        android.R.drawable.btn_star_big_off;
    ibSubscribe.setBackground(context.getDrawable(imageCode));
  }
}
