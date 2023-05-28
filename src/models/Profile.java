package models;

import java.util.Objects;

/**
 * Represents a user profile containing an ID, name.
 */
public class Profile {
    private String id;
    private String name;

    /**
     * Constructs a Profile object with the specified ID, name
     *
     * @param id          The user ID.
     * @param name        The user name.
     */
    public Profile(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets the user ID.
     *
     * @return The user ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the user name.
     *
     * @return The user name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user ID.
     *
     * @param id The user ID.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the user name.
     *
     * @param name The user name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Compares the specified object with this Profile object for equality.
     * @param o The object to be compared for equality with this Profile object.
     * @return true if the specified object is equal to this Profile object.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(id, profile.id) && Objects.equals(name, profile.name);
    }

    /**
     * Returns the hash code value for this Profile object.
     * @return The hash code value for this Profile object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    /**
     * Returns the string representation of the Profile object.
     *
     * @return The string representation of the Profile object.
     */
    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id + '\'' +
                ", name='" + name + "}";
    }
}
