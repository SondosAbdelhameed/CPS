package com.cps.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.cps.R;
import com.cps.databinding.FragmentAdmissionP1Binding;
import com.cps.databinding.FragmentAdmissionP2Binding;
import com.cps.models.requests.SendAdmission;

public class AdmissionPage2 extends Fragment {

    FragmentAdmissionP2Binding binding;
    SendAdmission admission;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_admission_p2, container, false);
        admission = (SendAdmission) getArguments().getSerializable("admission");
        binding.setAdmission(admission);
        Toast.makeText(getContext(), admission.getStuNationalId(), Toast.LENGTH_SHORT).show();
        return binding.getRoot();
    }

    public static AdmissionPage2 newInstance(SendAdmission admission) {

        AdmissionPage2 f = new AdmissionPage2();
        Bundle b = new Bundle();
        b.putSerializable("admission", admission);

        f.setArguments(b);

        return f;
    }

    public boolean isValidate() {


        /**
         * if return false show the error message for each fragment
         * */
        return true;
    }
}
