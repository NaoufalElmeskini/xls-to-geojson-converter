import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpResponse} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class FileService {

  constructor(private httpClient: HttpClient) { }

  traiterFichier(fichierATraiter: File): Observable<any> {
    let url = 'httpClient://localhost:8080/conversion';
    let formData: FormData = new FormData();
    formData.append('file', fichierATraiter, fichierATraiter.name);

    let objectObservable = this.httpClient.post(url, formData);
    objectObservable.subscribe(data => {
      console.log('post result:');
      console.log(data);
    })
    return objectObservable;
  }

  // getFichier(fichierATraiter: File): Observable<GeoJsonResult> {
  //   let url = 'httpClient://localhost:8080/conversion';
  //
  //   let resultObjectObservable = this.httpClient.get<GeoJsonResult>(url, {responseType: 'blob'});
  //   resultObjectObservable.subscribe(data => {
  //     console.log('data: ');
  //     console.log(data);
  //   })
  //   return resultObjectObservable;
  // }
}
