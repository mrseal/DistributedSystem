package com.cf.study.distribute.system.bean;

public class Value {

    String formula;
    double value;

    Value(final double value) {
        this.value = value;
        formula = String.valueOf(value);
    }

    Value(final double value, final String formula) {
        this.value = value;
        this.formula = formula;
    }

    double getValue() {
        return value;
    }

    String getFormula() {
        return formula;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (formula == null ? 0 : formula.hashCode());
        long temp;
        temp = Double.doubleToLongBits(value);
        result = prime * result + (int) (temp ^ temp >>> 32);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Value other = (Value) obj;
        if (formula == null) {
            if (other.formula != null) {
                return false;
            }
        } else if (!formula.equals(other.formula)) {
            return false;
        }
        if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value)) {
            return false;
        }
        return true;
    }

}
