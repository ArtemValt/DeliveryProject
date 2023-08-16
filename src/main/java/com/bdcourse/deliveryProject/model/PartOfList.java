package com.bdcourse.deliveryProject.model;

import java.util.Collection;
import java.util.List;

public interface PartOfList <T> extends Collection<T> {
    List<T> getList();
    int getTotal();

}
