package com.jsyoon.exanplistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ExpandableListView listMain;

    // 여기 들어가는 String이 리스트뷰의 상위 리스트의 제목이 될 것들이다.
    // 즉 치킨 피자 중국집 이라는 문자열을 집어넣을 거다
    private ArrayList<String> arrayGroup = new ArrayList<String>() ;

    //이 맵에 짜장이니 짬뽕인니 하는 각 업종별 상세 메뉴가 들어간다
    //해쉬맵의 왼쪽 키는 문자열인데, 이것은 그룹 이름을 지정해 주면 된다.
    // 그룹 이름은 치킨 피자 중국집 이 세 개가 있으므로 키 쪽에는 이 세 값이 들어갈 것이다.
    private HashMap< String , ArrayList<String> > arrayChild = new HashMap< String , ArrayList<String> >();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listMain = (ExpandableListView) this.findViewById(R.id.expandableListView1);
        setArrayData();
        listMain.setAdapter(new AdaptorMain(this,arrayGroup,arrayChild));
    }

    private void setArrayData() {
        arrayGroup.add("피자");
        arrayGroup.add("치킨");
        arrayGroup.add("중국집");

        ArrayList<String> arrayPizza = new ArrayList<String>();
        arrayPizza.add("치즈");
        arrayPizza.add("고구마");
        arrayPizza.add("비싼거");

        ArrayList<String> arrayChicken = new ArrayList<String>();
        arrayChicken.add("후라이드");
        arrayChicken.add("양념");
        arrayChicken.add("간장");
        arrayChicken.add("생닭");

        ArrayList<String> arrayChinese = new ArrayList<String>();
        arrayChinese.add("짜장");
        arrayChinese.add("짬뽕");
        arrayChinese.add("볶음밥");
        arrayChinese.add("탕수육");
        arrayChinese.add("불도장");

        arrayChild.put(arrayGroup.get(0),arrayPizza);
        arrayChild.put(arrayGroup.get(1),arrayChicken);
        arrayChild.put(arrayGroup.get(2),arrayChinese);

    }
}
