package com.epam.planes;

import com.epam.models.ClassificationLevel;
import com.epam.models.ExperimentalTypes;

import java.util.Objects;

public class ExperimentalPlane extends Plane {

    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperimentalPlane)) return false;
        if (!super.equals(o)) return false;
        ExperimentalPlane that = (ExperimentalPlane) o;
        return getClassificationLevel() == that.getClassificationLevel();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getClassificationLevel());
    }

    @Override
    public String toString() {
        return "experimentalPlane model: " + MODEL;
    }
}
