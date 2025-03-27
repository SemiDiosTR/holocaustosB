package com.holocaustos.pedidos.models.enums;

public enum Estado {
    CANCELADO(0L),
	PENDIENTE(1L),
    ENVIADO(2L),
    ENTREGADO(3L);

    private final Long codigo;

    Estado(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public static Estado longToEnum(Long codigo) {
        for (Estado estado : Estado.values()) {
            if (estado.getCodigo().equals(codigo)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Código de estado no válido: " + codigo);
    }
}
