package com.jsyoon.exanplistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by ShinwooEND on 2017-04-10.
 */

public class AdaptorMain extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<String> arrayGroup;
    private HashMap<String, ArrayList<String>> arrayChild;

    public  AdaptorMain(Context context, ArrayList<String> arrayGroup, HashMap<String ,ArrayList<String>> arrayChild ){
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
    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public boolean isChildSelectable(int groupPosition,int childPosition){
        return false;
    }

    // Adaptor에 필요한 getGroupView와 getChildView methods
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent){
        String groupName = arrayGroup.get(groupPosition);
        View v = convertView;

        if(v == null) {
            LayoutInflater inflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = (RelativeLayout)inflator.inflate(R.layout.lvi_group,null);
        }
        TextView textGroup = (TextView)v.findViewById(R.id.textGroup);
        textGroup.setText(groupName);

        return v;
    }

    public View getChildView(int groupPosition, int childPosition,boolean isLastChild, View convertView, ViewGroup parent){
        String childName = arrayChild.get(arrayGroup.get(groupPosition)).get(childPosition);
        View v = convertView;

        if(v == null) {
            LayoutInflater inflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = (RelativeLayout)inflator.inflate(R.layout.lvi_child,null);
        }
        TextView textChild = (TextView)v.findViewById(R.id.textChild);
        textChild.setText(childName);

        return v;
    }
}
