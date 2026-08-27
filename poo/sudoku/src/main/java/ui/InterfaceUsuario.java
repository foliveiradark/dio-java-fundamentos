package ui;

import service.Jogada;

public interface InterfaceUsuario {

    int lerOpcaoMenu();

    int lerOpcaoMenuPartida();

    String lerCoordenada();

    int lerInteiro();

    boolean lerConfirmacao();

    Jogada lerJogada();

}
