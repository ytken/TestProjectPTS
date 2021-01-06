import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {
    private Integer sum(List<Integer> list) {
        if (list == null)
            return null;
        Integer s = 0;
        for (Integer i : list)
            s += i;
        return s;
    }

    @org.junit.Test
    public void TestResult() throws IOException {
        Main.main(null);
        assertEquals(sum(Main.result.get("mark01")), 1550);
        assertEquals(sum(Main.result.get("mark17")), 72);
        assertEquals(sum(Main.result.get("mark23")),null);
        assertEquals(sum(Main.result.get("mark35")),1436);
        assertEquals(sum(Main.result.get("markfv")),105);
        assertEquals(sum(Main.result.get("markfx")),null);
        assertEquals(sum(Main.result.get("markft")),508);
    }
}
