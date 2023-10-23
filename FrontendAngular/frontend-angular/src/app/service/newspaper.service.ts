import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Newspaper } from '../class/newspaper';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NewspaperService {

  private baseUrl = "http://localhost:8080/api/";

  constructor(private httpClient: HttpClient) { }

  getNewspaper(): Observable<Newspaper[]> {
    return this.httpClient.get<Newspaper[]>(this.baseUrl + 'get');
  }

  crawlNewspapers(): Observable<Newspaper[]> {
    return this.httpClient.get<Newspaper[]>(this.baseUrl + 'ok');
  }
}
