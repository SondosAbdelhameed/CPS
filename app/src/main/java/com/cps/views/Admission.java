package com.cps.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ScrollView;

import com.cps.R;
import com.cps.databinding.ActivityAdmissionBinding;
import com.cps.models.requests.SendAdmission;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

public class Admission extends AppCompatActivity {

    ActivityAdmissionBinding binding;
    ViewPager viewPager;
    SendAdmission admission;
    SpringDotsIndicator tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_admission);
        viewPager = binding.vpAdmission;
        admission = new SendAdmission();
        tab = binding.tlVpDots;
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tab.setViewPager(viewPager);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

                case 0: return AdmissionPage1.newInstance(admission);
                case 1: return AdmissionPage2.newInstance(admission);
                case 2: return AdmissionPage3.newInstance(admission);
                //case 3: return ThirdFragment.newInstance("ThirdFragment, Instance 2");
                //case 4: return ThirdFragment.newInstance("ThirdFragment, Instance 3");
                default: return AdmissionPage1.newInstance(admission);
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
