package com.codecat.payton.mownav;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CustomerInfoActivity extends SingleFragmentActivity
{

    protected Fragment createFragment()
    {
        return new CustomerInfoFragment();
    }
}
