package eu.upce.livescore.match.view.fragments.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import eu.upce.livescore.common.view.fragments.BaseFragment;
import eu.upce.livescore.match.R;
import eu.upce.livescore.match.R2;
import eu.upce.livescore.match.view.adapters.MatchListAdapter;
import eu.upce.livescore.match.viewmodel.LiveViewModel;

public class LiveFragment extends BaseFragment<LiveViewModel> {

  @BindView(R2.id.paging_recycler)
  RecyclerView recyclerView;

  private MatchListAdapter listAdapter;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.list, container, false);
    ButterKnife.bind(this, root);
    getViewModel().init(getContext());
    getViewModel().getData().observe(getViewLifecycleOwner(), data -> listAdapter.notifyDataSetChanged());
    initRecyclerView();
    return root;
  }

  private void initRecyclerView() {
    listAdapter = new MatchListAdapter(getContext(), getViewModel().getData().getValue());
    RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    recyclerView.setLayoutManager(linearLayoutManager);
    recyclerView.setAdapter(listAdapter);
  }
}