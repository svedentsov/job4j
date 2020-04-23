package ru.job4j.bank;

import java.util.Objects;

/**
 * Банковский счёт.
 */
public class Account {
    /**
     * Реквизиты.
     */
    private String requisite;
    /**
     * Баланс.
     */
    private double balance;

    /**
     * Конструктор банковского счёта.
     *
     * @param requisite реквизиты.
     * @param balance   баланс.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Получить реквизиты.
     *
     * @return реквизиты.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Задать реквизиты.
     *
     * @param requisite реквизиты.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Получить баланс.
     *
     * @return баланс.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Задать баланс.
     *
     * @param balance баланс.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
