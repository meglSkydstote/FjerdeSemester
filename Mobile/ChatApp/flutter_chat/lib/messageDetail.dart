import 'package:flutter/material.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';
import 'model.dart';

class MessageDetail extends StatefulWidget {
  MessageDetail({Key? key, required this.message}) : super(key: key);
  final Message message;
  @override
  _MessageDetailState createState() => _MessageDetailState(message: message);
}

class _MessageDetailState extends State<MessageDetail> {
  late GoogleMapController mapController;
  MapType _currentMapType = MapType.normal;
  Message? message;
  Set<Marker>? _markers;
  LatLng? _center;

  _MessageDetailState({this.message}) {
    _markers = {
      Marker(
        markerId: MarkerId('${message?.id}'),
        position: LatLng(message?.location?.latitude ?? 0,
            message?.location?.longtitude ?? 0),
        infoWindow: InfoWindow(
          title: '${message?.message}',
          snippet: '${message?.owner} ${message?.date}',
        ),
      ),
    };
    
    _center = LatLng(
        message?.location?.latitude ?? 0, message?.location?.longtitude ?? 0);
  }

  void _onMapCreated(GoogleMapController controller) {
    mapController = controller;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('${message?.message}'),
      ),
      body: GoogleMap(
        onMapCreated: _onMapCreated,
        mapType: _currentMapType,
        markers: _markers!,
        initialCameraPosition: CameraPosition(
          target: _center!,
          zoom: 15.0,
          tilt: 90,
        ),
      ),
    );
  }
}
