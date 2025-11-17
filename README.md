# Coffee-n-Roll
Sistema JavaFX para gerenciamento de receitas em uma cafeteria temática de rock.

## Solicitação
Após se embaralhar nas receitas e perder algumas, a Sra Roberta viu a necessidade de ter um sistema próprio para facilitar a busca das mesmas.

## Objetivo do projeto
Facilitar o cadastro, organização e consulta de receitas culinárias, separadas por categorias e subcategorias, com uma interface simples e organizada e conectada ao banco de dados 'cafeteria'.

## Funcionalidades
- Cadastro de receitas com nome, categoria, subcategoria, ingredientes e modo de preparo;
- Atualização e exclusão de receitas;
- Filtro por categoria e subcategoria;
- Interface gráfica com JavaFX;
- Persistência de dados via JDBC e MySQL.

## Tecnologias utilizadas
- Java 21
- JavaFX
- MySQL
- JDBC
- IntelliJ IDEA
- Git/GitHub

## Estrutura do projeto
controller -> ContTelaPrincipal, ContConsulta.
dao -> CategoriaDAO, Conexao, ReceitaDAO, SubCategoriaDAO.
model -> Categoria, Receita, SubCategoria.
view -> TelaPrincipal, Consulta.