package tatahcorte.jogodaspalavras.entidade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Representa a tabela sinonimo
public class Sinonimo {

    private int id;
    private String sinonimos;

    private List<String> list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSinonimos() {
        return sinonimos;
    }

    public void setSinonimos(String sinonimos) {
        this.sinonimos = sinonimos;
    }

    //Cria uma lista com as palavras salvas no banco
    public List<String> toList(){
        if(list == null){
            list = new ArrayList<>(Arrays.asList(sinonimos.split(",")));
        }
        return list;
    }
}
