package com.finches.finchesservice.mappers;

public interface Mapper<A, B> {
    B mapFromAToB(A object1);

    A mapFromBToA(B object1);
}
