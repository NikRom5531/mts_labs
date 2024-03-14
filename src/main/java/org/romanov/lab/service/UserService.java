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
     * @param id                Уникальный идентификатор клиента банка.
     * @param lastName          Фамилия клиента.
     * @param firstName         Имя клиента.
     * @param patronymic        Отчество клиента.
     * @param birthDate         Дата рождения клиента.
     * @param workplace         Место работы клиента.
     * @param bankList          Банки, которыми пользуется клиент.
     */
    void create(long id, String lastName, String firstName, String patronymic, LocalDate birthDate, String workplace, List<Bank> bankList);

    /**
     * Возвращает информацию о текущем клиенте банка.
     *
     * @param id    Уникальный идентификатор клиента банка.
     * @return      Объект класса {@link User}.
     */
    User read(long id);

    /**
     * Обновляет информацию о существующем клиенте банка.
     *
     * @param id    Уникальный идентификатор клиента банка.
     * @param user  Объект класса {@link User}.
     */
    void update(long id, User user);

    /**
     * Удаляет клиента банка по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор клиента банка.
     */
    void delete(long id);
}
