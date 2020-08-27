import { Injectable } from '@angular/core';
import { DatePipe } from '@angular/common';
import { Data } from '../interface/data';
import { Observable, of } from 'rxjs';
import { environment } from '../../environments/environment';
import { HttpHeaders, HttpClient } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class DataService {
  constructor(private datePipe: DatePipe, private httpClient: HttpClient) {}

  transformDate(date: string) {
    return this.datePipe.transform(date, 'yyyy-MM-dd');
  }

  sendPostRequest(data: Object, endpoint: string): Observable<Object> {
    const API_REST_SERVER = environment.apiURL + endpoint;
    return this.httpClient.post(API_REST_SERVER, data);
  }
}
