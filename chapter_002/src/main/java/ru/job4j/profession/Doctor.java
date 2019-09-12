package ru.job4j.profession;

/**
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Doctor extends Profession {
    private String level;
    private String hospitalName;

    public String getLevel() {
        return level;
    }

    public String getHospitalName() {
        return hospitalName;
    }
}
