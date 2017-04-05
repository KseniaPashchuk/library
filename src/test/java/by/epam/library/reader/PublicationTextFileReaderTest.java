package by.epam.library.reader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PublicationTextFileReaderTest {
    private String nonexistent = "input\\noneexistent.txt";
    private String empty = "input\\empty.txt";
    private String real = "input\\input.txt";

    private PublicationReader reader;
    private List<String> result;

    @Before
    public void initTest() {
        reader = new PublicationTextFileReader();
    }

    @After
    public void destroy() {
        reader = null;
        result = null;
    }

    @Test(expected = RuntimeException.class)
    public void readNonexistentFileTest() throws Exception {
        reader.read(nonexistent);
    }


    @Test(expected = RuntimeException.class)
    public void readEmptyFileTest() throws Exception {
        reader.read(empty);
    }

    @Test
    public void readNormFileTest() throws Exception {
        result = reader.read(real);
        assertEquals(10, result.size());
    }

}