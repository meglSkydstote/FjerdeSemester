import 'package:flutter/material.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';

import 'pizzaria_model.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
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
    pizzarias.forEach((element) {
      _markers.add(Marker(
        markerId: MarkerId(element.shopName),
        draggable: false,
        infoWindow:
            InfoWindow(title: element.shopName, snippet: element.address),
        position: element.locationCoords,
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
          title: Text('Maps Sample App'),
          backgroundColor: Colors.blue,
        ),
        body: GoogleMap(
          onMapCreated: _onMapCreated,
          mapType: _mapType,
          initialCameraPosition: CameraPosition(
            target: _center,
            zoom: 16.0,
            tilt: 30,
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
