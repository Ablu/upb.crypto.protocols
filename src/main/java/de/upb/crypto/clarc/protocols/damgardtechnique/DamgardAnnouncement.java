package de.upb.crypto.clarc.protocols.damgardtechnique;

import de.upb.crypto.clarc.protocols.parameters.Announcement;
import de.upb.crypto.craco.commitment.interfaces.CommitmentValue;
import de.upb.crypto.math.hash.annotations.AnnotatedUbrUtil;
import de.upb.crypto.math.hash.annotations.UniqueByteRepresented;
import de.upb.crypto.math.interfaces.hash.ByteAccumulator;
import de.upb.crypto.math.serialization.Representation;
import de.upb.crypto.math.serialization.annotations.AnnotatedRepresentationUtil;
import de.upb.crypto.math.serialization.annotations.Represented;

/**
 * The DamgardAnnouncement is the commitment of an announcement of the original Sigma-Protocol
 */
class DamgardAnnouncement implements Announcement {

    @UniqueByteRepresented
    @Represented
    private CommitmentValue commitmentValue;

    /**
     * Constructor for DamgardAnnouncement
     *
     * @param commitmentValue commitvalue for announcements from Damgard's Technique
     */
    public DamgardAnnouncement(CommitmentValue commitmentValue) {
        this.commitmentValue = commitmentValue;
    }

    public DamgardAnnouncement(Representation representation) {
        AnnotatedRepresentationUtil.restoreAnnotatedRepresentation(representation, this);
    }

    public CommitmentValue getCommitmentValue() {
        return commitmentValue;
    }

    public void setCommitmentValue(CommitmentValue commitmentValue) {
        this.commitmentValue = commitmentValue;
    }

    /**
     * The representation of this object. Used for serialization
     *
     * @return a Representation or null if the representedTypeName suffices to instantiate an equal object again
     * @see Representation
     */
    @Override
    public Representation getRepresentation() {
        return AnnotatedRepresentationUtil.putAnnotatedRepresentation(this);
    }

    /**
     * Updates the ByteAccumulator with the bytes from this class. The input to the accumulators update function should
     * be an injective (with respect to a given domain) byte encoding of this object.
     *
     * @param accumulator the given accumulator
     */
    @Override
    public ByteAccumulator updateAccumulator(ByteAccumulator accumulator) {
        return AnnotatedUbrUtil.autoAccumulate(accumulator, this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DamgardAnnouncement that = (DamgardAnnouncement) o;

        return getCommitmentValue() != null ? getCommitmentValue().equals(that.getCommitmentValue()) : that.getCommitmentValue() == null;
    }

    @Override
    public int hashCode() {
        return getCommitmentValue() != null ? getCommitmentValue().hashCode() : 0;
    }
}
