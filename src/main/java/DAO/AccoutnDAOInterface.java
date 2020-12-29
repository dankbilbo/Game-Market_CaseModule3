package DAO;

import Model.Account;

import java.util.HashMap;

public interface AccoutnDAOInterface {
    public Account getAccount(String username);
//    public Account getAccountByUsername(String username);
    public int insertAccount(Account account);
//    public boolean updateAccount(String username, Account account);
}
