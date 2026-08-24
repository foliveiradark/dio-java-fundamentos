package ui;

import enums.StatusPartida;
import model.Tabuleiro;

public interface InterfaceApresentacao {

    void exibirTabuleiro(Tabuleiro tabuleiro);

    void exibirStatusPartida(StatusPartida status);

    void exibirErro(String mensagem);

    void exibirEncerramento();

    void exibirSolicitacaoRemocao();

    void exibirSolicitacaoCoordenada();

    void exibirSolicitacaoNumero();

    void exibirSolicitacaoLimparJogadas();

    void exibirSolicitacaoSobrescrita();

    void exibirJogadaRemovida();

    void exibirJogadasRemovidas();

    void exibirPartidaSalva();

    void exibirConfirmacaoLimparJogadas();

    void exibirCandidatoAdicionado(int candidato);

    void exibirCandidatoRemovido(int candidato);

}
