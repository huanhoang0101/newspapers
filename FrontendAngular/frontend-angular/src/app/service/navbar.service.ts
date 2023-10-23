import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from '../class/category-navbar';

@Injectable({
  providedIn: 'root'
})
export class NavbarService {

  private baseUrl = "http://localhost:8080/api/cate/get";

  constructor(private httpClient: HttpClient) { }

  getCategoryList(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(`${this.baseUrl}`);
  }
}
