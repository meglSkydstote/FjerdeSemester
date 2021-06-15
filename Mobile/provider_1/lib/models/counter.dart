import 'package:flutter/cupertino.dart';

class Counter extends ChangeNotifier {
  num _counter;

  int get counter => _counter;

  Counter(this._counter);

  void incrementCounter() {
    _counter++;
    notifyListeners();
  }
}
