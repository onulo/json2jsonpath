package com.obit.json2jsonpath;

import com.obit.json2jsonpath.services.Json2JsonPathGenerator;
import org.json.JSONObject;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Json2JsonPathGeneratorTest {

    @Test
    public void test() {
        Json2JsonPathGenerator json2JsonPathGenerator = new Json2JsonPathGenerator();

        List<String> output = json2JsonPathGenerator.generate(getJsonObject());

        assertEquals("$.menu.simpleArray=[\"ABC\",\"DEF\",\"GHI\"]", output.get(0));
        assertEquals("$.menu.popup.menuitem[0].onclick=CreateNewDoc()", output.get(1));
        assertEquals("$.menu.popup.menuitem[0].value[0].name=onulo", output.get(2));
        assertEquals("$.menu.popup.menuitem[0].value[0].id=5", output.get(3));
        assertEquals("$.menu.popup.menuitem[0].value[1].name=peto", output.get(4));
        assertEquals("$.menu.popup.menuitem[0].value[1].id=5", output.get(5));
        assertEquals("$.menu.popup.menuitem[1].onclick=OpenDoc()", output.get(6));
        assertEquals("$.menu.popup.menuitem[1].value[0].name=onulo", output.get(7));
        assertEquals("$.menu.popup.menuitem[1].value[0].id=5", output.get(8));
        assertEquals("$.menu.popup.menuitem[1].value[1].name=peto", output.get(9));
        assertEquals("$.menu.popup.menuitem[1].value[1].id=5", output.get(10));
        assertEquals("$.menu.popup.menuitem[2].onclick=CloseDoc()", output.get(11));
        assertEquals("$.menu.popup.menuitem[2].value[0].name=onulo", output.get(12));
        assertEquals("$.menu.popup.menuitem[2].value[0].id=5", output.get(13));
        assertEquals("$.menu.popup.menuitem[2].value[1].name=peto", output.get(14));
        assertEquals("$.menu.popup.menuitem[2].value[1].id=5", output.get(14));
        assertEquals("$.menu.id=file", output.get(16));
        assertEquals("$.menu.value=File", output.get(17));

    }

    @Test
    public void test2() {
        Json2JsonPathGenerator json2JsonPathGenerator = new Json2JsonPathGenerator();

        List<String> output = json2JsonPathGenerator.generate(getJsonExample2());
    }

    private JSONObject getJsonObject() {
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

    public JSONObject getJsonExample2(){
        return new JSONObject("{\n" +
                "  \"root\": [\n" +
                "    {\n" +
                "      \"_id\": \"5c670d34c54b8aa377861070\",\n" +
                "      \"index\": 0,\n" +
                "      \"guid\": \"76ba5707-95d6-407d-83ef-7a7f43f917d4\",\n" +
                "      \"isActive\": true,\n" +
                "      \"balance\": \"$1,681.63\",\n" +
                "      \"picture\": \"http://placehold.it/32x32\",\n" +
                "      \"age\": 24,\n" +
                "      \"eyeColor\": \"green\",\n" +
                "      \"name\": \"Edwards Miller\",\n" +
                "      \"gender\": \"male\",\n" +
                "      \"company\": \"NIPAZ\",\n" +
                "      \"email\": \"edwardsmiller@nipaz.com\",\n" +
                "      \"phone\": \"+1 (989) 510-2332\",\n" +
                "      \"address\": \"341 Times Placez, Unionville, Ohio, 1818\",\n" +
                "      \"about\": \"Do enim laborum reprehenderit dolore incididunt proident. Sit nostrud sint quis incididunt deserunt nostrud mollit magna. Do nisi consectetur occaecat dolor exercitation aliquip aliqua incididunt aliquip ut magna.\\r\\n\",\n" +
                "      \"registered\": \"2014-01-30T04:16:29 -01:00\",\n" +
                "      \"latitude\": 86.215325,\n" +
                "      \"longitude\": 37.951514,\n" +
                "      \"tags\": [\n" +
                "        \"dolor\",\n" +
                "        \"elit\",\n" +
                "        \"sit\",\n" +
                "        \"sit\",\n" +
                "        \"officia\",\n" +
                "        \"aliquip\",\n" +
                "        \"anim\"\n" +
                "      ],\n" +
                "      \"friends\": [\n" +
                "        {\n" +
                "          \"id\": 0,\n" +
                "          \"name\": \"Ruthie Banks\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"name\": \"Joan Gregory\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2,\n" +
                "          \"name\": \"Shelley Branch\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"greeting\": \"Hello, Edwards Miller! You have 8 unread messages.\",\n" +
                "      \"favoriteFruit\": \"strawberry\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"_id\": \"5c670d34cde16f3e65ac4d17\",\n" +
                "      \"index\": 1,\n" +
                "      \"guid\": \"034e96b4-733f-4cd2-965c-25dca95d564d\",\n" +
                "      \"isActive\": true,\n" +
                "      \"balance\": \"$1,318.03\",\n" +
                "      \"picture\": \"http://placehold.it/32x32\",\n" +
                "      \"age\": 27,\n" +
                "      \"eyeColor\": \"green\",\n" +
                "      \"name\": \"Briggs Velez\",\n" +
                "      \"gender\": \"male\",\n" +
                "      \"company\": \"FUTURIZE\",\n" +
                "      \"email\": \"briggsvelez@futurize.com\",\n" +
                "      \"phone\": \"+1 (931) 518-3282\",\n" +
                "      \"address\": \"233 Banner Avenue, Fostoria, Kentucky, 4696\",\n" +
                "      \"about\": \"Laborum ea aliqua enim ex veniam non elit laborum ea. Mollit ipsum anim irure magna ex duis nulla amet consequat. Dolore laborum cillum veniam in tempor incididunt dolor. Culpa nostrud pariatur cupidatat est nulla laborum excepteur proident aliqua reprehenderit id esse pariatur. Pariatur officia quis quis officia sit. Laboris et cupidatat irure officia reprehenderit voluptate consectetur aute labore id pariatur tempor ex adipisicing. Cillum incididunt labore culpa nostrud.\\r\\n\",\n" +
                "      \"registered\": \"2018-11-10T06:09:29 -01:00\",\n" +
                "      \"latitude\": 38.84154,\n" +
                "      \"longitude\": 62.265998,\n" +
                "      \"tags\": [\n" +
                "        \"ut\",\n" +
                "        \"et\",\n" +
                "        \"dolore\",\n" +
                "        \"quis\",\n" +
                "        \"nulla\",\n" +
                "        \"exercitation\",\n" +
                "        \"Lorem\"\n" +
                "      ],\n" +
                "      \"friends\": [\n" +
                "        {\n" +
                "          \"id\": 0,\n" +
                "          \"name\": \"Gina Allison\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"name\": \"Luann Foreman\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2,\n" +
                "          \"name\": \"Simpson Edwards\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"greeting\": \"Hello, Briggs Velez! You have 7 unread messages.\",\n" +
                "      \"favoriteFruit\": \"apple\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"_id\": \"5c670d34b071b65d144476f6\",\n" +
                "      \"index\": 2,\n" +
                "      \"guid\": \"761353c0-b35e-4493-8527-315f1daea82a\",\n" +
                "      \"isActive\": true,\n" +
                "      \"balance\": \"$3,990.33\",\n" +
                "      \"picture\": \"http://placehold.it/32x32\",\n" +
                "      \"age\": 23,\n" +
                "      \"eyeColor\": \"green\",\n" +
                "      \"name\": \"Nguyen Gibbs\",\n" +
                "      \"gender\": \"male\",\n" +
                "      \"company\": \"MAGNEMO\",\n" +
                "      \"email\": \"nguyengibbs@magnemo.com\",\n" +
                "      \"phone\": \"+1 (950) 550-2919\",\n" +
                "      \"address\": \"250 Bond Street, Hailesboro, Connecticut, 9365\",\n" +
                "      \"about\": \"Anim aute quis amet voluptate ex enim consectetur occaecat non culpa minim laborum cupidatat. Voluptate id dolore et deserunt Lorem deserunt anim amet voluptate aute anim laboris enim consequat. Mollit commodo in aliqua consectetur ad.\\r\\n\",\n" +
                "      \"registered\": \"2016-01-28T05:48:14 -01:00\",\n" +
                "      \"latitude\": -32.297054,\n" +
                "      \"longitude\": -80.58663,\n" +
                "      \"tags\": [\n" +
                "        \"esse\",\n" +
                "        \"amet\",\n" +
                "        \"aute\",\n" +
                "        \"ea\",\n" +
                "        \"velit\",\n" +
                "        \"officia\",\n" +
                "        \"dolor\"\n" +
                "      ],\n" +
                "      \"friends\": [\n" +
                "        {\n" +
                "          \"id\": 0,\n" +
                "          \"name\": \"Julia Rodriquez\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"name\": \"Cannon Sherman\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2,\n" +
                "          \"name\": \"Natalia Knapp\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"greeting\": \"Hello, Nguyen Gibbs! You have 5 unread messages.\",\n" +
                "      \"favoriteFruit\": \"strawberry\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"_id\": \"5c670d345aa052574e9ff0a3\",\n" +
                "      \"index\": 3,\n" +
                "      \"guid\": \"7cf6f333-d965-4b9a-a3b5-0bfd2b4d4c45\",\n" +
                "      \"isActive\": true,\n" +
                "      \"balance\": \"$3,514.21\",\n" +
                "      \"picture\": \"http://placehold.it/32x32\",\n" +
                "      \"age\": 26,\n" +
                "      \"eyeColor\": \"green\",\n" +
                "      \"name\": \"Carmella Nixon\",\n" +
                "      \"gender\": \"female\",\n" +
                "      \"company\": \"IMAGEFLOW\",\n" +
                "      \"email\": \"carmellanixon@imageflow.com\",\n" +
                "      \"phone\": \"+1 (807) 425-2470\",\n" +
                "      \"address\": \"157 Lincoln Road, Dante, New Hampshire, 9769\",\n" +
                "      \"about\": \"In aliquip sunt commodo ipsum esse aute. Consequat sunt proident aliquip esse nulla dolor adipisicing ad enim ad ut velit qui. Aute magna aliqua magna dolore ea commodo incididunt id quis esse.\\r\\n\",\n" +
                "      \"registered\": \"2017-04-01T03:18:48 -02:00\",\n" +
                "      \"latitude\": 54.512984,\n" +
                "      \"longitude\": -117.328352,\n" +
                "      \"tags\": [\n" +
                "        \"ea\",\n" +
                "        \"eu\",\n" +
                "        \"pariatur\",\n" +
                "        \"Lorem\",\n" +
                "        \"ullamco\",\n" +
                "        \"anim\",\n" +
                "        \"exercitation\"\n" +
                "      ],\n" +
                "      \"friends\": [\n" +
                "        {\n" +
                "          \"id\": 0,\n" +
                "          \"name\": \"Ester Morrison\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"name\": \"Deleon Small\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2,\n" +
                "          \"name\": \"Briana Haley\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"greeting\": \"Hello, Carmella Nixon! You have 4 unread messages.\",\n" +
                "      \"favoriteFruit\": \"banana\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"_id\": \"5c670d34563a9a6bd1b816b7\",\n" +
                "      \"index\": 4,\n" +
                "      \"guid\": \"f6955c23-791c-4e41-93e6-d232a8c5254e\",\n" +
                "      \"isActive\": false,\n" +
                "      \"balance\": \"$3,176.25\",\n" +
                "      \"picture\": \"http://placehold.it/32x32\",\n" +
                "      \"age\": 38,\n" +
                "      \"eyeColor\": \"green\",\n" +
                "      \"name\": \"Eugenia Bradshaw\",\n" +
                "      \"gender\": \"female\",\n" +
                "      \"company\": \"HINWAY\",\n" +
                "      \"email\": \"eugeniabradshaw@hinway.com\",\n" +
                "      \"phone\": \"+1 (971) 520-3632\",\n" +
                "      \"address\": \"189 Monument Walk, Galesville, Alaska, 7574\",\n" +
                "      \"about\": \"Ex ut velit nisi Lorem amet adipisicing reprehenderit pariatur est tempor. Proident eu exercitation irure anim sunt et nulla. Aliquip reprehenderit fugiat tempor duis dolore sit nisi. Veniam ad id aliquip magna aliquip adipisicing eu cillum consectetur fugiat quis officia Lorem. Esse dolor officia sit Lorem adipisicing ad minim commodo voluptate sunt sit cillum eiusmod ea. Ut est id sint anim. Adipisicing adipisicing aute commodo amet elit cupidatat consequat quis.\\r\\n\",\n" +
                "      \"registered\": \"2014-04-21T05:25:15 -02:00\",\n" +
                "      \"latitude\": -50.599362,\n" +
                "      \"longitude\": 4.874998,\n" +
                "      \"tags\": [\n" +
                "        \"aliqua\",\n" +
                "        \"veniam\",\n" +
                "        \"duis\",\n" +
                "        \"consectetur\",\n" +
                "        \"reprehenderit\",\n" +
                "        \"culpa\",\n" +
                "        \"in\"\n" +
                "      ],\n" +
                "      \"friends\": [\n" +
                "        {\n" +
                "          \"id\": 0,\n" +
                "          \"name\": \"Camacho Hutchinson\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"name\": \"Huff Calhoun\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2,\n" +
                "          \"name\": \"Sophia Patton\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"greeting\": \"Hello, Eugenia Bradshaw! You have 8 unread messages.\",\n" +
                "      \"favoriteFruit\": \"strawberry\"\n" +
                "    }\n" +
                "  ]\n" +
                "}");
    }

}
