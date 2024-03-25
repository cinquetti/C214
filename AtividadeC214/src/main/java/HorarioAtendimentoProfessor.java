import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HorarioAtendimentoProfessor {

    public boolean popularPaginaWeb(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            String nomeDoProfessor = jsonObject.getString("nomeDoProfessor");
            String horarioDeAtendimento = jsonObject.getString("horarioDeAtendimento");
            String periodo = jsonObject.getString("periodo");
            JSONArray predioArray = jsonObject.getJSONArray("predio");

            // Lógica para popular a página web com as informações extraídas
            System.out.println("Professor: " + nomeDoProfessor);
            System.out.println("Horário de atendimento: " + horarioDeAtendimento);
            System.out.println("Período: " + periodo);
            System.out.println("Prédios disponíveis:");
            for (int i = 0; i < predioArray.length(); i++) {
                System.out.println("- Prédio " + predioArray.getString(i));
            }

            // Simulação de sucesso
            return true;
        } catch (JSONException e) {
            // Se ocorrer uma exceção ao parsear o JSON, retorna falso
            e.printStackTrace();
            return false;
        }
    }
}

