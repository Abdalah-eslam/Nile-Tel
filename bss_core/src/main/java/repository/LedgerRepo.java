package repository;

import model.Ledger;
import utils.DBConnection;
import utils.Mapper.LedgerMapper;
import utils.dbStatements.LedgerStatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class LedgerRepo {

    public List<Ledger> findTransactionsByMsisdnAndDateRange(String msisdn,Timestamp from,Timestamp to){
        List<Ledger> transactions = new ArrayList<>();
        try (Connection connection =DBConnection.getConnection();
        PreparedStatement ps =connection.prepareStatement(LedgerStatements.FIND_TRANSACTIONS_BY_MSISDN_AND_DATE_RANGE)) {
            ps.setString(1, msisdn);
            ps.setTimestamp(2, from);
            ps.setTimestamp(3, to);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    transactions.add(LedgerMapper.mapResultSetToLedger(rs));
                }
            }
        }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return transactions;
    }
}
