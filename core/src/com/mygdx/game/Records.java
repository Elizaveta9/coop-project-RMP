package com.mygdx.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Records {

    static private String pathFile = "Record\\record.txt";

    public static void setRecords(int record) throws IOException {
        File file = new File(pathFile);
        FileWriter writer = new FileWriter(file);
        if (record > getRecords()){
            writer.write(record);
            writer.flush();
        }

    }

    public static int getRecords() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(new File(pathFile)));
        int record = Integer.parseInt(file.readLine());
        return record;
    }
}
