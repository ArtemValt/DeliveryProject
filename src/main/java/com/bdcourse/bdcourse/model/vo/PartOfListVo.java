package com.bdcourse.bdcourse.model.vo;

import com.bdcourse.bdcourse.model.PartOfList;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
public class PartOfListVo<T> implements PartOfList<T> {

    private final List<T> list ;
    private final int total;

    @Override
    public List<T> getList() {
        return list;
    }

    @Override
    public int getTotal() {
        return total;
    }

    @Override
    public int size() {
        return total;
    }

    @Override
    public boolean isEmpty() {
        return CollectionUtils.isEmpty(list);
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
    list.clear();
    }
}
