package domain.giftCertificate;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class GiftCertificateMapper implements RowMapper<GiftCertificate> {
    @Override
    public GiftCertificate mapRow(ResultSet rst, int rowNum) throws SQLException {

        GiftCertificate giftCertificate = new GiftCertificate();
        giftCertificate.setId(UUID.fromString(rst.getString("id")));
        giftCertificate.setName(rst.getString("name"));
        giftCertificate.setDescription(rst.getString("description"));
        giftCertificate.setPrice(rst.getBigDecimal("price"));
        giftCertificate.setDuration(rst.getInt("duration"));
        giftCertificate.setCreateDate(rst.getTimestamp("created_date").toLocalDateTime());
        giftCertificate.setLastUpdateDate(rst.getTimestamp("last_updated_date").toLocalDateTime());

        return giftCertificate;
    }
}
