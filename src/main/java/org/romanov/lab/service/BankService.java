package org.romanov.lab.service;

import org.romanov.lab.entity.Bank;

/**
 * Интерфейс, предоставляющий методы для управления банками.
 *
 * <p>Этот интерфейс определяет операции CRUD (Create, Read, Update, Delete) для банка.</p>
 */
public interface BankService {
    /**
     * Создает новый банк с указанными параметрами.
     *
     * @param id              Уникальный идентификатор банка.
     * @param name            Название банка.
     */
    void create(long id, String name);

    /**
     * Возвращает информацию о текущем банке.
     *
     * @param id    Уникальный идентификатор банка.
     * @return      Объект класса {@link Bank}.
     */
    Bank read(long id);

    /**
     * Обновляет информацию о существующем банке.
     *
     * @param id    Уникальный идентификатор банка.
     * @param bank  Объект класса {@link Bank}.
     */
    void update(long id, Bank bank);

    /**
     * Удаляет банк по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор банка.
     */
    void delete(long id);
}
