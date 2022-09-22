package net.rcarz.jiraclient;


import net.sf.json.JSONArray;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Tatooi
 * @since 1.0
 */
public class FieldTest{

    @Test
    public void testToArray() {

        ArrayList<Object> iter = new ArrayList<>();
        iter.add("id11111");
        JSONArray jsonArray=null;
        try {
             jsonArray = Field.toArray(iter,"version",null);
        } catch (JiraException e) {
            e.printStackTrace();
        }
        System.out.println(jsonArray.toString());
    }
}