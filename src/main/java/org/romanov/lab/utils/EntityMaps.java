package org.romanov.lab.utils;

import org.romanov.lab.entity.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Утилитарный класс для хранения коллекций объектов-сущностей.
 */
public class EntityMaps {
    /**
     * Карта для хранения объектов банков по их идентификатору.
     */
    public static final Map<Long, Bank> bankMap = new HashMap<>();

    /**
     * Метод для получения свободного идентификатора в карте банков.
     *
     * @return свободный идентификатор для использования
     */
    public static long getFreeId(){
        long freeId = 0;
        while (bankMap.containsKey(freeId)) freeId++;
        return freeId;
    }
}
