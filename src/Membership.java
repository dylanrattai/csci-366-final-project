
import java.math.BigDecimal;

/**
 * @author alq24
 */
public class Membership {
    private int membershipId;
    private String membershipType;
    private BigDecimal discountPercent;

    public Membership() {
    }

    public Membership(int membershipId, String membershipType, BigDecimal discountPercent) {
        this.membershipId = membershipId;
        this.membershipType = membershipType;
        this.discountPercent = discountPercent;
    }

    public Membership(String membershipType, BigDecimal discountPercent) {
        this.membershipType = membershipType;
        this.discountPercent = discountPercent;
    }

    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(BigDecimal discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public String toString() {
        return membershipType;
    }
}