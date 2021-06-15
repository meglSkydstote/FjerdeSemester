import 'package:http/http.dart' as http;
import 'package:google_maps_flutter/google_maps_flutter.dart';

class Person {
  final Name name;
  final PictureUrl pictureUrl;
  final String gender;
  final String email;
  final Location location;
  final LatLng coords;

  Person({
    this.name,
    this.pictureUrl,
    this.gender,
    this.email,
    this.location,
    this.coords,
  });

  factory Person.fromJson(Map<String, dynamic> jsonData) {
    return Person(
      name: Name.fromJson(jsonData['name']),
      pictureUrl: PictureUrl.fromJson(jsonData['picture']),
      gender: jsonData['gender'],
      email: jsonData['email'],
      location: Location.fromJson(jsonData['location']),
      coords: LatLng(
          double.parse(jsonData["location"]["coordinates"]["latitude"]),
          double.parse(jsonData["location"]["coordinates"]["longitude"])),
    );
  }

  Future<String> fetchImageUrl() async {
    final response = await http.get(this.pictureUrl.url);
    if (response.statusCode == 200) {
      return this.pictureUrl.url;
    } else {
      return '';
    }
  }
}

class Name {
  final String title;
  final String first;
  final String last;

  Name({this.title, this.first, this.last});

  factory Name.fromJson(Map<String, dynamic> jsonData) {
    return Name(
      title: jsonData['title'],
      first: jsonData['first'],
      last: jsonData['last'],
    );
  }
}

class PictureUrl {
  final String url;

  PictureUrl({this.url});

  factory PictureUrl.fromJson(Map<String, dynamic> jsonData) {
    return PictureUrl(
      url: jsonData['medium'],
    );
  }
}

class Location {
  final Street street;
  final String city;
  final String state;
  final String country;
  final num postcode;

  Location({this.street, this.city, this.state, this.country, this.postcode});

  factory Location.fromJson(Map<String, dynamic> jsonData) {
    return Location(
      street: Street.fromJson(jsonData['street']),
      city: jsonData['city'],
      state: jsonData['state'],
      country: jsonData['country'],
      postcode: jsonData['postcode'],
    );
  }
}

class Street {
  final num number;
  final String name;

  Street({this.number, this.name});

  factory Street.fromJson(Map<String, dynamic> jsonData) {
    return Street(
      number: jsonData['number'],
      name: jsonData['name'],
    );
  }
}
