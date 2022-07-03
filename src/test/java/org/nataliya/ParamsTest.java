package org.nataliya;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ParamsTest {

    @ValueSource(strings = {"Marc Jacobs очки", "mango очки"})
    @ParameterizedTest (name = "При поиске на сайте Lamoda по запросу {0} в результатах отображаются\n" +
            "товары бренда {0}")
    void lamodaTestCommon(String testData) {
        Selenide.open("https://www.lamoda.ru");
        $("#vue-root > header > div._3OaZdss3f-oo3UXtT_F9WA > div > div > div > div > input")
                .setValue(testData);
        $("button[type='button']").click();
        $$(".x-product-card-description").find(text(testData)).shouldBe(visible);

    }

    @CsvSource(value = {
            "Marc Jacobs очки, оправа",
            "mango очки, очки солнцезащитные"
    })
    @ParameterizedTest (name = "При поиске на сайте Lamoda по запросу {0} в результатах отображаются\n" +
            "товары бренда {1}")
        void lamodaTestComplex(String searchData, String expectedResult) {
            Selenide.open("https://www.lamoda.ru");
            $("#vue-root > header > div._3OaZdss3f-oo3UXtT_F9WA > div > div > div > div > input")
                    .setValue(searchData);
            $("button[type='button']").click();
            $$(".x-product-card-description").find(text(expectedResult)).shouldBe(visible);

    }

    @EnumSource(Gender.class)
    @ParameterizedTest
    void enumTest(Gender gender) {
        Selenide.open("https://www.lamoda.ru");
        $("#vue-root > header > div._3OaZdss3f-oo3UXtT_F9WA > div > div > div > div > input")
                .setValue(gender.desc);
        $("button[type='button']").click();
        $$(".x-product-card-description").find(text(gender.desc)).shouldBe(visible);
    }
}
