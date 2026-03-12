package innovate.tamergroup.persistence.entities;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * To create ID generator sequence "VENDHQ_DISCOUNT_ITEMS_ID_SEQ_GEN":
 * CREATE SEQUENCE "VENDHQ_DISC_ITEMS_SEQ_GEN" INCREMENT BY 1 START WITH 1;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "VendhqDiscountItems.findAll", query = "select o from VendhqDiscountItems o"),
                @NamedQuery(name = "DiscountItemByRegion",
                            query = "select o.discountItemId from VendhqDiscountItems o where o.region = :region")
    })
@Table(name = "VENDHQ_DISCOUNT_ITEMS")
@SequenceGenerator(name = "VendhqDiscountItems_Id_Seq_Gen", sequenceName = "VENDHQ_DISC_ITEMS_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class VendhqDiscountItems implements Serializable {
    private static final long serialVersionUID = -982184264679269602L;
    @Column(name = "DISCOUNT_ITEM_ID", nullable = false, length = 50)
    private String discountItemId;
    @Column(nullable = false, length = 5)
    private String region;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VendhqDiscountItems_Id_Seq_Gen")
    private BigDecimal rowId;

    public VendhqDiscountItems() {
    }

    public VendhqDiscountItems(String discountItemId, String region, BigDecimal rowId) {
        this.discountItemId = discountItemId;
        this.region = region;
        this.rowId = rowId;
    }

    public String getDiscountItemId() {
        return discountItemId;
    }

    public void setDiscountItemId(String discountItemId) {
        this.discountItemId = discountItemId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public BigDecimal getRowId() {
        return rowId;
    }

}
