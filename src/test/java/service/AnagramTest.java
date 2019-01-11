package service;

import org.junit.Before;
import org.junit.Test;
import service.impl.DefaultAnagram;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by adere on 11.01.2019.
 */
public class AnagramTest {

    private static final String FILE_NAME = "testList.txt";
    private static final String OUTPUT_FILE_NAME = "outputTest.txt";

    private Anagram myAnagram;

    @Before
    public void Setup() {

        myAnagram = new DefaultAnagram(FILE_NAME);
    }

    @Test
    public void Anagram_Extracted_Correctly() {

        myAnagram.perform();

        List<String> results = myAnagram.getAnagrams();

        assertEquals("Ali iLA", results.get(0));

    }
}
