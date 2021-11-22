package com.sergeykuzmin.visiting_card.util;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class QPredicate {

    private List<Predicate> predicates = new ArrayList<>();


    public <T> QPredicate add(T object, Function<T, Predicate> function) {
        if (object != null) {
            predicates.add(function.apply(object));
        }
        return this;
    }
    public QPredicate add(Predicate predicate) {
        if (predicate != null) {
            predicates.add(predicate);
        }
        return this;
    }

    public Predicate buildAnd() {
        return ExpressionUtils.allOf(predicates);
    }


    public static QPredicate builder() {
        return new QPredicate();
    }

    private QPredicate() {
    }
}