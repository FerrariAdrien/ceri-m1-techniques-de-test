package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{




    Pokedex(){
        pokemons = new ArrayList<>();
    }
    public List<Pokemon> pokemons;
    @Override
    public int size() {

        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {

        pokemons.add(pokemon);
        System.out.println(pokemons.size() -1);
        return pokemons.size() - 1;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if(id < pokemons.size())
            return pokemons.get(id);
        else
            throw new PokedexException("Invalid index");
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     * The list view will be sorted using the given <tt>order</tt>.
     *
     * @param order Comparator instance used for sorting the created view.
     * @return Sorted unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        Collections.sort(sortedPokemons, order);
        return Collections.unmodifiableList(sortedPokemons);
    }


    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        PokemonMetadata pokemonMetadata = getPokemonMetadata(index);
        if(pokemonMetadata == null)
            throw new PokedexException("Invalid index");
        pokemons.add(new  Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getStamina(),cp,hp,dust, candy,5));
        return pokemons.get(pokemons.size() - 1);


    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        for(int i = 0; i < pokemons.size(); i++){
            if(pokemons.get(i).getIndex() == index)
                return new PokemonMetadata(index, pokemons.get(i).getName(), pokemons.get(i).getAttack(),pokemons.get(i).getDefense(), pokemons.get(i).getStamina());
        }
        return null;
    }
}
