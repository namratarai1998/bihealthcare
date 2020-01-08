package adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> fragementTitle = new ArrayList<>();
    public ViewPagerAdapter(FragmentManager fm){

        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }


    @Override
    public int getCount() {
        return fragmentList.size();
    }

    //to display the title of fragment

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragementTitle.get(position);
    }

    //to add the fragment and title to the list

    public void addFragement(Fragment fragment, String title){
        fragmentList.add(fragment);
        fragementTitle.add(title);
    }


}
