import { Injectable } from '@angular/core';
import {environment} from "../environments/environment";
import {Observable} from "rxjs";
import {HttpClient, HttpEvent} from "@angular/common/http";
import {User} from "./user";


@Injectable({providedIn: 'root'})

export class UserService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.apiServerUrl}/user`);
  }

  public save(user: User) {
    return this.http.post<User>(`${this.apiServerUrl}/user`, user);
  }


}
