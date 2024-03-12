package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{



    /**
     * Liste des pokemons.
     */
    Pokedex(){
        pokemons = new ArrayList<>();
    }
    /**
     * Constructeur de la classe Pokedex.
     */
    public List<Pokemon> pokemons;
    @Override
    public int size() {

        return pokemons.size();
    }

    /**
     * Ajoute un pokemon à la liste.
     *
     * @param pokemon le pokemon à ajouter
     */
    @Override
    public int addPokemon(final Pokemon pokemon) {

        pokemons.add(pokemon);

        return pokemons.size() - 1;
    }

    /**
     * Retourne le nombre de pokemons dans la liste.
     *
     * @return le nombre de pokemons
     */
    @Override
    public Pokemon getPokemon(final int id) throws PokedexException {
        if (id < this.pokemons.size()) {
            return this.pokemons.get(id);
        } else {
            throw new PokedexException("Invalid index");
        }
    }

    @Override
    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     * The list view will be sorted using the given <tt>order</tt>.
     *
     * @param order Comparator instance used for sorting the created view.
     * @return Sorted unmodifiable list of all pokemons.
     */

    @Override
    public List<Pokemon> getPokemons(final Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(this.pokemons);
        Collections.sort(sortedPokemons, order);
        return Collections.unmodifiableList(sortedPokemons);
    }

    @Override
    public Pokemon createPokemon(final int index, final int cp, final int hp, final int dust, final int candy) throws PokedexException {
        PokemonMetadata pokemonMetadata = getPokemonMetadata(index);
        if (pokemonMetadata == null) {
            throw new PokedexException("Invalid index");
        }
        this.pokemons.add(new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getStamina(), cp, hp, dust, candy, 5));
        return this.pokemons.get(this.pokemons.size() - 1);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(final int index) throws PokedexException {
        for (int i = 0; i < this.pokemons.size(); i++) {
            if (this.pokemons.get(i).getIndex() == index) {
                return new PokemonMetadata(index, this.pokemons.get(i).getName(), this.pokemons.get(i).getAttack(), this.pokemons.get(i).getDefense(), this.pokemons.get(i).getStamina());
            }
        }
        return null;
    }
}
