import com.epam.planes.ExperimentalPlane;
import com.epam.models.ClassificationLevel;
import com.epam.models.ExperimentalTypes;
import com.epam.models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.epam.planes.MilitaryPlane;
import com.epam.planes.PassengerPlane;
import com.epam.planes.Plane;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AirportTest {
    private final static List<Plane> PLANES = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private final static PassengerPlane PLANE_WITH_MAX_PASSENGER_CAPACITY = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);
    private final static Airport AIRPORT = new Airport(PLANES);

    @Test
    public void testGetTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = AIRPORT.getTransportMilitaryPlanes();
        int amountOfTransportMilitaryPlanes = Collections.frequency(PLANES, new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT));
        System.out.println(transportMilitaryPlanes.size());
        System.out.println(amountOfTransportMilitaryPlanes);
        Assert.assertEquals(transportMilitaryPlanes.size(), amountOfTransportMilitaryPlanes);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = AIRPORT.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(PLANE_WITH_MAX_PASSENGER_CAPACITY, expectedPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void testSortedByMaxLoadCapacity() {
        AIRPORT.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = AIRPORT.getPlanes();
        int currentMax = planesSortedByMaxLoadCapacity.get(0).getMAX_LOAD_CAPACITY();
        for (Plane plane : planesSortedByMaxLoadCapacity) {
            Assert.assertTrue(currentMax <= plane.getMAX_LOAD_CAPACITY());
            currentMax = plane.getMAX_LOAD_CAPACITY();
        }
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() { //TODO править как и остальные
        List<MilitaryPlane> bomberMilitaryPlanes = AIRPORT.getBomberMilitaryPlanes();
        List<MilitaryPlane> expected  =
                bomberMilitaryPlanes.stream()
                        .filter(militaryPlane -> militaryPlane.getType().equals(MilitaryType.BOMBER))
                        .collect(Collectors.toList());
        Assert.assertEquals(expected, bomberMilitaryPlanes);
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        List<ExperimentalPlane> experimentalPlanes = AIRPORT.getExperimentalPlanes();
        for (ExperimentalPlane experimentalPlane : experimentalPlanes) {
            Assert.assertNotSame(experimentalPlane.getClassificationLevel(), ClassificationLevel.UNCLASSIFIED);
        }
    }
}
