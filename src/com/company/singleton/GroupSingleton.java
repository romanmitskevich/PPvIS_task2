package com.company.singleton;

import com.company.controller.GroupController;
import com.company.entity.Group;
import com.company.exception.StudentException;

import java.util.*;

public class GroupSingleton {

    private final Map<Integer, LinkedList<GroupController>> storage;

    private GroupSingleton() {
        storage = new HashMap<>();
    };

    private static final GroupSingleton instance = new GroupSingleton();

    public static GroupSingleton getInstance() {
        return instance;
    }

    public List<GroupController> getGroups() {
        Map<Integer, LinkedList<GroupController>> copyOfStorage = Map.copyOf(storage);
        List<GroupController> result = new ArrayList<>();

        for (LinkedList<GroupController> list : copyOfStorage.values()) {
            result.addAll(list);
        }

        return result;
    }

    public List<GroupController> getGroupsByCourse(int course) {
        Map<Integer, LinkedList<GroupController>> copy = Map.copyOf(storage);

        if (copy.containsKey(course)) {
            List<Integer> keys = new ArrayList<>(copy.keySet());

            for (Integer key : keys) {
                if (key == course) {
                    return copy.get(key);
                }
            }
        }
        else
        {
            throw new StudentException("There is no such course!");
        }
        return null;
    }

    public boolean addGroup(GroupController group) {
        int course = group.getCourse();
        if (storage.containsKey(course)) {
            List<Integer> keys = new ArrayList<>(storage.keySet());

            for (Integer key : keys) {
                if (key == course) {
                    return storage.get(key).add(group);
                }
            }
        }
        return false;
    }

    public boolean deleteGroup(GroupController groupToDelete) {
        for (LinkedList<GroupController> list : storage.values()) {
            if (list.contains(groupToDelete)) {
                return list.remove(groupToDelete);
            }
        }
        return false;
    }
}
