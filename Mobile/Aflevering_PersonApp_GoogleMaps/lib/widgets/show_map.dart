import 'package:flutter/material.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';
import '../models/person.dart';

class ShowMap extends StatefulWidget {
  final List<Person> people;
  ShowMap(this.people);

  @override
  _ShowMap createState() => _ShowMap(people);
}

class _ShowMap extends State<ShowMap> {
  final List<Person> persons;
  _ShowMap(this.persons);

  GoogleMapController mapController;

  final LatLng _center = const LatLng(56.053323, 10.211052);
  MapType _mapType = MapType.normal;
  List<Marker> _markers = [];

  void _onMapCreated(GoogleMapController controller) {
    mapController = controller;
  }

  @override
  void initState() {
    super.initState();
    persons.forEach((person) {
      _markers.add(Marker(
        markerId: MarkerId(
            '${person.name.title} ${person.name.first} ${person.name.last}'),
        draggable: false,
        infoWindow: InfoWindow(
            title:
                '${person.name.title} ${person.name.first} ${person.name.last}',
            snippet:
                '${person.location.city} - ${person.location.postcode} {person.location.street.name} ${person.location.street.number}'),
        position: person.coords,
      ));
    });
  }

  void _onMapTypeButtonPressed() {
    setState(() {
      _mapType =
          _mapType == MapType.normal ? MapType.satellite : MapType.normal;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Show users'),
          actions: <Widget>[
            IconButton(
              icon: Icon(Icons.arrow_back),
              onPressed: () => Navigator.of(context).pop(),
            ),
          ],
        ),
        body: GoogleMap(
          onMapCreated: _onMapCreated,
          mapType: _mapType,
          initialCameraPosition: CameraPosition(
            target: _center,
            zoom: 1,
            tilt: 10,
          ),
          markers: Set.from(_markers),
        ),
        floatingActionButton: FloatingActionButton(
          child: const Icon(Icons.map, size: 36.0),
          onPressed: _onMapTypeButtonPressed,
          backgroundColor: Colors.blue,
        ),
      ),
    );
  }
}
