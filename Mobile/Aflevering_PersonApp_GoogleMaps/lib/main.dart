import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:flutter/services.dart';
import 'package:pokemon_go/widgets/show_map.dart';

import './models/person.dart';
import './widgets/info_page.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  SystemChrome.setPreferredOrientations([
    DeviceOrientation.portraitUp,
    DeviceOrientation.portraitDown,
  ]);
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Aflevering',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        accentColor: Colors.blueAccent,
        scaffoldBackgroundColor: Colors.blueAccent[100],
        textTheme: ThemeData.light().textTheme.copyWith(
              bodyText1: TextStyle(
                fontSize: 20,
              ),
              bodyText2: TextStyle(
                fontSize: 16,
              ),
            ),
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

List<Person> toBeUsed = [];

Future<List<Person>> fetchPeople() async {
  final response =
      await http.get('https://randomuser.me/api/?results=50&nat=DK');
  List<Person> people = [];
  if (response.statusCode == 200) {
    var jsonData = json.decode(response.body);
    List<dynamic> jsonPeople = jsonData['results'];
    for (int i = 0; i < jsonPeople.length; i++) {
      var newPerson = jsonPeople[i];
      people.add(Person.fromJson(newPerson));
      toBeUsed.add(Person.fromJson(newPerson));
    }
  }
  return people;
}

class _MyHomePageState extends State<MyHomePage> {
  Future<List<Person>> futureRandomUserList;

  @override
  void initState() {
    super.initState();
    futureRandomUserList = fetchPeople();
  }

  void _showInformation(Person person, BuildContext ctx) {
    showModalBottomSheet(
      context: ctx,
      backgroundColor: Colors.white,
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.only(
          topLeft: Radius.circular(50),
          topRight: Radius.circular(50),
        ),
      ),
      builder: (_) {
        return GestureDetector(
          // Making sure the popup doesnt close automatically. Instead when we tap on the main page app it'll close
          onTap: () {},
          child: InfoPage(person: person),
          behavior: HitTestBehavior.opaque,
        );
      },
    );
  }

  void _showMap(BuildContext ctx) {
    Navigator.of(ctx).push(
      MaterialPageRoute(
        builder: (_) {
          return ShowMap(toBeUsed);
        },
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Tilfældige brugere!'),
        actions: <Widget>[
          IconButton(
            icon: Icon(
              Icons.map,
              color: Colors.white,
            ),
            onPressed: () => _showMap(context),
          )
        ],
      ),
      body: FutureBuilder(
          future: futureRandomUserList,
          builder: (context, snapshot) {
            if (snapshot.hasData) {
              return ListView.builder(
                itemCount: snapshot.data.length,
                itemBuilder: (context, index) {
                  Person person = snapshot.data[index];
                  return GestureDetector(
                    onTap: () => _showInformation(person, context),
                    child: Card(
                      child: ListTile(
                        title: Text(
                          '${person.name.title} ${person.name.first} ${person.name.last}',
                          style: Theme.of(context).textTheme.bodyText1,
                        ),
                        leading: FutureBuilder(
                          future: person.fetchImageUrl(),
                          builder: (context, snapshot) {
                            if (snapshot.hasData) {
                              return Image.network(snapshot.data);
                            } else {
                              return CircularProgressIndicator();
                            }
                          },
                        ),
                      ),
                    ),
                  );
                },
              );
            } else {
              return CircularProgressIndicator();
            }
          }),
    );
  }
}
