package com.sharveshapps.myapplication.Home.MissionsFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.sharveshapps.myapplication.Home.MissionsFragment.Upcoming.UpcomingFragment;
import com.sharveshapps.myapplication.R;

public class MissionsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_missions, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout=view.findViewById(R.id.missions_tabLayout);
        ViewPager viewPager=view.findViewById(R.id.missions_vp);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new UpcomingFragment(), "Upcoming");
        adapter.addFragment(new CompletedFragment(), "Completed");
        viewPager.setAdapter(adapter);
    }
}