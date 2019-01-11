package util;

import org.junit.Before;
import org.junit.Test;
import util.impl.DefaultFileOperator;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by adere on 11.01.2019.
 */
public class UtilityTest {

    private static final String FILE_NAME = "testList.txt";
    private static final String OUTPUT_FILE_NAME = "outputTest.txt";

    private DefaultFileOperator testFileOperator;

    @Before
    public void setTestFileOperator() {
        testFileOperator = new DefaultFileOperator(FILE_NAME);
        testFileOperator.readContent();
    }

    @Test
    public void Is_File_Exist() {

        assertTrue(testFileOperator.checkFileExist());

    }


    @Test
    public void Get_Number_Of_Rows_Correct() {

        assertEquals(8, testFileOperator.getNumberOfRows());
    }



    @Test
    public void Get_First_Row() {

        assertEquals("Belit", testFileOperator.readLine(0));
    }

    @Test
    public void Write_anagrams() {
        List<String> outputs = new ArrayList<String>();

        outputs.add("hey Hilal");
        outputs.add("hey Belit");
        outputs.add("hey Ali");

        testFileOperator.setOutputWords(outputs);

        testFileOperator.writeWordsToFile(OUTPUT_FILE_NAME);

        testFileOperator.setFileName(OUTPUT_FILE_NAME);

        testFileOperator.readContent();

        assertEquals("hey Hilal", testFileOperator.readLine(0));



    }

    /*
    @Test
    public void Get_All_Rows() {

        List<String> myWords = testFileOperator.getAllWords();



    }
    */
/*
    @Test
    public void Is_File_Not_Exist_Exception() {

    }
*/
}
