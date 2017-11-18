package util;

import token.Operator.OperatorType;
import token.Reserved.ReservedType;

public interface Valueable {
    double getDoubleValue();
    String getStringValue();
    OperatorType getOperatorType();
    ReservedType getReservedType();
}
