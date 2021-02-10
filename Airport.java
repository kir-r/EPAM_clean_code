import com.epam.planes.ExperimentalPlane;
import com.epam.models.MilitaryType;
import com.epam.planes.MilitaryPlane;
import com.epam.planes.PassengerPlane;
import com.epam.planes.Plane;

import java.util.*;

public class Airport {
    private List<? extends Plane> planes;

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanesList = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlanesList.add((PassengerPlane) plane);
            }
        }
        return passengerPlanesList;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane plane : passengerPlanes) {
            if (plane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = plane;
            }
        }
        return planeWithMaxCapacity;
    }

    private List <MilitaryPlane> getMilitaryPlanesByType(MilitaryType type) {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getType() == type) {
                transportMilitaryPlanes.add(plane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getMilitaryPlanesByType(MilitaryType.TRANSPORT);
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getMilitaryPlanesByType(MilitaryType.BOMBER);
    }

    public Airport sortByMaxDistance() {
        planes.sort((Comparator<Plane>)(firstPlane, secondPlane) -> firstPlane.getMAX_FLIGHT_DISTANCE() - secondPlane.getMAX_FLIGHT_DISTANCE());
        return this;
    }

    public Airport sortByMaxSpeed() {
        planes.sort((Comparator<Plane>)(firstPlane, secondPlane) -> firstPlane.getMAX_SPEED() - secondPlane.getMAX_SPEED());
        return this;
    }

    public void sortByMaxLoadCapacity() {
        planes.sort((Comparator<Plane>)(firstPlane, secondPlane) -> firstPlane.getMAX_LOAD_CAPACITY() - secondPlane.getMAX_LOAD_CAPACITY());
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    @Override
    public String toString() {
        return "Airport Planes: " + planes.toString();
    }

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }
}
