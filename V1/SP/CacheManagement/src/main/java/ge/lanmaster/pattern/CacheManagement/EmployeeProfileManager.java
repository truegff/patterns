package ge.lanmaster.pattern.CacheManagement;

/**
 * @author alexander
 */
public class EmployeeProfileManager {
    private EmployeeCache cache = new EmployeeCache();
    private EmployeeProfileFetcher server = new EmployeeProfileFetcher();

    /**
     * Fetch an employee profile for the given employee id
     * from the internal cache or timekeeping server if not in
     * the internal cache.
     * @param id
     * @return employee's profile or null if employee profile
     * not found.
     */
    EmployeeProfile fetchEmployee(EmployeeID id) {
        EmployeeProfile profile = cache.fetchEmployee(id);
        if (profile == null) { // if not in cache try server
            profile = server.fetchEmployee(id);
            if (profile != null) { // Got profile from server
                // put profile in the cache
                cache.addEmployee(profile);
            } // if != null
        } // if == null
        return profile;
    } // fetchEmployee(EmployeeID)
} // class EmployeeProfileManager
