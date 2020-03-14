package com.cps.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;
import android.widget.ScrollView;

import com.cps.R;
import com.cps.databinding.ActivityAdmissionBinding;
import com.cps.models.requests.SendAdmission;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

public class Admission extends AppCompatActivity {

    ActivityAdmissionBinding binding;
    SendAdmission admission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_admission);
        admission = new SendAdmission();
        binding.vpAdmission.setAdapter(new MyPagerAdapter(this));
        // disable user swipe
        binding.vpAdmission.setUserInputEnabled(false);
        binding.tlVpDots.setViewPager2(binding.vpAdmission);

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
                //case 3: return ThirdFragment.newInstance("ThirdFragment, Instance 2");
                //case 4: return ThirdFragment.newInstance("ThirdFragment, Instance 3");
                default: return AdmissionPage1.newInstance(admission);
            }
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }
}
