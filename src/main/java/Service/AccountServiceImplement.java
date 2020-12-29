package Service;

import DAO.AccountDAOImplement;
import Model.Account;

public class AccountServiceImplement implements AccountServiceInterface {
    private AccountDAOImplement accountDAO;

    public AccountServiceImplement() {
        accountDAO = new AccountDAOImplement();
    }

    @Override
    public boolean validateLogin(String username, String password) {
        String passwordDB = accountDAO.getAccount(username).getPassword();
        if (passwordDB == null || !passwordDB.equals(password)) {
            return false;
        }
        return true;
    }

//    @Override
//    public boolean validateSignup(Account account) {
//
//    }


}
