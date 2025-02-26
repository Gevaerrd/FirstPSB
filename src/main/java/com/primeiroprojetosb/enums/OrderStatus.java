package com.primeiroprojetosb.enums;

public enum OrderStatus {

    WAITING_PAYMENT(0),
    PAID(1),
    SHIPPED(2),
    DELIVERED(3),
    CANCELED(4);

    private int code; // Código que vai ser instanciado pro enum

    private OrderStatus(int code) { // Todo order status é obrigado a receber um número que é atribuido a ele aqui
        this.code = code;
    }

    public int getCode() {
        return code; // Retorna o código
    }

    public static OrderStatus getOrder(int code) {
        for (OrderStatus status : OrderStatus.values()) { // Para cada status dentro do proprio enum
            if (status.getCode() == code) { // Se o status.getcode for igual ao código passado, retorna o status
                return status;
            }
        }
        throw new IllegalArgumentException("Código inválido de status");
    }

}