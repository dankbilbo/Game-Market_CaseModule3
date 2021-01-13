package DAO;

import Model.Account;

import java.util.HashMap;

public interface AccoutnDAOInterface {
    public Account getAccount(String username, String password);
    public int insertAccount(Account account);
    public int updateAccount(Account account);
}
