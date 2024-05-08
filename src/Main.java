import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

record Pessoa(String nome, int idade, String cidade) {
}

record Livro(String titulo, String autor, Editora editora) {
}

record Editora(String nome, String cidade) {
}

public class Main {
    public static void main(String[] args) {

        // 1 e 2
        String jsonPessoa = "{\"nome\":\"Vítor\",\"idade\":26,\"cidade\":\"Cubatão\",\"vivo\":true}";

        System.out.println(jsonPessoa);

        Gson gsonPessoa = new GsonBuilder()
                .setLenient()
                .create();
        Pessoa pessoa = gsonPessoa.fromJson(jsonPessoa, Pessoa.class);
        System.out.println(pessoa);

        // 3

        String jsonLivro = """
                {
                    "titulo": "naruto",
                    "autor": "Masashi Kishimoto",
                    "editora": {
                                    "nome": "Panini",
                                    "cidade": "Módena"
                                }
                }
                """;
        System.out.println(jsonLivro);
        Gson gsonLivro = new Gson();
        Livro livro = gsonLivro.fromJson(jsonLivro, Livro.class);

        System.out.println(livro);
    }
}