import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceTest {
    private static GeoService sut;

    @BeforeAll
    public static void beforeAll() {
        sut = new GeoServiceImpl();
    }

    @Test
    public void getRussiaLocationTest() {
        Location location = sut.byIp(GeoServiceImpl.MOSCOW_IP);
        Assertions.assertEquals("Moscow", location.getCity());
        Assertions.assertEquals(Country.RUSSIA, location.getCountry());
        Assertions.assertEquals("Lenina", location.getStreet());
        Assertions.assertEquals(15, location.getBuiling());
    }

    @Test
    public void getUsaLocationTest() {
        Location location = sut.byIp(GeoServiceImpl.NEW_YORK_IP);
        Assertions.assertEquals("New York", location.getCity());
        Assertions.assertEquals(Country.USA, location.getCountry());
        Assertions.assertEquals("10th Avenue", location.getStreet());
        Assertions.assertEquals(32, location.getBuiling());
    }

    @Test
    public void getLocalHostLocationTest() {
        Location location = sut.byIp(GeoServiceImpl.LOCALHOST);
        Assertions.assertNull(location.getCity());
        Assertions.assertNull(location.getCountry());
        Assertions.assertNull(location.getStreet());
        Assertions.assertEquals(0, location.getBuiling());
    }
}
