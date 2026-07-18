import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<EnviarMensagem> servicos = new ArrayList<>();

        servicos.add(new SMS());
        servicos.add(new Email());
        servicos.add(new WhatsApp());
        servicos.add(new RedeSocial());

        enviarCampanha(
                servicos,
                "A Black Friday começa hoje!"
        );

    }

    public static void enviarCampanha(
            List<EnviarMensagem> servicos,
            String mensagem) {

        for (EnviarMensagem servico : servicos) {
            servico.enviarMensagem(mensagem);
        }
    }
}