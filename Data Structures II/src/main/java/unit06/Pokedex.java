package unit06;

public class Pokedex {

    private BinarySearchTree<Pokemon> pokedex;

    public Pokedex() {
        pokedex = new NodeBST<>(); 
    }

    public boolean containsPokemon(Pokemon poke) {
        return pokedex.search(poke);
    }

    public void addPokemon(Pokemon poke) {
        if (!containsPokemon(poke)) { 
            pokedex.insert(poke);
        }   
    }

    public static void main(String[] args) {
       
        Pokedex dex = new Pokedex();

        Pokemon p1 = new Pokemon("Bulbasaur", 1);
        Pokemon p2 = new Pokemon("Ivysaur", 2);  
        Pokemon p3 = new Pokemon("Venusaur", 3);
        Pokemon p4 = new Pokemon("Charmander", 4);
        Pokemon p5 = new Pokemon("Charizard", 6);

        dex.addPokemon(p1);
        dex.addPokemon(p2);
        dex.addPokemon(p3);
        dex.addPokemon(p4);
        dex.addPokemon(p5);

        System.out.println(dex.containsPokemon(p3));
        System.out.println(dex.containsPokemon(p4));
        System.out.println(dex.containsPokemon(new Pokemon("Pikachu", 25)));
    }
}