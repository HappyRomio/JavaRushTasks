package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property="className")
@JsonSubTypes({
        @JsonSubTypes.Type(value=Car.class, name="car"),
        @JsonSubTypes.Type(value=ParkingLot.class, name="parkingLot")
})
public abstract class Vehicle {
    protected String name;
    protected String owner;
    protected int age;
}