package ru.job4j.xml.schema;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"entry"})
@XmlRootElement(name = "entries", namespace = "http://job4j.ru")
public class Entries {
    public Entries() {
    }

    @XmlElement(namespace = "http://job4j.ru")
    protected List<EntryType> entry;

    public void setEntry(List<EntryType> entry) {
        this.entry = entry;
    }
}
