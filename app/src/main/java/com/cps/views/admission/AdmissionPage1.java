package com.cps.views.admission;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.cps.R;
import com.cps.databinding.FragmentAdmissionP1Binding;
import com.cps.models.requests.SendAdmission;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AdmissionPage1 extends Fragment {

    FragmentAdmissionP1Binding binding;
    SendAdmission admission;
    Calendar myCalendar = Calendar.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_admission_p1, container, false);
        admission = (SendAdmission) getArguments().getSerializable("admission");
        binding.setAdmission(admission);
        binding.tvBirthDate.setOnClickListener(v -> {
            DatePickerDialog.OnDateSetListener date = calendar();
            openCalendar1(date);
        });
        return binding.getRoot();
    }

    public static AdmissionPage1 newInstance(SendAdmission admission) {

        AdmissionPage1 f = new AdmissionPage1();
        Bundle b = new Bundle();
        b.putSerializable("admission", admission);

        f.setArguments(b);

        return f;
    }

    public boolean isValidate() {

        boolean check = true;
       /* if(admission.getStuNationalId() == null || admission.getStuNationalId().isEmpty()) {
            check = false;
            binding.etStuNationalId.setError(getString(R.string.error_empty_data));
        }*/


        /**
         * if return false show the error message for each fragment
         * */
        return check;
    }

    void openCalendar1(DatePickerDialog.OnDateSetListener date){
        new DatePickerDialog(getContext(), date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    DatePickerDialog.OnDateSetListener calendar(){
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                binding.getAdmission().setStuBirthDate(sdf.format(myCalendar.getTime()));
            }

        };
        return date;
    }

    /*public void openGallery(View view){
        DatePickerDialog.OnDateSetListener date = calendar();
        openCalendar1(date);
    }*/

}
