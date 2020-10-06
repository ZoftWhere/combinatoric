package app.zoftwhere.combinatoric;

import java.util.Objects;

import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestHelper {

    public static <T> void assertClass(Class<T> expected, Object object) {
        assertNotNull(expected);
        assertNotNull(object);
        var actual = object.getClass();

        if (Objects.equals(expected.getName(), actual.getName())) {
            return;
        }

        throw new AssertionFailedError("Object not of the expected type.", expected, actual);
    }

}
