package com.codecat.payton.mownav;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by paytonchertude on 10/13/16.
 */
public class CustomerLab
{
    private static CustomerLab sCustomerLab;
    private List<Customer> mCustomers;

    public static CustomerLab get(Context context)
    {
        if (sCustomerLab == null)
            sCustomerLab = new CustomerLab(context);

        return sCustomerLab;
    }

    private CustomerLab(Context context)
    {
        mCustomers = new ArrayList<>();
        for (int i = 0; i < 100; i++)
        {
            Customer c = new Customer();
            c.setName("Customer: " + i);
            c.setAddress(i+i+" Customer St");
            mCustomers.add(c);
        }
    }

    public void addCustomer(Customer c)
    {
        mCustomers.add(c);
    }

    public List<Customer> getCustomers()
    {
        return mCustomers;
    }

    /* Search for a Customer in the array by its UUID */
    public Customer getCustomer(UUID id)
    {
        for (Customer c : mCustomers)
        {
            if (c.getId() == id)
                //Customer UUID found
                return c;
        }

        //Customer UUID not found
        return null;
    }

    private void init()
    {


    }


}
