package ge.lanmaster.pattern.CacheManagement;

import java.util.Locale;

/**
 * @author alexander
 */
class EmployeeProfile {
    private EmployeeID id; // Employee Id
    private Locale locale; // Language Preference
    private boolean supervisor;
    private String name; // Employee name

    public EmployeeProfile(EmployeeID id, Locale locale, boolean supervisor, String name) {
        this.id = id;
        this.locale = locale;
        this.supervisor = supervisor;
        this.name = name;
    } // Constructor(EmployeeID, Locale, boolean, String)


    public EmployeeID getID() { return id; }
    public Locale getLocale() { return locale; }
    public boolean isSupervisor() { return supervisor; }
} // clas EmployeeProfile
