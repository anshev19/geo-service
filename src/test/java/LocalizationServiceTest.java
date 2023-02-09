import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.valueOf;

public class LocalizationServiceTest {
    @ParameterizedTest
    @ValueSource(strings = {"USA", "GERMANY", "BRAZIL"})
    public void UsaWelcomeTest(String country) {
        LocalizationService sut = new LocalizationServiceImpl();
        String result = sut.locale(valueOf(Country.class, country));
        Assertions.assertEquals("Welcome", result);
    }

    @Test
    public void RussiaWelcomeTest() {
        LocalizationService sut = new LocalizationServiceImpl();
        String result = sut.locale(RUSSIA);
        Assertions.assertEquals("Добро пожаловать", result);
    }
}
