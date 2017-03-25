package com.cf.study.distribute.system.bean;

import java.util.ArrayList;
import java.util.Arrays;
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
        final List<Value> values = new ArrayList<Value>();
        if (list.size() == 1) {
            values.add(list.get(0));
        } else {
            for (int i = 0; i < list.size(); i++) {
                final List<Value> temp = new ArrayList<Value>(list);
                temp.remove(i);
                final List<Value> aList = getAllCalculations(temp);
                final double bValue = list.get(i).getValue();
                final String bFormula = list.get(i).getFormula();
                for (final Value a : aList) {
                    final double aValue = a.getValue();
                    final String aFormula = a.getFormula();
                    values.add(new Value(aValue + bValue, "(" + aFormula + "+" + bFormula + ")"));
                    values.add(new Value(aValue - bValue, "(" + aFormula + "-" + bFormula + ")"));
                    values.add(new Value(aValue * bValue, "(" + aFormula + "*" + bFormula + ")"));
                    values.add(new Value(aValue / bValue, "(" + aFormula + "/" + bFormula + ")"));
                    values.add(new Value(bValue - aValue, "(" + bFormula + "-" + aFormula + ")"));
                    values.add(new Value(bValue / aValue, "(" + bFormula + "/" + aFormula + ")"));
                }
            }
        }
        return values;
    }

}
