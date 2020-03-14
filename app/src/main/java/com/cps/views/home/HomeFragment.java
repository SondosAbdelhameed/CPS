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

        homeViewModel.request_news().observe(this, new Observer<EventsNewsItem>() {
            @Override
            public void onChanged(@Nullable EventsNewsItem item) {
                dialog.dismiss();
                if (item != null){
                    binding.setNews(item);
                }else {
                    Toast.makeText(getContext(), "false", Toast.LENGTH_SHORT).show();

                }
            }
        });

        dialog.show();

        homeViewModel.request_event().observe(this, new Observer<EventsNewsItem>() {
            @Override
            public void onChanged(@Nullable EventsNewsItem item) {
                dialog.dismiss();
                if (item != null){
                    binding.setEvent(item);
                }else {
                    Toast.makeText(getContext(), "false", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return binding.getRoot();
    }
}