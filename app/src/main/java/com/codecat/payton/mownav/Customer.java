package com.codecat.payton.mownav;

import java.util.UUID;

/**
 * Created by paytonchertude on 10/13/16.
 */
public class Customer
{
    private UUID mId;
    private String mName;
    private String mAddress;
    private boolean mDelivered;

    public Customer()
    {
        mId = UUID.randomUUID();
    }

    public void setName(String name)            { mName = name; }

    public void setAddress(String address)      { mAddress = address; }

    public void setDelivered(boolean delivered) { mDelivered = delivered; }

    public UUID getId()                         { return mId; }

    public String getName()                     { return mName; }

    public String getAddress()                  { return mAddress; }

    public boolean isDelivered()                { return mDelivered; }
}
