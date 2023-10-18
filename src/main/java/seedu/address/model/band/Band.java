package seedu.address.model.band;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.musician.Musician;
import seedu.address.model.tag.Tag;

/**
 * Represents a Band in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Band {

    private final BandName name;
    private final Set<Tag> genres = new HashSet<>();
    private final Set<Musician> musicians = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Band(BandName name, Set<Tag> genreTags, Set<Musician> musicians) {
        requireAllNonNull(name, genreTags, musicians);
        this.name = name;
        this.genres.addAll(genreTags);
        this.musicians.addAll(musicians);
    }

    public BandName getName() {
        return name;
    }

    public Set<Tag> getGenres() {
        return Collections.unmodifiableSet(genres);
    }

    public Set<Musician> getMusicians() {
        return Collections.unmodifiableSet(musicians);
    }

    /**
     * Returns true if both bands have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSameBand(Band otherBand) {
        if (otherBand == this) {
            return true;
        }
        return otherBand != null
                && otherBand.getName().equals(getName());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("name", name)
            .add("genres", genres)
            .add("musicians", musicians)
            .toString();
    }
}
