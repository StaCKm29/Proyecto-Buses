package modelos;

public class CrearRecorrido {
    public CrearRecorrido(Localidades partida, Localidades destino) throws MismaLocalidadException {
        if(partida == destino)
            throw new MismaLocalidadException("La partida y el destino no pueden ser iguales");

        switch (partida){
            case FRUTILLAR -> {
                switch (destino){
                    case CHILLAN -> {
                        // Crear recorrido
                    }
                    case CONCEPCION -> {
                        // Crear recorrido
                    }
                    case SANTIAGO -> {
                        // Crear recorrido
                    }
                }
            }
            case CHILLAN -> {
                switch (destino){
                    case FRUTILLAR -> {
                        // Crear recorrido
                    }
                    case CONCEPCION -> {
                        // Crear recorrido
                    }
                    case SANTIAGO -> {
                        // Crear recorrido
                    }
                }
            }
            case CONCEPCION -> {
                switch (destino){
                    case FRUTILLAR -> {
                        // Crear recorrido
                    }
                    case CHILLAN -> {
                        // Crear recorrido
                    }
                    case SANTIAGO -> {
                        // Crear recorrido
                    }
                }
            }
            case SANTIAGO -> {
                switch (destino){
                    case FRUTILLAR -> {
                        // Crear recorrido
                    }
                    case CHILLAN -> {
                        // Crear recorrido
                    }
                    case CONCEPCION -> {
                        // Crear recorrido
                    }
                }
            }
        }
    }
}
