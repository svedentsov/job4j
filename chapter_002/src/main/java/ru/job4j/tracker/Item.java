package ru.job4j.tracker;

import com.google.common.base.Objects;

import java.util.Date;
import java.util.StringJoiner;

/**
 * Заявка.
 */
public class Item {

    private String id;
    private String name;
    private String description;
    private long create;

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreate() {
        return this.create;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCreate(long create) {
        this.create = create;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return create == item.create
                && Objects.equal(id, item.id)
                && Objects.equal(name, item.name)
                && Objects.equal(description, item.description);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (create ^ (create >>> 32));
        return result;
    }

    @Override
    public String toString() {
        String idString = "ID : " + id;
        String nameString = "Имя : " + name;
        String descString = "Описание : " + description;
        String createString = "Дата создания : " + new Date(this.getCreate());
        String LN = System.lineSeparator();

        return new StringJoiner(LN).add(idString).add(nameString).add(descString).add(createString).toString();
    }
}
