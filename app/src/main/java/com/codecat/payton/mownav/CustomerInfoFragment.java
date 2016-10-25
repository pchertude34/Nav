package com.codecat.payton.mownav;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by paytonchertude on 10/13/16.
 */
public class CustomerInfoFragment extends Fragment
{
    private static final String LOG_MSG = "CustomerInfoFragment";

    private TextView mCustomerNameText;
    private TextView mCustomerAddressText;
    private TextView mCustomerMealText;
    private TextView mCustomerSideText;
    private TextView mCustomerDrinkText;

    private Button mMapButton;
    private Button mNotesButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.customer_info_fragment, container, false);

        mCustomerNameText    = (TextView) view.findViewById(R.id.customer_name_text_view);
        mCustomerAddressText = (TextView) view.findViewById(R.id.customer_address_text_view);
        mCustomerMealText    = (TextView) view.findViewById(R.id.customer_meal_order_text_view);
        mCustomerSideText    = (TextView) view.findViewById(R.id.customer_side_order_text_view);
        mCustomerDrinkText   = (TextView) view.findViewById(R.id.customer_drink_order_text_view);

        mMapButton           = (Button) view.findViewById(R.id.map_button);
        mNotesButton         = (Button) view.findViewById(R.id.customer_notes_button);




        mMapButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getActivity(), "Maps not enabled yet", Toast.LENGTH_SHORT).show();

            }
        });


        mNotesButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getActivity(), "Notes not enabled yet", Toast.LENGTH_SHORT).show();
                Log.d(LOG_MSG, "button pressed");
            }
        });
        return view;
    }
}
