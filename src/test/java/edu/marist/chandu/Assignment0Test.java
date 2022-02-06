package edu.marist.chandu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.marist.chandu.App;
import edu.marist.chandu.CONSTANTS;
import edu.marist.chandu.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Unit test for hello world App template.
 */
class Assignment0Test {
    

    StringBuilder input0DataBuilder = new StringBuilder();
    String input0Data = input0DataBuilder.append("Albany\n")
    .append("Amsterdam\n")
    .append("Auburn\n")
    .append("Babylon\n")
    .append("Batavia\n")
    .append("Beacon\n")
    .append("Bedford\n")
    .append("Binghamton\n")
    .append("Bronx\n")
    .append("Brooklyn\n")
    .append("Buffalo\n")
    .append("Chautauqua\n")
    .append("Cheektowaga\n")
    .append("Clinton\n")
    .append("Cohoes\n")
    .append("Coney Island\n")
    .append("Cooperstown\n")
    .append("Corning\n")
    .append("Cortland\n")
    .append("Crown Point\n")
    .append("Dunkirk\n")
    .append("East Aurora\n")
    .append("East Hampton\n")
    .append("Eastchester\n")
    .append("Elmira\n")
    .append("Flushing\n")
    .append("Forest Hills\n")
    .append("Fredonia\n")
    .append("Garden City\n")
    .append("Geneva\n")
    .append("Glens Falls\n")
    .append("Gloversville\n")
    .append("Great Neck\n")
    .append("Hammondsport\n")
    .append("Harlem\n")
    .append("Hempstead\n")
    .append("Herkimer\n")
    .append("Hudson\n")
    .append("Huntington\n")
    .append("Hyde Park\n")
    .append("Ilion\n")
    .append("Ithaca\n")
    .append("Jamestown\n")
    .append("Johnstown\n")
    .append("Kingston\n")
    .append("Lackawanna\n")
    .append("Lake Placid\n")
    .append("Levittown\n")
    .append("Lockport\n")
    .append("Mamaroneck\n")
    .append("Manhattan\n")
    .append("Massena\n")
    .append("Middletown\n")
    .append("Mineola\n")
    .append("Mount Vernon\n")
    .append("New Paltz\n")
    .append("New Rochelle\n")
    .append("New Windsor\n")
    .append("New York City\n")
    .append("Newburgh\n")
    .append("Niagara Falls\n")
    .append("North Hempstead\n")
    .append("Nyack\n")
    .append("Ogdensburg\n")
    .append("Olean\n")
    .append("Oneida\n")
    .append("Oneonta\n")
    .append("Ossining\n")
    .append("Oswego\n")
    .append("Oyster Bay\n")
    .append("Palmyra\n")
    .append("Peekskill\n")
    .append("Plattsburgh\n")
    .append("Port Washington\n")
    .append("Potsdam\n")
    .append("Poughkeepsie\n")
    .append("Queens\n")
    .append("Rensselaer\n")
    .append("Rochester\n")
    .append("Rome\n")
    .append("Rotterdam\n")
    .append("Rye\n")
    .append("Sag Harbor\n")
    .append("Saranac Lake\n")
    .append("Saratoga Springs\n")
    .append("Scarsdale\n")
    .append("Schenectady\n")
    .append("Seneca Falls\n")
    .append("Southampton\n")
    .append("Staten Island\n")
    .append("Stony Brook\n")
    .append("Stony Point\n")
    .append("Syracuse\n")
    .append("Tarrytown\n")
    .append("Ticonderoga\n")
    .append("Tonawanda\n")
    .append("Troy\n")
    .append("Utica\n")
    .append("Watertown\n")
    .append("Watervliet\n")
    .append("Watkins Glen\n")
    .append("West Seneca\n")
    .append("White Plains\n")
    .append("Woodstock\n")
    .append("Yonkers\n")
    .toString();

    /**
     * Version Test.
     */
    @Test
    void testAppVersion() {
        assertEquals(CONSTANTS.getVersion(), "0.5.0");
    }

    /**
     * appName Test.
     */
    @Test
    void testAppName() {
        assertNotEquals(CONSTANTS.getAppName(), "helloworld");
    }

    /**
     * readFile Test.
     */
    @Test
    void testReadFile() {
        Utils utils = new Utils();
        assertEquals(input0Data, utils.readFile("data/input0.txt"));
    }

    /**
     * everyOtherLine Test.
     */
    @Test
    void testEveryOtherLine() {
        App app = new App();
        assertEquals("Mike was here!\n", app.everyOtherLine("Mike was here!"));
        StringBuilder input0DataBuilder = new StringBuilder();
        String input0Data = input0DataBuilder.append("Albany\n")
                                             .append("Amsterdam\n")
                                             .append("Auburn\n")
                                             .toString();
        assertEquals("Albany\nAuburn\n", app.everyOtherLine(input0Data));
    }
}
