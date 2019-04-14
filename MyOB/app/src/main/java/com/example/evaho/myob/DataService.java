package com.example.evaho.myob;

import java.util.ArrayList;
import java.util.List;

public class DataService {

    static List<Training> getTrainings(){

        final Training t1 = new Training("2019-02-01","Stromovka", "5.9", "6:01", "31:35");
        final Training t2 = new Training("2019-02-03","Holmenkollen", "6.7", "5:57" ,"30:02" );

        List<Training> list  = new ArrayList<Training>();
        list.add(t1);
        list.add(t2);

        return list;
    }
}
