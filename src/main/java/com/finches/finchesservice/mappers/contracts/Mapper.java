package com.finches.finchesservice.mappers.contracts;

public interface Mapper<A, B> {
    B mapFromAToB(A object1);

    A mapFromBToA(B object1);
}
