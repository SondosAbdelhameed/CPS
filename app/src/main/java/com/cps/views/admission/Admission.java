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

import com.cps.R;
import com.cps.databinding.ActivityAdmissionBinding;
import com.cps.models.requests.SendAdmission;
import com.cps.models.requests.SendAdmissionMedia;

import java.util.Arrays;
import java.util.List;


public class Admission extends AppCompatActivity {

    ActivityAdmissionBinding binding;
    SendAdmission admission = new SendAdmission();
    SendAdmissionMedia admissionMedia = new SendAdmissionMedia();
    Button next;

    List<Fragment> fragmentList = Arrays.asList(
            AdmissionPage1.newInstance(admission),
            AdmissionPage2.newInstance(admission),
            AdmissionPage3.newInstance(admission),
            AdmissionPage4.newInstance(admission , admissionMedia)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_admission);
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
                Fragment fragment = fragmentList.get(binding.vpAdmission.getCurrentItem());
                if (fragment instanceof AdmissionPage1) {
                    if (((AdmissionPage1) fragment).isValidate()) {
                        binding.scrollView.scrollTo(0, 0);
                        binding.vpAdmission.setCurrentItem(binding.vpAdmission.getCurrentItem() + 1, true);
                    }
                } else if (fragment instanceof AdmissionPage2) {
                    if (((AdmissionPage2) fragment).isValidate()) {
                        binding.scrollView.scrollTo(0, 0);
                        binding.vpAdmission.setCurrentItem(binding.vpAdmission.getCurrentItem() + 1, true);
                    }
                } else if (fragment instanceof AdmissionPage3) {
                    if (((AdmissionPage3) fragment).isValidate()) {
                        binding.scrollView.scrollTo(0, 0);
                        binding.vpAdmission.setCurrentItem(binding.vpAdmission.getCurrentItem() + 1, true);
                    }
                } else if (fragment instanceof AdmissionPage4) {
                    if (((AdmissionPage4) fragment).isValidate()) {
                        /**
                         *
                         * finish admission
                         * */
                    }
                }

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
            return fragmentList.get(position);
//            switch (position) {
//
//                case 1: return AdmissionPage2.newInstance(admission);
//                case 2: return AdmissionPage3.newInstance(admission);
//                case 3: return AdmissionPage4.newInstance(admission);
//                default: return AdmissionPage1.newInstance(admission);
//            }
        }

        @Override
        public int getItemCount() {
            return fragmentList.size();
        }
    }
}
