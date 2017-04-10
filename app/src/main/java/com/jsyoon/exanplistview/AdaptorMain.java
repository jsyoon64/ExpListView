package com.jsyoon.exanplistview;

import android.content.Context;
import android.widget.BaseExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by ShinwooEND on 2017-04-10.
 */

public class AdapterMain extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<String> arrayGroup;
    private HashMap<String, ArrayList<String>> arrayChild;

    public  AdapterMain(Context context, ArrayList<String> arrayGroup, HashMap<String ,ArrayList<String>> arrayChild ){
        super();
        this.context = context;
        this.arrayGroup = arrayGroup;
        this.arrayChild = arrayChild;
    }

    @Override
    public int getGroupCount(){
        return arrayGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition){
        return arrayChild.get(arrayGroup.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groutPosition){
        return arrayGroup.get(groutPosition);
    }
    @Override
    public Object getChild(int groupPosition, int childPosition){
        return arrayChild.get(arrayGroup.get(groupPosition)).get(childPosition);
    }
    @Override
    public long getGroupId(int groupPosition){
        return groupPosition;
    }
    @Override
    public long getChildId(int groupPosition,int childPosition){
        return childPosition;
    }

}
