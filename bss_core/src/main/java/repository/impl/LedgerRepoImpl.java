package repository.impl;

import model.Ledger;
import repository.LedgerRepo;
import utils.dbStatements.LedgerStatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LedgerRepoImpl implements LedgerRepo {
    @Override
    public long insert(Connection con, Ledger ledger){
        try (PreparedStatement ps = con.prepareStatement(LedgerStatements.INSERT)) {
            ps.setLong(1, ledger.getSubscriberId());
            ps.setString(2, String.valueOf(ledger.getEntryType()));
            ps.setLong(3, ledger.getAmountPiasters().longValueExact());
            ps.setLong(4, ledger.getBalanceAfterPiasters().longValueExact());
            ps.setString(5, ledger.getReferenceNumber());
            ps.setString(6, ledger.getReason());
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getLong(1);
            }
        } catch (Exception e) {
            throw new RuntimeException( "can not insert ledger ",e);
        }
    }

}
