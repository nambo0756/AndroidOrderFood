package com.example.asus.androideatit.Controller;

import com.example.asus.androideatit.Model.DownloadPolyLine;
import com.example.asus.androideatit.Model.ParserPolyline;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;


import java.util.List;
import java.util.concurrent.ExecutionException;



public class DanDuongToiQuanAnController {
    ParserPolyline parserPolyline;
    DownloadPolyLine downloadPolyLine;

    public  DanDuongToiQuanAnController(){

    }

    public void HienThiDanDuongToiQuanAn(GoogleMap googleMap, String duongdan){
        parserPolyline = new ParserPolyline();
        downloadPolyLine = new DownloadPolyLine();
        downloadPolyLine.execute(duongdan);

        try {
            String dataJSON = downloadPolyLine.get();
            List<LatLng> latLngList = parserPolyline.LayDanhSachToaDo(dataJSON);

            PolylineOptions polylineOptions = new PolylineOptions();
            for (LatLng toado : latLngList){
                polylineOptions.add(toado);
            }

            Polyline polyline = googleMap.addPolyline(polylineOptions);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
