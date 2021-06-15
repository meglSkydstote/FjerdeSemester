import 'package:google_maps_flutter/google_maps_flutter.dart';

class Pizzaria {
  String shopName;
  String address;
  String description;
  LatLng locationCoords;

  Pizzaria({
    this.shopName,
    this.address,
    this.description,
    this.locationCoords,
  });
}

final List<Pizzaria> pizzarias = [
  Pizzaria(
    shopName: "Beder Pizzaria",
    address: "Beder Landevej 41, 8330 Beder",
    description: "Takeway Junkfood!",
    locationCoords: LatLng(56.0580134425505, 10.203686127207483),
  ),
  Pizzaria(
    shopName: "Royal Pizza Beder",
    address: "Kirkebakken 4, 8330 Beder",
    description: "https://www.royalpizzabeder.dk/",
    locationCoords: LatLng(56.05885565322527, 10.206451886031074),
  ),
];
