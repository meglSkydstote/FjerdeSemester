import 'package:http/http.dart' as http;
import 'dart:convert';

class Pokemon {
  final String name;
  final String url;

  Pokemon({this.name, this.url});

  factory Pokemon.fromJson(Map<String, dynamic> jsonData) {
    return Pokemon(
        name: jsonData['name'] as String, url: jsonData['url'] as String);
  }

  // Future async hent billede her
  Future<String> fetchImageURL() async {
    final response = await http.get(this.url);
    if (response.statusCode == 200) {
      var jsonData = json.decode(response.body);
      return 'https://pokeres.bastionbot.org/images/pokemon/${jsonData['id']}.png';
    } else {
      return '';
    }
  }
}
