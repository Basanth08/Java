package unit01;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;

import org.junit.jupiter.api.Test;

import unit01.SieveValidator;

public class SieveValidatorTest {
    @Test
    public void testrepairseive(){
        int [] seive = {0, 1, 1, 0, 1, 0, 1, 1};
        int errors = SieveValidator.repairseive(seive);
        assertEquals(2,errors);
        assertEquals(1,seive[1]);
        assertEquals(0,seive[2]);
    }
    public void testemptyrepairseive(){
        int [] seive = {};
        int errors = SieveValidator.repairseive(seive);
        // assertEquals(2,errors);
        // assertEquals(1,seive[1]);
        assertEquals(0,errors);
    }
}
