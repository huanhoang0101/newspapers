import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Newspaper } from '../class/newspaper';

@Injectable({
  providedIn: 'root'
})
export class DetailNewspaperService {

  private baseUrl = "http://localhost:8080/api/detail/get";

  constructor(private httpClient: HttpClient) { }

  getDetailNewspaper(id: number): Observable<Newspaper> {
    return this.httpClient.get<Newspaper>(`${this.baseUrl}/${id}`);
  }
}
