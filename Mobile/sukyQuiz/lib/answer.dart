import 'package:flutter/material.dart';

class Answer extends StatelessWidget {
  final Function
      selectHandler; // Final fortæller flutter, at den her property ikke ændres, efter den er initialiseret
  final String answerText;
  Answer(this.selectHandler, this.answerText);

  @override
  Widget build(BuildContext context) {
    return Container(
      width: double.infinity,
      child: RaisedButton(
        color: Colors.blueAccent,
        textColor: Colors.white,
        child: Text(answerText),
        onPressed:
            selectHandler, // Without () we add a pointer to the function, and not the result of the function
      ),
    );
  }
}
