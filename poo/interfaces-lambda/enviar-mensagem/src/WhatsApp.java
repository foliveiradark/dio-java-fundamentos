public class WhatsApp implements EnviarMensagem{

    @Override
    public void enviarMensagem(String mensagem) {

        System.out.println("Whatsapp enviado: " + mensagem);
    }
}
