import { Injectable } from '@angular/core';
import {environment} from "../environments/environment";
import {HttpClient, HttpEvent} from "@angular/common/http";
import {Observable} from "rxjs";
import {Stockbasement} from "./stockbasement";

@Injectable({providedIn: 'root'})

export class StockbasementService {

  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) {

  }


  public getAllStockBasement(): Observable<Stockbasement[]> {
    return this.http.get<Stockbasement[]>(`${this.apiServerUrl}/basement`)
  }

  public save(stockbasement: Stockbasement) {
    return this.http.post<Stockbasement>(`${this.apiServerUrl}/basement/add`, stockbasement);
  }

  deleteStockBasement(stockbasement: Stockbasement): Observable<Stockbasement> {
    `${this.apiServerUrl}/basement/${stockbasement.id}`;
    return this.http.delete<Stockbasement>(`${this.apiServerUrl}/basement/${stockbasement.id}`);
  }

}
