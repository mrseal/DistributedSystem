package com.cf.study.distribute.system.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculate24 {

    private final static Logger LOGGER = LoggerFactory.getLogger(Calculate24.class);

    public static String calculate(final int a, final int b, final int c, final int d) {
        final long start = System.currentTimeMillis();
        final List<Value> input = Arrays.asList(new Value(a), new Value(b), new Value(c), new Value(d));
        final Set<Value> allCalcs = new HashSet<Value>(getAllCalculations(input));
        final StringBuilder result = new StringBuilder();
        for (final Value calc : allCalcs) {
            if (calc.getValue() > 23.99 && calc.getValue() < 24.01) {
                result.append(calc.getFormula()).append("\n");
            }
        }
        final long cost = System.currentTimeMillis() - start;
        // TODO: implement time cost via interceptor
        LOGGER.debug("[Calculate24] send response in {}ms", cost);
        if (result.length() == 0) {
            result.append("No Answer!");
        }
        return result.toString();
    }

    private static List<Value> getAllCalculations(final List<Value> list) {
        final List<Value> result = new ArrayList<>();
        final int size = list.size();
        if (size == 1) {
            return list;
        } else if (size == 2) {
            return getAllCalculations(list.subList(0, 1), list.subList(1, 2));
        } else {
            for (int i = 0; i < size / 2; i++) {
                final List<Value> temp = new ArrayList<Value>(list);
                for (int j = i; j < size; j++) {
                    Collections.swap(temp, i, j);
                    result.addAll(getAllCalculations(getAllCalculations(temp.subList(0, i + 1)), getAllCalculations(temp.subList(i + 1, size))));
                }
            }
        }
        return result;
    }

    private static List<Value> getAllCalculations(final List<Value> aList, final List<Value> bList) {
        final List<Value> values = new ArrayList<Value>();
        for (final Value a : aList) {
            final double aValue = a.getValue();
            final String aFormula = a.getFormula();
            for (final Value b : bList) {
                final double bValue = b.getValue();
                final String bFormula = b.getFormula();
                values.add(new Value(aValue + bValue, "(" + aFormula + "+" + bFormula + ")"));
                values.add(new Value(aValue - bValue, "(" + aFormula + "-" + bFormula + ")"));
                values.add(new Value(aValue * bValue, "(" + aFormula + "*" + bFormula + ")"));
                values.add(new Value(aValue / bValue, "(" + aFormula + "/" + bFormula + ")"));
                values.add(new Value(bValue - aValue, "(" + bFormula + "-" + aFormula + ")"));
                values.add(new Value(bValue / aValue, "(" + bFormula + "/" + aFormula + ")"));
            }
        }
        return values;
    }

}
