package by.epam.library.parser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@RunWith(Parameterized.class)
public class ParametersParserTest {
    private String testLine;
    private List<String> expected;

    public ParametersParserTest(String testLine, List<String> expected) {
        this.testLine = testLine;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> stepUp() {
        return Arrays.asList(new Object[][]{
                {"Book; Волшебник Изумрудного города;Эксмо;19.05; 200; Александр Волков; IMAGINATIVE;",
                        new ArrayList<String>() {{
                            add("Book");
                            add("Волшебник Изумрудного города");
                            add("Эксмо");
                            add("19.05");
                            add("200");
                            add("Александр Волков");
                            add("IMAGINATIVE");
                        }}},
                {"Magazine; Vogue; Conde Nast Publications; 1.25; 100; 10; monthly; glossy;", new ArrayList<String>() {{
                    add("Magazine");
                    add("Vogue");
                    add("Conde Nast Publications");
                    add("1.25");
                    add("100");
                    add("10");
                    add("monthly");
                    add("glossy");
                }}},
                {"_Котята_One_Love_", new ArrayList<String>() {{
                    add("Котята");
                    add("One");
                    add("Love");
                }}
                }
        });
    }

    @Test
    public void parse() throws Exception {
        assertThat(ParametersParser.parse(testLine), is(expected));
    }

}