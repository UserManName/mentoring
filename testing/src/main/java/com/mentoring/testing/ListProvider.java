package com.mentoring.testing;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

/**
 * @author mkavaliou
 */
public class ListProvider {

    public List<Integer> getList() {
        return Lists.newArrayList(1, 2, 3, 4, 5);
    }

    public List<Integer> getOrderedList() {
        List<Integer> list = Lists.newLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        return list;
    }

    public Entity getEntity(String name) {
        Entity entity = new Entity();
        entity.setName(name);
        return entity;
    }

}
