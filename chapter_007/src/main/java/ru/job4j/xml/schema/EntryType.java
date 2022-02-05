package ru.job4j.xml.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entryType", namespace = "http://job4j.ru", propOrder = {"field"})
public class EntryType {

    @XmlElement(namespace = "http://job4j.ru")
    protected int field;

    public EntryType() {
    }

    public EntryType(int field) {
        this.field = field;
    }

    /**
     * Gets the value of the field property.
     */
    public int getField() {
        return field;
    }

    /**
     * Sets the value of the field property.
     */
    public void setField(int value) {
        this.field = value;
    }
}
