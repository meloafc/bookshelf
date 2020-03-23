import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Login } from '../models/login';
import { Token } from '../models/token';
import { User } from '../models/user';
import { ENDPOINTS } from '../../../app/constants';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private usersUrl = environment.apiUrl + ENDPOINTS.USERS;

  constructor(private http: HttpClient) {

  }

  authenticate(login: Login): Observable<Token> {
    return this.http.post<Token>(this.usersUrl + '/authenticate', login);
  }

  register(user: User): Observable<User> {
    return this.http.post<User>(this.usersUrl + '/register', user);
  }

}
