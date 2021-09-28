package ru.job4j.xml.schema;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.job4j.xml.schema
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Entries }
     */
    public Entries createEntries() {
        return new Entries();
    }

    /**
     * Create an instance of {@link EntryType }
     */
    public EntryType createEntryType() {
        return new EntryType();
    }
}
