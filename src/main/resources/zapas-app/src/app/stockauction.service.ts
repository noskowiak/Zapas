import { Injectable } from '@angular/core';
import {environment} from "../environments/environment";
import {HttpClient,HttpEvent} from "@angular/common/http";
import {Observable} from "rxjs";
import {Stockauction} from "./stockauction";


@Injectable({providedIn: 'root'})


export class StockauctionService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  public getAllStockAuction(): Observable<Stockauction[]> {
    return this.http.get<Stockauction[]>(`${this.apiServerUrl}/auction`)
  }

  public save(stockauction: Stockauction) {
    return this.http.post<Stockauction>(`${this.apiServerUrl}/auction/add`, stockauction);
  }

  deleteStockAuction(stockauction: Stockauction): Observable<Stockauction> {
    `${this.apiServerUrl}/auction/${stockauction.id}`;
    return this.http.delete<Stockauction>(`${this.apiServerUrl}/auction/${stockauction.id}`);
  }

}
