public class SMS implements EnviarMensagem {

    @Override
    public void enviarMensagem(String mensagem){

        System.out.println("SMS enviado " + mensagem);
    }

}
