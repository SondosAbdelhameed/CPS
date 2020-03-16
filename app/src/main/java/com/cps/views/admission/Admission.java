package com.cps.views.admission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cps.R;
import com.cps.databinding.ActivityAdmissionBinding;
import com.cps.models.requests.SendAdmission;
import com.cps.views.AdmissionPage1;
import com.cps.views.AdmissionPage2;
import com.cps.views.AdmissionPage3;
import com.cps.views.AdmissionPage4;


public class Admission extends AppCompatActivity {

    ActivityAdmissionBinding binding;
    SendAdmission admission;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_admission);
        admission = new SendAdmission();
        next = binding.btnNext;
        binding.vpAdmission.setAdapter(new MyPagerAdapter(this));
        // disable user swipe
        binding.vpAdmission.setUserInputEnabled(false); // here you can enable or disable swipe
        binding.tlVpDots.setViewPager2(binding.vpAdmission);
        binding.tlVpDots.setDotsClickable(false);

        binding.vpAdmission.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if(position == 3)
                    next.setText("finish");
                else
                    next.setText(R.string.next);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.vpAdmission.getCurrentItem() < 3)
                    binding.vpAdmission.setCurrentItem(binding.vpAdmission.getCurrentItem()+1);
                else if(binding.vpAdmission.getCurrentItem() == 3)
                    Toast.makeText(Admission.this, "Last Page   "+admission.getStuNationalId(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private class MyPagerAdapter extends FragmentStateAdapter {

        public MyPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {

                case 0: return AdmissionPage1.newInstance(admission);
                case 1: return AdmissionPage2.newInstance(admission);
                case 2: return AdmissionPage3.newInstance(admission);
                case 3: return AdmissionPage4.newInstance(admission);
                default: return AdmissionPage1.newInstance(admission);
            }
        }

        @Override
        public int getItemCount() {
            return 4;
        }
    }
}
