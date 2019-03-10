package com.example.evaho.myob;

import java.util.ArrayList;
import java.util.List;

public class DataService {

    static List<Training> getTrainings(){

        final Training t1 = new Training("2019-02-01","Stromovka");
        final Training t2 = new Training("2019-02-03","Holmenkollen");

        List<Training> list  = new ArrayList<Training>();
        list.add(t1);
        list.add(t2);

        return list;
    }
}
