package com.cps.views.events_news;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cps.R;
import com.cps.adapters.EventNewsAdapter;
import com.cps.databinding.FragmentNewsBinding;
import com.cps.models.responses.EventsNewsItem;

import java.util.List;

public class NewsFragment extends Fragment {

    private EventNewsViewModel viewModel;
    EventNewsAdapter adapter;
    FragmentNewsBinding binding;

    ProgressDialog dialog;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_news, container, false);

        RecyclerView recyclerView = binding.rcvNews;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);


        dialog = new ProgressDialog(getContext());
        dialog.setCancelable(false);
        dialog.setMessage(getString(R.string.loading));
        dialog.show();

        viewModel = ViewModelProviders.of(this).get(EventNewsViewModel.class);

        adapter = new EventNewsAdapter();
        recyclerView.setAdapter(adapter);
        viewModel.request_news().observe(this, new Observer<List<EventsNewsItem>>() {
            @Override
            public void onChanged(@Nullable List<EventsNewsItem> items) {
                dialog.dismiss();
                if (items != null){
                    Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
                    adapter.setItems(items,viewModel);

                }else {
                    Toast.makeText(getContext(), "false", Toast.LENGTH_SHORT).show();

                }
            }
        });
        return binding.getRoot();
    }
}