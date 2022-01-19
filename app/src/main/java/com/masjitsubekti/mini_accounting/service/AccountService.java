package com.masjitsubekti.mini_accounting.service;

import com.masjitsubekti.mini_accounting.model.Account;

import java.util.ArrayList;

public class AccountService {
    private ArrayList<Account> accounts;

    public AccountService(){
        accounts = new ArrayList<>();
    }

    public ArrayList<Account> getListAccounts(){
        return accounts;
    }

    public void insert(Object x) {
        accounts.add((Account) x);
    }

    public void update(int index, Object x) {
        accounts.set(index ,(Account) x);
    }

    public void delete(int index) {
        accounts.remove(index);
    }
}
