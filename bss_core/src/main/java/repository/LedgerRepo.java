package repository;

import model.Ledger;

import java.sql.Connection;
import java.sql.SQLException;

public interface LedgerRepo {
    long insert(Connection con, Ledger ledger);

}
