import 'dart:convert';
import 'package:flutter/material.dart';
import './pokemon.dart';
import 'package:http/http.dart' as http;

void main() {
  runApp(MaterialApp(
    title: 'Pokémon',
    theme: ThemeData(
      primarySwatch: Colors.red,
    ),
    home: PokemonHomePage(),
  ));
}

class PokemonHomePage extends StatefulWidget {
  PokemonHomePage({Key key}) : super(key: key);

  @override
  _PokemonHomePageState createState() => _PokemonHomePageState();
}

Future<List<Pokemon>> fetchPokemons() async {
  final response =
      await http.get('https://pokeapi.co/api/v2/pokemon/?limit=1118');
  List<Pokemon> pokemons = [];
  if (response.statusCode == 200) {
    // jeg ved at mit kald gik godt, og at der kom noget data tilbage
    var jsonData = json.decode(response.body);
    List<dynamic> jsonPokemons = jsonData['results'];
    for (int i = 0; i < jsonPokemons.length; i++) {
      var newPokemon = jsonPokemons[i]; // newPokemon er JSON ikke Pokemon
      pokemons.add(Pokemon.fromJson(newPokemon));
    }
  }
  return pokemons;
}

class _PokemonHomePageState extends State<PokemonHomePage> {
  Future<List<Pokemon>> futurePokemonList;

  @override
  void initState() {
    super.initState();
    futurePokemonList = fetchPokemons();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Pokémons'),
      ),
      body: FutureBuilder(
          future: futurePokemonList,
          builder: (context, snapshot) {
            if (snapshot.hasData) {
              return ListView.builder(
                itemCount: snapshot.data.length,
                itemBuilder: (context, index) {
                  Pokemon pokemon = snapshot.data[index];
                  return Card(
                    child: ListTile(
                      title: Text('${pokemon.name} ${index}'),
                      subtitle: Text('${pokemon.url}'),
                      leading: FutureBuilder(
                          future: pokemon.fetchImageURL(),
                          builder: (context, snapshot) {
                            if (snapshot.hasData) {
                              return Image.network(snapshot.data);
                            } else {
                              return CircularProgressIndicator();
                            }
                          }),
                    ),
                  );
                },
              );
            }
            return CircularProgressIndicator();
          }),
    );
  }
}
