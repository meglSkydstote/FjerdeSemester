import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'Frontpage.dart';
import 'addMessage.dart';
import 'modelController.dart';
import 'userController.dart';
import 'package:provider/provider.dart';
import 'loginPage.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();

  runApp(
    MultiProvider(
      providers: [
        ChangeNotifierProvider(
            create: (BuildContext context) => ModelController()),
        Provider(create: (BuildContext context) => UserController()),
      ],
      child: MyApp(),
    ),
  );
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: Frontpage(),
      routes: {
        '/addMessage': (BuildContext context) => AddMessage(),
        '/login': (BuildContext context) => LoginPage(),
      },
    );
  }
}

