package com.cps.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.cps.R;
import com.cps.databinding.FragmentAdmissionP1Binding;
import com.cps.models.requests.SendAdmission;

public class AdmissionPage1 extends Fragment {

    FragmentAdmissionP1Binding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_admission_p1, container, false);
        return binding.getRoot();
    }

    public static AdmissionPage1 newInstance(SendAdmission admission) {

        AdmissionPage1 f = new AdmissionPage1();
        /*Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);*/

        return f;
    }
}
