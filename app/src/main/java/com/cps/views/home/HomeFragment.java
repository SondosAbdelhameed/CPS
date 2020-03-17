package com.cps.views.home;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.cps.R;
import com.cps.databinding.FragmentHomeBinding;
import com.cps.models.responses.EventsNewsItem;
import com.google.android.material.snackbar.Snackbar;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    FragmentHomeBinding binding;

    ProgressDialog dialog;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false);
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        binding.setViewModel(homeViewModel);
        dialog = new ProgressDialog(getContext());
        dialog.setCancelable(false);
        dialog.setMessage(getString(R.string.loading));
        dialog.show();

        // final TextView textView = root.findViewById(R.id.text_home);


        homeViewModel.newsLiveData.observe(getViewLifecycleOwner(), item -> {
            if (item == null) return;
            binding.setNews(item);
            homeViewModel.request_event();

        });


        homeViewModel.eventLiveData.observe(getViewLifecycleOwner(), item -> {
            if (item == null) return;
                dialog.dismiss();
            binding.setEvent(item);
        });

        homeViewModel.errorLiveData.observe(getViewLifecycleOwner(), throwable -> {
            if (throwable == null) return;
            dialog.dismiss();
            Snackbar.make(binding.getRoot(), "error : " + throwable.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
        });

        homeViewModel.request_news();

        return binding.getRoot();
    }
}