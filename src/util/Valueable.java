package util;

import token.Operator.OperatorType;
import token.Reserved.ReservedType;

public interface Valueable {
    double getDoubleValue();
    Boolean getBooleanValue();
    String getStringValue();
    OperatorType getOperatorValue();
    ReservedType getReservedValue();
}
