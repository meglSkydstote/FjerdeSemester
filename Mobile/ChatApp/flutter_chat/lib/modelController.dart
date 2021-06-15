import 'package:flutter/material.dart';
import 'databaseService.dart';
import 'locationService.dart';
import 'model.dart';

class ModelController extends ChangeNotifier {
  late List<Message> _messages = [];

  final DatabaseService _dbService = DatabaseService();
  final LocationService _locationService = LocationService();

  ModelController() {
    _dbService.chatStream().listen((snapshot) {
      _messages.clear();
      snapshot.docs.forEach((message) {
        _messages.add(Message.fromFirestore(message));
      });
      notifyListeners();
    });
  }

  int get numberOfMessages {
    return _messages.length;
  }

  Message getMessage(int index) {
    return _messages[index];
  }

  add({required Message message}) async {
    var locationData = await _locationService.getLocation();
    if (locationData != null) {
      message.addLocation(locationData);
    }
    _messages.add(message);
    _dbService.add(message: message);
    notifyListeners();
  }
}
