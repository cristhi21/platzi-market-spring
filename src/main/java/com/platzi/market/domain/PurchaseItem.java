package com.platzi.market.domain;

public class PurchaseItem {
    private int prodcutId;
    private int quantity;
    private double total;
    private boolean active;

    public int getProdcutId() {
        return prodcutId;
    }

    public void setProdcutId(int prodcutId) {
        this.prodcutId = prodcutId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
