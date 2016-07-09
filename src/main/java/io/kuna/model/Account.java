package io.kuna.model;

import java.util.List;

public class Account {
    private String email;
    private Boolean activated;
    private List<InnerAccount> accounts;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public List<InnerAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<InnerAccount> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "{" +
                "email='" + email + '\'' +
                ", activated=" + activated +
                ", accounts=" + accounts +
                '}';
    }

    private static class InnerAccount{
        private String currency;
        private Double balance;
        private Double locked;

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public Double getBalance() {
            return balance;
        }

        public void setBalance(Double balance) {
            this.balance = balance;
        }

        public Double getLocked() {
            return locked;
        }

        public void setLocked(Double locked) {
            this.locked = locked;
        }

        @Override
        public String toString() {
            return "{" +
                    "currency='" + currency + '\'' +
                    ", balance=" + balance +
                    ", locked=" + locked +
                    '}';
        }
    }
}
