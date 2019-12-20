package com.obit.json2jsonpath;

import static org.assertj.core.api.Assertions.assertThat;

import com.obit.json2jsonpath.component.JsonPathGenerator;
import java.util.List;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class JsonPathGeneratorTest {

    @Test
    void testJsonBasic() {
        final JSONObject source = new JSONObject(""
                + "{\n"
                + "\t\"name\": \"Ondrej\",\n"
                + "\t\"age\": 30\n"
                + "}\n");

        final List<String> target = JsonPathGenerator.from(source).generate();

        assertThat(target).hasSize(2);
        assertThat(target.get(0)).isEqualTo("$.name=Ondrej");
        assertThat(target.get(1)).isEqualTo("$.age=30");
    }

    @Test
    void testJsonWithComplexElement() {
        final JSONObject source = new JSONObject(""
                + "{\n"
                + "\t\"name\": \"Ondrej\",\n"
                + "\t\"age\": 30,\n"
                + "\t\"complexElement\": {\n"
                + "\t\t\"encodedKey\": \"key\",\n"
                + "\t\t\"name\": \"Reminder Letter fee\",\n"
                + "\t\t\"amount\": 3.5\n"
                + "\t}\n"
                + "}");

        final List<String> target = JsonPathGenerator.from(source).generate();

        assertThat(target).hasSize(5);
        assertThat(target.get(0)).isEqualTo("$.complexElement.amount=3.5");
        assertThat(target.get(1)).isEqualTo("$.complexElement.name=Reminder Letter fee");
        assertThat(target.get(2)).isEqualTo("$.complexElement.encodedKey=key");
        assertThat(target.get(3)).isEqualTo("$.name=Ondrej");
        assertThat(target.get(4)).isEqualTo("$.age=30");
    }

    @Test
    void testJsonWithTwoComplexElements() {
        final JSONObject source = new JSONObject(""
                + "{\n"
                + "\t\"name\": \"Ondrej\",\n"
                + "\t\"age\": 30,\n"
                + "\t\"complex1\": {\n"
                + "\t\t\"encodedKey\": \"key\",\n"
                + "\t\t\"amount\": 3.5\n"
                + "\t},\n"
                + "\t\"complex2\": {\n"
                + "\t\t\"complexName\": \"complexName\"\n"
                + "\t}\n"
                + "}");

        final List<String> target = JsonPathGenerator.from(source).generate();

        assertThat(target).hasSize(5);
        assertThat(target.get(0)).isEqualTo("$.complex1.amount=3.5");
        assertThat(target.get(1)).isEqualTo("$.complex1.encodedKey=key");
        assertThat(target.get(2)).isEqualTo("$.complex2.complexName=complexName");
        assertThat(target.get(3)).isEqualTo("$.name=Ondrej");
        assertThat(target.get(4)).isEqualTo("$.age=30");
    }

    @Test
    public void testJsonWithSimpleArray() {
        final JSONObject source = new JSONObject("{\n"
                + "\t\"glossary\": {\n"
                + "\t\t\"title\": \"example glossary\",\n"
                + "\t\t\"GlossDiv\": {\n"
                + "\t\t\t\"title\": \"S\",\n"
                + "\t\t\t\"GlossList\": {\n"
                + "\t\t\t\t\"GlossEntry\": {\n"
                + "\t\t\t\t\t\"ID\": \"SGML\",\n"
                + "\t\t\t\t\t\"GlossDef\": {\n"
                + "\t\t\t\t\t\t\"para\": \"A meta-markup\",\n"
                + "\t\t\t\t\t\t\"GlossSeeAlso\": [\n"
                + "\t\t\t\t\t\t\t\"GML\",\n"
                + "\t\t\t\t\t\t\t\"XML\"\n"
                + "\t\t\t\t\t\t]\n"
                + "\t\t\t\t\t},\n"
                + "\t\t\t\t\t\"GlossSee\": \"markup\"\n"
                + "\t\t\t\t}\n"
                + "\t\t\t}\n"
                + "\t\t}\n"
                + "\t}\n"
                + "}");

        final List<String> target = JsonPathGenerator.from(source).generate();

        assertThat(target).hasSize(6);
        assertThat(target.get(0)).isEqualTo("$.glossary.title=example glossary");
        assertThat(target.get(1)).isEqualTo("$.glossary.GlossDiv.GlossList.GlossEntry.GlossSee=markup");
        assertThat(target.get(2)).isEqualTo("$.glossary.GlossDiv.GlossList.GlossEntry.GlossDef.para=A meta-markup");
        assertThat(target.get(3)).isEqualTo("$.glossary.GlossDiv.GlossList.GlossEntry.GlossDef.GlossSeeAlso=[\"GML\",\"XML\"]");
        assertThat(target.get(4)).isEqualTo("$.glossary.GlossDiv.GlossList.GlossEntry.ID=SGML");
        assertThat(target.get(5)).isEqualTo("$.glossary.GlossDiv.title=S");
    }

    @Test
    public void testJsonWithComplexArray() {
        final JSONObject source = new JSONObject("{\n"
                + "\t\"menu\": {\n"
                + "\t\t\"id\": \"file\",\n"
                + "\t\t\"value\": \"File\",\n"
                + "\t\t\"popup\": {\n"
                + "\t\t\t\"menuitem\": [\n"
                + "\t\t\t\t{\n"
                + "\t\t\t\t\t\"value\": \"New\",\n"
                + "\t\t\t\t\t\"onclick\": \"CreateNewDoc()\"\n"
                + "\t\t\t\t},\n"
                + "\t\t\t\t{\n"
                + "\t\t\t\t\t\"value\": \"Open\",\n"
                + "\t\t\t\t\t\"onclick\": \"OpenDoc()\"\n"
                + "\t\t\t\t},\n"
                + "\t\t\t\t{\n"
                + "\t\t\t\t\t\"value\": \"Close\",\n"
                + "\t\t\t\t\t\"onclick\": \"CloseDoc()\"\n"
                + "\t\t\t\t}\n"
                + "\t\t\t]\n"
                + "\t\t}\n"
                + "\t}\n"
                + "}");

        final List<String> target = JsonPathGenerator.from(source).generate();

        assertThat(target).hasSize(8);
        assertThat(target.get(0)).isEqualTo("$.menu.popup.menuitem[0].onclick=CreateNewDoc()");
        assertThat(target.get(1)).isEqualTo("$.menu.popup.menuitem[0].value=New");
        assertThat(target.get(2)).isEqualTo("$.menu.popup.menuitem[1].onclick=OpenDoc()");
        assertThat(target.get(3)).isEqualTo("$.menu.popup.menuitem[1].value=Open");
        assertThat(target.get(4)).isEqualTo("$.menu.popup.menuitem[2].onclick=CloseDoc()");
        assertThat(target.get(5)).isEqualTo("$.menu.popup.menuitem[2].value=Close");
        assertThat(target.get(6)).isEqualTo("$.menu.id=file");
        assertThat(target.get(7)).isEqualTo("$.menu.value=File");
    }

    @Test
    public void testJsonComplex() {
        final List<String> target = JsonPathGenerator.from(getComplexJsonObject()).generate();

        assertThat(target.get(0)).isEqualTo("$.menu.simpleArray=[\"ABC\",\"DEF\",\"GHI\"]");
        assertThat(target.get(1)).isEqualTo("$.menu.popup.menuitem[0].onclick=CreateNewDoc()");
        assertThat(target.get(2)).isEqualTo("$.menu.popup.menuitem[0].value[0].name=onulo");
        assertThat(target.get(3)).isEqualTo("$.menu.popup.menuitem[0].value[0].id=5");
        assertThat(target.get(4)).isEqualTo("$.menu.popup.menuitem[0].value[1].name=peto");
        assertThat(target.get(5)).isEqualTo("$.menu.popup.menuitem[0].value[1].id=5");
        assertThat(target.get(6)).isEqualTo("$.menu.popup.menuitem[1].onclick=OpenDoc()");
        assertThat(target.get(7)).isEqualTo("$.menu.popup.menuitem[1].value[0].name=onulo");
        assertThat(target.get(8)).isEqualTo("$.menu.popup.menuitem[1].value[0].id=5");
        assertThat(target.get(9)).isEqualTo("$.menu.popup.menuitem[1].value[1].name=peto");
        assertThat(target.get(10)).isEqualTo("$.menu.popup.menuitem[1].value[1].id=5");
        assertThat(target.get(11)).isEqualTo("$.menu.popup.menuitem[2].onclick=CloseDoc()");
        assertThat(target.get(12)).isEqualTo("$.menu.popup.menuitem[2].value[0].name=onulo");
        assertThat(target.get(13)).isEqualTo("$.menu.popup.menuitem[2].value[0].id=5");
        assertThat(target.get(14)).isEqualTo("$.menu.popup.menuitem[2].value[1].name=peto");
        assertThat(target.get(15)).isEqualTo("$.menu.popup.menuitem[2].value[1].id=5");
        assertThat(target.get(16)).isEqualTo("$.menu.id=file");
        assertThat(target.get(17)).isEqualTo("$.menu.value=File");
    }

    private JSONObject getComplexJsonObject() {
        return new JSONObject("{\n" +
                "  \"menu\": {\n" +
                "    \"id\": \"file\",\n" +
                "    \"value\": \"File\",\n" +
                "    \"simpleArray\": [\n" +
                "      \"ABC\",\n" +
                "      \"DEF\",\n" +
                "      \"GHI\"\n" +
                "    ],\n" +
                "    \"popup\": {\n" +
                "      \"menuitem\": [\n" +
                "        {\n" +
                "          \"value\": [\n" +
                "            {\n" +
                "              \"id\": 5,\n" +
                "              \"name\": \"onulo\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": 5,\n" +
                "              \"name\": \"peto\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"onclick\": \"CreateNewDoc()\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"value\": [\n" +
                "            {\n" +
                "              \"id\": 5,\n" +
                "              \"name\": \"onulo\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": 5,\n" +
                "              \"name\": \"peto\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"onclick\": \"OpenDoc()\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"value\": [\n" +
                "            {\n" +
                "              \"id\": 5,\n" +
                "              \"name\": \"onulo\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": 5,\n" +
                "              \"name\": \"peto\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"onclick\": \"CloseDoc()\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}");
    }
}