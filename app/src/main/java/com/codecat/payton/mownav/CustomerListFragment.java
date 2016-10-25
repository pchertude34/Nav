package com.codecat.payton.mownav;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by paytonchertude on 10/18/16.
 */
public class CustomerListFragment extends Fragment
{
    private RecyclerView mCustomerRecyclerView;
    private CustomerAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_customer_list, container, false);

        mCustomerRecyclerView = (RecyclerView) v.findViewById(R.id.cusotmer_recycler_view);
        mCustomerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return v;
    }

    private void updateUI()
    {
        CustomerLab customerLab = CustomerLab.get(getActivity());
        List<Customer> customers = customerLab.getCustomers();

        if (mAdapter == null)
        {
            mAdapter = new CustomerAdapter(customers);
            mCustomerRecyclerView.setAdapter(mAdapter);
        }
        else
        {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class CustomerHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private Customer mCustomer;

        private TextView mNameTextView;
        private TextView mAddressTextView;
        private CheckBox mDeliveredCheckBox;

        public CustomerHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);

            mNameTextView = (TextView) itemView.findViewById(R.id.customer_name_text_view);
            mAddressTextView = (TextView) itemView.findViewById(R.id.customer_address_text_view);
            mDeliveredCheckBox = (CheckBox) itemView.findViewById(R.id.customer_delivered_check_box);
            mDeliveredCheckBox.setEnabled(false);
        }

        public void bindCustomer(Customer customer)
        {
            mCustomer = customer;
            mNameTextView.setText(mCustomer.getName());
            mAddressTextView.setText(mCustomer.getAddress());
            mDeliveredCheckBox.setChecked(mCustomer.isDelivered());
        }

        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent(CustomerInfoActivity.newIntent(getActivity(), mCustomer.getId()))
        }
    }

    private class CustomerAdapter extends RecyclerView.Adapter<CustomerHolder>
    {
        private List<Customer> mCustomers;

        public CustomerAdapter(List<Customer> customers)
        {
            mCustomers = customers;
        }

        @Override
        public CustomerHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View v = inflater.inflate(R.layout.list_item_customer, parent, false);
            return new CustomerHolder(v);
        }

        @Override
        public void onBindViewHolder(CustomerHolder holder, int position)
        {
            Customer customer = mCustomers.get(position);
            holder.bindCustomer(customer);
        }

        @Override
        public int getItemCount()
        {
            return mCustomers.size();
        }
    }
}
