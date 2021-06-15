import 'package:flutter/material.dart';

class Question extends StatelessWidget {
  final String
      questionText; // Final fortæller flutter, at den her property ikke ændres, efter den er initialiseret

  Question(
      this.questionText); // Positional argument. Named hvis der bruges curlybrackets

  @override
  Widget build(BuildContext context) {
    return Container(
      width: double.infinity, //Tager så meget width, som der er muligt.
      margin: EdgeInsets.all(10),
      child: Text(
        questionText,
        style: TextStyle(fontSize: 28),
        textAlign: TextAlign.center, //enum for TextAlign
      ),
    );
  }
}
