package com.example.cardiac_recorder;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a list of User.
 */
public class UserClass {
    public List<User> records = new ArrayList<>();//a list of type "User" declared

    /**
     * this method is used for adding new data.
     * an exception will be thrown if the data already exists.
     * @param data
     */
    public void addUserData(User data)
    {
        if(records.contains(data))
        {
            throw new IllegalArgumentException();
        }
        records.add(data);
    }

    /**
     * this method returns an instance of sorted record list
     * sort is based on first attribute by default
     * @return
     */
    public List<User> getData()
    {
        List<User>datalist = records;
        return datalist;
    }
    public List<User> getData(int x)
    {
        List<User>datalist = records;
        return datalist;
    }

    /**
     * this method is used for deleting a particular data
     * if the data doesnt exist,it will throw an exception
     * @param data
     */
    public void deleteUserData(User data)
    {
        List<User> datalist = records;
        if(datalist.contains(data))
        {
            records.remove(data);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * this method returns the size of the list
     * @return
     */
    public int count()
    {
        return records.size();
    }

}
