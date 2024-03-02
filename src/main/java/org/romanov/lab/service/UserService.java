package org.romanov.lab.service;

import org.romanov.lab.entity.Bank;
import org.romanov.lab.entity.User;

import java.time.LocalDate;
import java.util.List;

/**
 * Интерфейс, предоставляющий методы для управления информацией о клиентах банка.
 *
 * <p>Этот интерфейс определяет операции CRUD (Create, Read, Update, Delete) для клиента банка.</p>
 */
public interface UserService {
    /**
     * Создает нового клиента банка с указанными параметрами.
     *
     * @param id          Уникальный идентификатор клиента банка.
     * @param lastName    Фамилия клиента.
     * @param firstName   Имя клиента.
     * @param patronymic  Отчество клиента.
     * @param birthDate   Дата рождения клиента.
     * @param workplace   Место работы клиента.
     * @param usedBanksIds   Список банков, которыми пользуется клиент.
     */
    void create(int id, String lastName, String firstName, String patronymic, LocalDate birthDate, String workplace, List<Bank> usedBanksIds);

    /**
     * Возвращает информацию о текущем клиенте банка.
     *
     * @return Объект клиента банка.
     */
    User read();

    /**
     * Обновляет информацию о существующем клиенте банка.
     */
    void update();

    /**
     * Удаляет клиента банка по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор клиента банка.
     */
    void delete(int id);
}
