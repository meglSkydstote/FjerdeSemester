import 'package:flutter/material.dart';

import './quiz.dart';
import './result.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _MyAppState();
  }
}

class _MyAppState extends State<MyApp> {
  final _questions = const [
    {
      'questionText': 'What\'s your favorite colour?',
      'answers': [
        {'text': 'Black', 'score': 7},
        {'text': 'Red', 'score': 5},
        {'text': 'Green', 'score': 1},
        {'text': 'White', 'score': 3}
      ],
    },
    {
      'questionText': 'What\'s your favorite animal?',
      'answers': [
        {'text': 'Cat', 'score': 0},
        {'text': 'Dog', 'score': 6},
        {'text': 'Horse', 'score': 10},
        {'text': 'Snake', 'score': 3}
      ],
    },
    {
      'questionText': 'What\'s your favorite anime?',
      'answers': [
        {'text': 'Black Clover', 'score': 3},
        {'text': 'AoT', 'score': 0},
        {'text': 'SDS', 'score': 2},
        {'text': 'Drifters', 'score': 5}
      ],
    },
    {
      'questionText': 'What\'s your favorite food?',
      'answers': [
        {'text': 'Lasagna', 'score': 3},
        {'text': 'Potato', 'score': 4},
        {'text': 'Hotdog', 'score': 6},
        {'text': 'Tomato Soup', 'score': 0}
      ],
    },
    {
      'questionText': 'What\'s your favorite car?',
      'answers': [
        {'text': 'Hyundai', 'score': 3},
        {'text': 'BMW', 'score': 6},
        {'text': 'Fiat', 'score': 10},
        {'text': 'Kia', 'score': 6}
      ],
    }, // Creating a map. Could use Map()
  ];

  var _questionIndex = 0; // Property (class variable = property)
  var _totalScore = 0;

  void _resetQuiz() {
    setState(() {
      _questionIndex = 0;
      _totalScore = 0;
    });
  }

  void _answerQuestion(int score) {
    _totalScore += score;
    setState(() {
      _questionIndex = _questionIndex + 1;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
          appBar: AppBar(
            title: Text('Suky Quiz App!'),
            backgroundColor: Colors.blueAccent,
          ),
          body: _questionIndex < _questions.length
              ? Quiz(
                  answerQuestion: _answerQuestion,
                  questionIndex: _questionIndex,
                  questions: _questions,
                )
              : Result(_totalScore, _resetQuiz)),
    );
  }
}
