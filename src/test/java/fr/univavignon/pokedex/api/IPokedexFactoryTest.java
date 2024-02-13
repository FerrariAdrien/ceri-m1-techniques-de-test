package fr.univavignon.pokedex.api;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
public class IPokedexFactoryTest {


    @Mock
    private static IPokedexFactory iPokedexFactory;

    @Mock
    private static IPokemonMetadataProvider metadataProvider;

    @Mock
    private static IPokemonFactory pokemonFactory;

    @Before
    public void setUp(){
        // Créer un mock de IPokedexFactory
        iPokedexFactory = mock(IPokedexFactory.class);

        // Créer des mocks pour les arguments de la méthode createPokedex
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);

    }

    @Test
    public void testCreatePokedex(){
        // Créer un mock de IPokedex
        IPokedex pokedex = mock(IPokedex.class);

        // Définir le comportement du mock de IPokedexFactory
        when(iPokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);

        // Appeler la méthode createPokedex
        IPokedex pokedex2 = iPokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        // Vérifier que la méthode createPokedex a été appelée avec les bons arguments
        verify(iPokedexFactory).createPokedex(metadataProvider, pokemonFactory);

        // Vérifier que le résultat de la méthode est bien le mock de IPokedex
        assert(pokedex2 == pokedex);
    }


}
