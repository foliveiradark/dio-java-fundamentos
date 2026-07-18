public class RedeSocial implements EnviarMensagem{

    @Override
    public void enviarMensagem(String mensagem) {

        System.out.println("Mensagem publicada na rede social: " + mensagem);
    }
}
