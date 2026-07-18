public class Email implements EnviarMensagem{

    @Override
    public void enviarMensagem (String mensagem) {

        System.out.println("E-mail enviado: " + mensagem);
    }
}
