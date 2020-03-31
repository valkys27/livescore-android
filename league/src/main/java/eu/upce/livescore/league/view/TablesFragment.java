package eu.upce.livescore.league.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import eu.upce.livescore.common.R2;
import eu.upce.livescore.common.view.adapters.ListAdapter;
import eu.upce.livescore.common.view.fragments.BaseFragment;
import eu.upce.livescore.league.model.Competition;
import eu.upce.livescore.league.viewmodel.TablesViewModel;

public class TablesFragment extends BaseFragment<TablesViewModel> {

  @BindView(R2.id.paging_recycler)
  RecyclerView recyclerView;

  private ListAdapter<Competition> listAdapter;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(eu.upce.livescore.common.R.layout.list, container, false);
    ButterKnife.bind(this, root);
    getViewModel().init(getContext());
    getViewModel().getData().observe(getViewLifecycleOwner(), data -> listAdapter.notifyDataSetChanged());
    initRecyclerView();
    return root;
  }

  private void initRecyclerView() {
    listAdapter = new ListAdapter<>(getContext(), getViewModel().getData().getValue());
    RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    recyclerView.setLayoutManager(linearLayoutManager);
    recyclerView.setAdapter(listAdapter);
  }
}