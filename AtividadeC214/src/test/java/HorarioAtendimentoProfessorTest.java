import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HorarioAtendimentoProfessorTest {

    @Test
    void testPopularPaginaWebSucesso() {
        HorarioAtendimentoProfessor horarioAtendimentoProfessor = new HorarioAtendimentoProfessor();
        String jsonString = "{\"nomeDoProfessor\": \"João\", \"horarioDeAtendimento\": \"Segunda 14:00-16:00\", \"periodo\": \"integral\", \"predio\": [\"1\", \"2\", \"3\"]}";
        assertTrue(horarioAtendimentoProfessor.popularPaginaWeb(jsonString));
    }

    @Test
    void testPopularPaginaWebSucessoPredio10() {
        HorarioAtendimentoProfessor horarioAtendimentoProfessor = new HorarioAtendimentoProfessor();
        String jsonString = "{\"nomeDoProfessor\": \"Maria\", \"horarioDeAtendimento\": \"Terça 10:00-12:00\", \"periodo\": \"noturno\", \"predio\": [\"10\"]}";
        assertTrue(horarioAtendimentoProfessor.popularPaginaWeb(jsonString));
    }

    @Test
    void testPopularPaginaWebSucessoSemPredio() {
        HorarioAtendimentoProfessor horarioAtendimentoProfessor = new HorarioAtendimentoProfessor();
        String jsonString = "{\"nomeDoProfessor\": \"Carlos\", \"horarioDeAtendimento\": \"Quarta 08:00-10:00\", \"periodo\": \"integral\"}";
        assertTrue(horarioAtendimentoProfessor.popularPaginaWeb(jsonString));
    }

    @Test
    void testPopularPaginaWebFalhaJSONInvalido() {
        HorarioAtendimentoProfessor horarioAtendimentoProfessor = new HorarioAtendimentoProfessor();
        String jsonString = "{nomeDoProfessor: \"João\", horarioDeAtendimento: \"Segunda 14:00-16:00\", periodo: \"integral\", predio: [\"1\", \"2\", \"3\"]}";
        assertFalse(horarioAtendimentoProfessor.popularPaginaWeb(jsonString));
    }

    @Test
    void testPopularPaginaWebFalhaCampoFaltante() {
        HorarioAtendimentoProfessor horarioAtendimentoProfessor = new HorarioAtendimentoProfessor();
        String jsonString = "{\"horarioDeAtendimento\": \"Quinta 16:00-18:00\", \"periodo\": \"noturno\", \"predio\": [\"5\"]}";
        assertFalse(horarioAtendimentoProfessor.popularPaginaWeb(jsonString));
    }


    @Test
    void testPopularPaginaWebSucessoMultiplosProfessores() {
        HorarioAtendimentoProfessor horarioAtendimentoProfessor = new HorarioAtendimentoProfessor();
        String jsonString = "{\"nomeDoProfessor\": \"João\", \"horarioDeAtendimento\": \"Segunda 14:00-16:00\", \"periodo\": \"integral\", \"predio\": [\"1\", \"2\", \"3\"]}";
        assertTrue(horarioAtendimentoProfessor.popularPaginaWeb(jsonString));

        jsonString = "{\"nomeDoProfessor\": \"Maria\", \"horarioDeAtendimento\": \"Terça 10:00-12:00\", \"periodo\": \"noturno\", \"predio\": [\"4\", \"5\", \"6\"]}";
        assertTrue(horarioAtendimentoProfessor.popularPaginaWeb(jsonString));

        jsonString = "{\"nomeDoProfessor\": \"José\", \"horarioDeAtendimento\": \"Quarta 08:00-10:00\", \"periodo\": \"integral\", \"predio\": [\"7\", \"8\"]}";
        assertTrue(horarioAtendimentoProfessor.popularPaginaWeb(jsonString));
    }

    @Test
    void testPopularPaginaWebSucessoPeriodoNoturno() {
        HorarioAtendimentoProfessor horarioAtendimentoProfessor = new HorarioAtendimentoProfessor();
        String jsonString = "{\"nomeDoProfessor\": \"Maria\", \"horarioDeAtendimento\": \"Terça 20:00-22:00\", \"periodo\": \"noturno\", \"predio\": [\"9\", \"10\"]}";
        assertTrue(horarioAtendimentoProfessor.popularPaginaWeb(jsonString));
    }

    @Test
    void testPopularPaginaWebSucessoPredioEspecifico() {
        HorarioAtendimentoProfessor horarioAtendimentoProfessor = new HorarioAtendimentoProfessor();
        String jsonString = "{\"nomeDoProfessor\": \"Carlos\", \"horarioDeAtendimento\": \"Quarta 16:00-18:00\", \"periodo\": \"integral\", \"predio\": [\"3\"]}";
        assertTrue(horarioAtendimentoProfessor.popularPaginaWeb(jsonString));
    }

    @Test
    void testPopularPaginaWebSucessoPredioGenerico() {
        HorarioAtendimentoProfessor horarioAtendimentoProfessor = new HorarioAtendimentoProfessor();
        String jsonString = "{\"nomeDoProfessor\": \"Ana\", \"horarioDeAtendimento\": \"Quinta 14:00-16:00\", \"periodo\": \"integral\"}";
        assertTrue(horarioAtendimentoProfessor.popularPaginaWeb(jsonString));
    }

    @Test
    void testPopularPaginaWebFalhaPeriodoInvalido() {
        HorarioAtendimentoProfessor horarioAtendimentoProfessor = new HorarioAtendimentoProfessor();
        String jsonString = "{\"nomeDoProfessor\": \"João\", \"horarioDeAtendimento\": \"Segunda 14:00-16:00\", \"periodo\": \"\", \"predio\": [\"1\", \"2\", \"3\"]}";
        assertFalse(horarioAtendimentoProfessor.popularPaginaWeb(jsonString));
    }

    @Test
    void testPopularPaginaWebFalhaPredioInvalido() {
        HorarioAtendimentoProfessor horarioAtendimentoProfessor = new HorarioAtendimentoProfessor();
        String jsonString = "{\"nomeDoProfessor\": \"João\", \"horarioDeAtendimento\": \"Segunda 14:00-16:00\", \"periodo\": \"integral\", \"predio\": []}";
        assertFalse(horarioAtendimentoProfessor.popularPaginaWeb(jsonString));
    }

    @Test
    void testPopularPaginaWebFalhaHorarioInvalido() {
        HorarioAtendimentoProfessor horarioAtendimentoProfessor = new HorarioAtendimentoProfessor();
        String jsonString = "{\"nomeDoProfessor\": \"João\", \"horarioDeAtendimento\": \"12:00-14:00\", \"periodo\": \"integral\", \"predio\": [\"1\", \"2\", \"3\"]}";
        assertFalse(horarioAtendimentoProfessor.popularPaginaWeb(jsonString));
    }

    @Test
    void testPopularPaginaWebSucessoDiaSemanaEspecifico() {
        HorarioAtendimentoProfessor horarioAtendimentoProfessor = new HorarioAtendimentoProfessor();
        String jsonString = "{\"nomeDoProfessor\": \"Ana\", \"horarioDeAtendimento\": {\"diaSemana\": \"Quarta\", \"horario\": \"09:00-11:00\"}, \"periodo\": \"integral\", \"predio\": [\"3\"]}";
        assertTrue(horarioAtendimentoProfessor.popularPaginaWeb(jsonString));
    }

    @Test
    void testPopularPaginaWebSucessoPrédioCorreto() {
        HorarioAtendimentoProfessor horarioAtendimentoProfessor = new HorarioAtendimentoProfessor();
        String jsonString = "{\"nomeDoProfessor\": \"Pedro\", \"horarioDeAtendimento\": \"Segunda 10:00-12:00\", \"periodo\": \"noturno\", \"predio\": [\"6\"]}";
        assertTrue(horarioAtendimentoProfessor.popularPaginaWeb(jsonString));
    }

}

