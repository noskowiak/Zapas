import { Injectable } from '@angular/core';
import {environment} from "../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Stockgarage} from "./stockgarage";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class StockgarageService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {

  }


  public getAllStockGarage(): Observable<Stockgarage[]> {
    return this.http.get<Stockgarage[]>(`${this.apiServerUrl}/garage`)
  }

  public save(stockgarage: Stockgarage) {
    return this.http.post<Stockgarage>(`${this.apiServerUrl}/garage/add`, stockgarage);
  }

  deleteStockGarage(stockgarage: Stockgarage): Observable<Stockgarage> {
    `${this.apiServerUrl}/garage/${stockgarage.id}`;
    return this.http.delete<Stockgarage>(`${this.apiServerUrl}/garage/${stockgarage.id}`);
  }

}
