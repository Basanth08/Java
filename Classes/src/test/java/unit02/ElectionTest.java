package unit02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import unit02.Election.*;
import unit02.Election.Politicalparty;
import unit02.Election.position;

public class ElectionTest {
    @Test
    public void testGetposition(){
        // setup
        Politicalparty[] party = {Politicalparty.REPUBLICIAN};
        Politicalparty[] expected = party;
        // invoke
        Election one = new Election("Modi", position.ASSEMBLY_MEMBER, party);
        position actual = one.getposition();
        // analyze
        assertEquals(expected, actual);
    }
}
