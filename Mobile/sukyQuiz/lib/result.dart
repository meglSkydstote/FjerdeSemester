import 'package:flutter/material.dart';

class Result extends StatelessWidget {
  final int totalScore;
  final Function resetHandler;

  Result(this.totalScore, this.resetHandler);

  String get resultPhrase {
    String resultText;
    if (totalScore <= 8) {
      resultText = 'You are awesome and hot';
    } else if (totalScore <= 18) {
      resultText = 'You pretty likeable';
    } else if (totalScore <= 24) {
      resultText = 'Meh';
    } else {
      resultText = 'Awful';
    }
    return resultText;
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      width: double.infinity,
      margin: EdgeInsets.all(50),
      child: Column(
        children: <Widget>[
          Text(
            resultPhrase,
            style: TextStyle(
              fontSize: 36,
              fontWeight: FontWeight.bold,
            ),
            textAlign: TextAlign.center,
          ),
          FlatButton(
            child: Text('Restart Quiz!'),
            color: Colors.blueAccent,
            textColor: Colors.white,
            onPressed: resetHandler,
          ),
        ],
      ),
    );
  }
}
