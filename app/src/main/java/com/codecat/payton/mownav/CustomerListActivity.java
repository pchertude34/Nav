package com.codecat.payton.mownav;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by paytonchertude on 10/18/16.
 */
public class CustomerListActivity extends SingleFragmentActivity
{
    protected Fragment createFragment()
    {
        return new CustomerListFragment();
    }

}
